package repositories;

import javax.enterprise.context.ApplicationScoped;

import model.Question;

@ApplicationScoped
public class QuestionRepository extends GenericEntityRepository<Question>{

	@Override
	protected Class<Question> getEntityClass() {
		return Question.class;
	}
	
	@Override
	protected String getAllEntityQueryName() {
		return Question.GET_ALL_QUESTIONS;
	}
	
	@Override
	protected String getAllEntityIdsQueryName() {
		return Question.GET_ALL_QUESTIONS_IDS;
	}

	@Override
	protected String getCountQueryName() {
		return Question.GET_QUESTIONS_COUNT;
	}
	
	public Question editEntity(Question editedEntity) {
		System.out.println("ENTREI NO REPOSITORY"+editedEntity.toString());
		return entityManager.merge(editedEntity);
	}

}
