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
	
	@Override
	public TrainingSession updateEntity(long id, TrainingSession Entity) throws Exception {
		return null;
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
	

}
