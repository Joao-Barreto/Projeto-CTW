package services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import model.TrainingSession;
import model.dto.TrainingSessionDTO;
import repositories.TrainingSessionRepository;

@RequestScoped
public class TrainingSessionService extends GenericEntityService<TrainingSessionRepository, TrainingSession>{

	@Inject
	UserSubscriptionService userSubscriptionService;
	
	@Transactional
	public TrainingSessionDTO updateEntity(long id, TrainingSessionDTO entity) throws Exception {
		
		
		return convertToTrainingSessionDTO(repository.editEntity(convertToTrainingSession(entity)));
	}

	@Transactional
	public TrainingSession createTrainingSession(TrainingSessionDTO entity) throws ParseException {
		Date d = entity.getSubmissionDateConverted(entity.getSessionDate());
		TrainingSession ts = new TrainingSession();
		Timestamp tsDate = new Timestamp(d.getTime());
		
		ts.setTitle(entity.getTitle());
		ts.setLocation(entity.getLocation());
		ts.setCapacity(entity.getCapacity());
		ts.setRequirements(entity.getRequirements());
		ts.setSessionDate(tsDate);
		ts.setDuration(entity.getDuration());
		ts.setDescription(entity.getDescription());
		TrainingSession returnTs = repository.createEntity(ts);
		
//		createInstructor(entity.getInstructor(),returnTs.getId());	
//		System.out.println("RETURN TRAININGESSIO: " + returnTs.toString());
		return returnTs;
	}

	@Transactional
	public Collection<TrainingSession> listAllTodayTrainingSessions() {
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DAY_OF_MONTH, 1);
		Timestamp todayTS = new Timestamp(today.getTime().getTime());		
		return repository.listAllTodayTrainingSessions(todayTS);
	}

	@Transactional
	public Collection<TrainingSession> listAllIntervalTrainingSessions(String interval) throws ParseException {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		cal.setTime(sdf.parse(interval));
		Timestamp calTS = new Timestamp(cal.getTime().getTime());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		Timestamp calPlusOneTS = new Timestamp(cal.getTime().getTime());		
		return repository.listAllIntervalTrainingSessions(calTS,calPlusOneTS);
	}
	
	@Transactional
	public void createInstructor(long l, long m) {
		userSubscriptionService.setSessionInstructor(l,m);
	}

	@Transactional
	public Collection<TrainingSession> getSessionsByUserId(long userId) {
		return repository.getSessionsByUserId(userId);
	}

	@Transactional
	public Collection<TrainingSession> listAllPastTrainingSessionsSubscribed(long userId) {

		return repository.listAllPastTrainingSessionsSubscribed(userId);
	}

	@Transactional
	public Collection<TrainingSession> listAllUnansweredTrainingSessions(long userId) {
		
		return repository.listAllUnansweredTrainingSessions(userId);
	}
	
	@Transactional
	public Collection<TrainingSession> getNextSessionsEnrolled(long userId) {
		// TODO Auto-generated method stub
		return repository.getNextSessionsEnrolled(userId);
	}
	
	 public TrainingSessionDTO convertToTrainingSessionDTO(TrainingSession ts){
		 TrainingSessionDTO tsDTO = new TrainingSessionDTO();
	    	tsDTO.setId(ts.getId());
	    	tsDTO.setCapacity(ts.getCapacity());
	    	tsDTO.setDescription(ts.getDescription());
	    	tsDTO.setDuration(ts.getDuration());
	    	tsDTO.setInstructor(0);
	    	tsDTO.setLocation(ts.getLocation());
	    	tsDTO.setRequirements(ts.getRequirements());
	    	tsDTO.setSessionDate(ts.getSessionDate().toString());
	    	//userDTO.setProgress(user.getProgress()); //TODO
	    	return tsDTO;
	    }
	    
	    public TrainingSession convertToTrainingSession(TrainingSessionDTO tsDTO) throws ParseException{
	    	Date d = tsDTO.getSubmissionDateConverted(tsDTO.getSessionDate());
			TrainingSession ts = new TrainingSession();
			Timestamp tsDate = new Timestamp(d.getTime());
			
			ts.setTitle(tsDTO.getTitle());
			ts.setLocation(tsDTO.getLocation());
			ts.setCapacity(tsDTO.getCapacity());
			ts.setRequirements(tsDTO.getRequirements());
			ts.setSessionDate(tsDate);
			ts.setDuration(tsDTO.getDuration());
			ts.setDescription(tsDTO.getDescription());
			

	    	return ts;
	    }

		

}
