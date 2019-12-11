package repositories;

import javax.enterprise.context.ApplicationScoped;

import model.TrainingSession;

@ApplicationScoped
public class TrainingSessionRepository extends GenericEntityRepository<TrainingSession>{

	@Override
	protected Class<TrainingSession> getEntityClass() {
		return TrainingSession.class;
	}
	
	@Override
	protected String getAllEntityQueryName() {
		return TrainingSession.GET_ALL_TRAININGSESSIONS;
	}
	
	@Override
	protected String getAllEntityIdsQueryName() {
		return TrainingSession.GET_ALL_TRAININGSESSIONS_IDS;
	}

	@Override
	protected String getCountQueryName() {
		return TrainingSession.GET_TRAININGSESSIONS_COUNT;
	}

}