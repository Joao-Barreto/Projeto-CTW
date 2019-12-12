package services;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;

import model.TrainingSession;
import repositories.TrainingSessionRepository;

@RequestScoped
public class TrainingSessionService extends GenericEntityService<TrainingSessionRepository, TrainingSession>{

	@Override
	public TrainingSession updateEntity(long id, TrainingSession Entity) throws Exception {
		return null;
	}

	public TrainingSession createTrainingSession(TrainingSession entity) {
		return repository.createEntity(entity);
	}

	public Collection<TrainingSession> listAllDailyTrainingSessions() {
		return repository.listAllDailyTrainingSessions();
	}
}
