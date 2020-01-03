package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name=UserSubscription.GET_ALL_USERSUBSCRIPTIONS, query="SELECT u FROM UserSubscription u")
@NamedQuery(name=UserSubscription.GET_ALL_USERSUBSCRIPTIONS_IDS, query="SELECT u.id FROM UserSubscription u")
@NamedQuery(name=UserSubscription.GET_USERSUBSCRIPTIONS_COUNT, query="SELECT COUNT(u) FROM UserSubscription u")
@NamedQuery(name=UserSubscription.GET_SESSION_INSTRUCTOR, query="SELECT us FROM UserSubscription us WHERE us.subType = 'instructor' AND us.trainingSession.id = :sessionId")
@NamedQuery(name=UserSubscription.GET_USERSCRIPTIONS_COUNT_BY_SESSION_ID,query="SELECT COUNT(us) FROM UserSubscription us WHERE us.trainingSession.id = :sessionId AND us.subType = 'attendee'")
@NamedQuery(name=UserSubscription.GET_IF_USER_SUBSCRIBED,query="SELECT us.id FROM UserSubscription us WHERE us.trainingSession.id = :sessionId AND us.user.id = :userId")
@NamedQuery(name=UserSubscription.GET_SUBSCRIPTION,query="SELECT us FROM UserSubscription us WHERE us.user.id = :userId AND us.trainingSession.id = :sessionId")
@NamedQuery(name=UserSubscription.GET_SUBSCRIPTION_BY_SESSION_ID,query="SELECT us FROM UserSubscription us WHERE us.trainingSession.id = :sessionId")
public class UserSubscription extends GenericEntity{

	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_USERSUBSCRIPTIONS = "UserSubscription.getAllUserSubscriptions";
	public static final String GET_ALL_USERSUBSCRIPTIONS_IDS = "UserSubscription.getAllUserSubscriptionsIds";
	public static final String GET_USERSUBSCRIPTIONS_COUNT = "UserSubscription.getUserSubscriptionsCount";
	public static final String GET_SESSION_INSTRUCTOR = "UserSubscription.getSessionInstructor";
	public static final String GET_USERSCRIPTIONS_COUNT_BY_SESSION_ID = "UserSubscription.getUserSubscriptionsCountBySessionId";

	public static final String GET_IF_USER_SUBSCRIBED = "UserSubscription.getIfUserSubscribed";

	public static final String GET_SUBSCRIPTION = "UserSubscription.getSubscription";

	public static final String GET_SUBSCRIPTION_BY_SESSION_ID = "UserSubscription.getSubscriptionBySessionId";
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private TrainingSession trainingSession;
	
	@OneToMany
	private List<Answer> answers = new ArrayList<Answer>();
	
	private String subType;
	private String attended = "Pending";

	public UserSubscription() {
		
	}

	public String getAttended() {
		return attended;
	}

	public void setAttended(String attended) {
		this.attended = attended;
	}

	public String getSubType() {
		return subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
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
