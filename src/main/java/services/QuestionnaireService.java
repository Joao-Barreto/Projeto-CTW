package services;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import model.Questionnaire;
import repositories.QuestionnaireRepository;

@RequestScoped
public class QuestionnaireService extends GenericEntityService<QuestionnaireRepository, Questionnaire>{

	@Transactional
	public Questionnaire updateEntity(long id, Questionnaire Entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Questionnaire createQuestionnaire(Questionnaire entity) {
		return repository.createEntity(entity);
	}

}
