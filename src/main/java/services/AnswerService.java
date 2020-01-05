package services;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import model.Answer;
import repositories.AnswerRepository;

@RequestScoped
public class AnswerService extends GenericEntityService<AnswerRepository, Answer>{

	@Transactional
	public Answer updateEntity(long id, Answer Entity) throws Exception {
		return null;
	}

	@Transactional
	public Answer createAnswer(Answer entity) {
		return repository.createEntity(entity);
	}

}
