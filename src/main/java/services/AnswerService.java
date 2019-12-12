package services;

import javax.enterprise.context.RequestScoped;

import model.Answer;
import repositories.AnswerRepository;

@RequestScoped
public class AnswerService extends GenericEntityService<AnswerRepository, Answer>{

	@Override
	public Answer updateEntity(long id, Answer Entity) throws Exception {
		return null;
	}

	public Answer createAnswer(Answer entity) {
		return repository.createEntity(entity);
	}

}
