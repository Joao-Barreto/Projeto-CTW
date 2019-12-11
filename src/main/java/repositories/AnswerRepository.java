package repositories;

import javax.enterprise.context.ApplicationScoped;

import model.Answer;

@ApplicationScoped
public class AnswerRepository extends GenericEntityRepository<Answer>{

	@Override
	protected Class<Answer> getEntityClass() {
		// TODO Auto-generated method stub
		return Answer.class;
	}
	
	@Override
	protected String getAllEntityQueryName() {
		return Answer.GET_ALL_ANSWERS;
	}
	
	@Override
	protected String getAllEntityIdsQueryName() {
		// TODO Auto-generated method stub
		return Answer.GET_ALL_ANSWERS_IDS;
	}

	@Override
	protected String getCountQueryName() {
		// TODO Auto-generated method stub
		return null;
	}

}
