package services;

import javax.enterprise.context.RequestScoped;

import model.TrainingSession;
import repositories.TrainingSessionRepository;

@RequestScoped
public class TrainingSessionService extends GenericEntityService<TrainingSessionRepository, TrainingSession>{

	@Override
	public TrainingSession updateEntity(long id, TrainingSession Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
