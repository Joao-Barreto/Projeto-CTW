package services;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import model.Question;
import repositories.QuestionRepository;

@RequestScoped
public class QuestionService extends GenericEntityService<QuestionRepository, Question>{

	@Override
	@Transactional
	public Question updateEntity(long id, Question Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Question createQuestion(Question entity) {
		return repository.createEntity(entity);
	}

}
