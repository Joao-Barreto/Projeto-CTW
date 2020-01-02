package services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import model.User;
import model.dto.UserDTO;
import repositories.UserRepository;
import utils.PasswordUtils;

@RequestScoped
public class UserService extends GenericEntityService<UserRepository, User>{
	
	private final String UPLOADED_FILE_PATH = "/Users/alunomanha/Documents/";// mudar o caminho da pasta
	
	@Override
	public User updateEntity(long id, User Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
    public User findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }
	
	@Transactional
	public void createEntity(UserDTO userDTO) throws Exception{
		String email = userDTO.getEmail();

		if(!isValidEmailAddress(email)) {
			throw new BadRequestException("Invalid email");
		}
		
		
		User user = new User();
		
		//password->(hash, salt)
		String password = userDTO.getPassword();
		
		String[] hashCode = passwordToHashcode(password);
		
		//set fields to Entity
        user.setHashcode(hashCode[0]);
        user.setSalt(hashCode[1]);
        user.setEmail(email);
        user.setName(userDTO.getName());
		
        //Adicionar entity ao repositorio
		repository.createEntity(user);
	}
	
	@Transactional
	public Collection<User> getUserSubscribedBySessionId(long sessionId) {

		return repository.getUserSubscribedBySessionId(sessionId);
	}
	
	
	public User checkIfUserValid(UserDTO userDTO, String password) throws Exception {            
        //User valid if both username and password are valid
        return checkIfPasswordValid(userDTO, password);
    }

    public User checkIfPasswordValid(UserDTO userDTO, String password) throws Exception {
        User myUser=repository.findUserByEmail(userDTO.getEmail());
        String key=myUser.getHashcode();
        String salt=myUser.getSalt();

        if(!PasswordUtils.verifyPassword(password, key, salt))
            throw new BadRequestException("Invalid Password");
        return myUser;
    }
    
    

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////Password-Methods//////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String[] passwordToHashcode(String password) {
        String salt = PasswordUtils.generateSalt(50).get();
        String key = PasswordUtils.hashPassword(password, salt).get();
        String[] result= {key, salt};
        return result;
    }
    
    public static boolean isValidEmailAddress(String email) {
    	   boolean result = true;
    	   try {
    	      InternetAddress emailAddr = new InternetAddress(email);
    	      emailAddr.validate();
    	   } catch (AddressException ex) {
    	      result = false;
    	   }
    	   return result;
    	}

	
    public String saveImage(long id,MultipartFormDataInput input) {
		String fileName = "";
		
		Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
		List<InputPart> inputParts = uploadForm.get("uploadedFile");

		for (InputPart inputPart : inputParts) {

		 try {

			MultivaluedMap<String, String> header = inputPart.getHeaders();
			fileName = getFileName(header);

			//convert the uploaded file to inputstream
			InputStream inputStream = inputPart.getBody(InputStream.class,null);

			byte [] bytes = IOUtils.toByteArray(inputStream);
				
			//constructs upload file path
			fileName = UPLOADED_FILE_PATH + fileName;
				
			writeFile(bytes,fileName);
			
			//save na BD o path
			repository.updateImage(id,fileName);
				
			System.out.println("Done");

		  } catch (IOException e) {
			e.printStackTrace();
		  }

		}

		return "uploadFile is called, Uploaded file name : " + fileName;
		
	}
	
	private String getFileName(MultivaluedMap<String, String> header) {

		String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
		
		for (String filename : contentDisposition) {
			if ((filename.trim().startsWith("filename"))) {

				String[] name = filename.split("=");
				
				String finalFileName = name[1].trim().replaceAll("\"", "");
				return finalFileName;
			}
		}
		return "unknown";
	}

	//save to somewhere
	private void writeFile(byte[] content, String filename) throws IOException {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();

	}

}
