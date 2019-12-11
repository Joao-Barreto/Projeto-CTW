package services;

import javax.enterprise.context.RequestScoped;

import model.Question;
import repositories.QuestionRepository;

@RequestScoped
public class QuestionService extends GenericEntityService<QuestionRepository, Question>{

	@Override
	public Question updateEntity(long id, Question Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
