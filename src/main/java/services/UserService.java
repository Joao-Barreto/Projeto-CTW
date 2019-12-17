package services;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;

import model.User;
import model.dto.UserDTO;
import repositories.UserRepository;
import utils.PasswordUtils;

@RequestScoped
public class UserService extends GenericEntityService<UserRepository, User>{
	
	@Override
	public User updateEntity(long id, User Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
    public User findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }

//	@Transactional
//	public User consultEntityByEmailAndPassword(User user) {
//		return repository.consultEntityByEmailAndPassword(user);
//	}
	
	@Transactional
	public void createEntity(UserDTO userDTO) {
		
		String email = userDTO.getEmail();

		User user = new User();
		
		//password->(hash, salt)
		String password = userDTO.getPassword();
		
		String[] hashCode = passwordToHashcode(password);
		
		//set fields to Entity
        user.setHashcode(hashCode[0]);
        user.setSalt(hashCode[1]);
        user.setEmail(email);
		
        //Adicionar entity ao repositorio
		repository.createEntity(user);
		 

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

}
