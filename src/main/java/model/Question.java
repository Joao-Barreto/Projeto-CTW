package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = Question.GET_ALL_QUESTIONS, query = "SELECT q FROM Question q")
@NamedQuery(name = Question.GET_ALL_QUESTIONS_IDS, query = "SELECT q.id FROM Question q")
@NamedQuery(name = Question.GET_QUESTIONS_COUNT, query = "SELECT COUNT(q) FROM Question q")
public class Question extends GenericEntity {

	private static final long serialVersionUID = 1L;

	public static final String GET_ALL_QUESTIONS = "Question.getAllQuestions";
	public static final String GET_ALL_QUESTIONS_IDS = "Question.getAllQuestionsIds";
	public static final String GET_QUESTIONS_COUNT = "Question.getQuestionsCount";

	private String question;
	private String questionType;

	@ManyToMany
	private List<Questionnaire> questionnaireList = new ArrayList<Questionnaire>();

	public Question() {

	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public List<Questionnaire> getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(List<Questionnaire> questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
