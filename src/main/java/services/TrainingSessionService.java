package services;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

import javax.enterprise.context.RequestScoped;

import model.TrainingSession;
import model.dto.TrainingSessionDTO;
import repositories.TrainingSessionRepository;

@RequestScoped
public class TrainingSessionService extends GenericEntityService<TrainingSessionRepository, TrainingSession>{

	@Override
	public TrainingSession updateEntity(long id, TrainingSession Entity) throws Exception {
		return null;
	}

	public TrainingSession createTrainingSession(TrainingSessionDTO entity) throws ParseException {
		Date d = entity.getSubmissionDateConverted(entity.getSessionDate());
		TrainingSession ts = new TrainingSession();
		
		ts.setTitle(entity.getTitle());
		ts.setLocalization(entity.getLocalization());
		ts.setCapacity(entity.getCapacity());
		ts.setRequirements(entity.getRequirements());
		ts.setSessionDate((Timestamp) d);
		
		return repository.createEntity(ts);
	}

	public Collection<TrainingSession> listAllDailyTrainingSessions() {
		return repository.listAllDailyTrainingSessions();
	}
	
	
}
