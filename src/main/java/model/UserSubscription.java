package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name=UserSubscription.GET_ALL_USERSUBSCRIPTIONS, query="SELECT u FROM User u")
@NamedQuery(name=UserSubscription.GET_ALL_USERSUBSCRIPTIONS_IDS, query="SELECT u.id FROM User u")
@NamedQuery(name=UserSubscription.GET_USERSUBSCRIPTIONS_COUNT, query="SELECT COUNT(u) FROM User u")
public class UserSubscription extends GenericEntity{

	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_USERSUBSCRIPTIONS = "Answer.getAllUserSubscriptions";
	public static final String GET_ALL_USERSUBSCRIPTIONS_IDS = "Answer.getAllUserSubscriptionsIds";
	public static final String GET_USERSUBSCRIPTIONS_COUNT = "Answer.getUserSubscriptionsCount";
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private TrainingSession trainingSession;
	
	@OneToMany
	private List<Answer> answers = new ArrayList<Answer>();

	public UserSubscription() {
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public TrainingSession getTrainingSession() {
		return trainingSession;
	}

	public void setTrainingSession(TrainingSession trainingSession) {
		this.trainingSession = trainingSession;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	
	
}
