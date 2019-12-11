package repositories;

import javax.enterprise.context.ApplicationScoped;


import model.Questionnaire;

@ApplicationScoped
public class QuestionnaireRepository extends GenericEntityRepository<Questionnaire>{

	@Override
	protected Class<Questionnaire> getEntityClass() {
		return Questionnaire.class;
	}
	
	@Override
	protected String getAllEntityQueryName() {
		return Questionnaire.GET_ALL_QUESTIONNAIRES;
	}
	
	@Override
	protected String getAllEntityIdsQueryName() {
		return Questionnaire.GET_ALL_QUESTIONNAIRES_IDS;
	}

	@Override
	protected String getCountQueryName() {
		return Questionnaire.GET_QUESTIONNAIRES_COUNT;
	}

}
