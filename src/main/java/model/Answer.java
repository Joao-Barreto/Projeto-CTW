package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;



@Entity
@NamedQuery(name=Answer.GET_ALL_ANSWERS, query="SELECT a FROM Answer a")
@NamedQuery(name=Answer.GET_ALL_ANSWERS_IDS, query="SELECT a.id FROM Answer a")
@NamedQuery(name=Answer.GET_ANSWERS_COUNT, query="SELECT COUNT(a) FROM Answer a")
public class Answer extends GenericEntity{

	private static final long serialVersionUID = 1L;

	public static final String GET_ALL_ANSWERS = "Answer.getAllAnswers";
	public static final String GET_ALL_ANSWERS_IDS = "Answer.getAllAnswersIds";
	public static final String GET_ANSWERS_COUNT = "Answer.getAnswersCount";
	
	private String answer;
	@ManyToOne
	private Question question;

	public Answer() {

	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}



}
 