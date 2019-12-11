package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name=Question.GET_ALL_QUESTIONS, query="SELECT q FROM Question q")
@NamedQuery(name=Question.GET_ALL_QUESTIONS_IDS, query="SELECT q.id FROM Question q")
@NamedQuery(name=Question.GET_QUESTIONS_COUNT, query="SELECT COUNT(q) FROM Question q")
public class Question extends GenericEntity{
	
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_QUESTIONS = "Answer.getAllQuestions";
	public static final String GET_ALL_QUESTIONS_IDS = "Answer.getAllQuestions\"Ids";
	public static final String GET_QUESTIONS_COUNT = "Answer.getQuestions\"Count";
	
	private String question;
	
	@ManyToMany
	private List<Questionnaire> questionnaireList = new ArrayList<Questionnaire>();

	public Question() {
		
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
}
