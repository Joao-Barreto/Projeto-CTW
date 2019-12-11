package model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name=TrainingSession.GET_ALL_TRAININGSESSIONS, query="SELECT ts FROM TrainingSession ts")
@NamedQuery(name=TrainingSession.GET_ALL_TRAININGSESSIONS_IDS, query="SELECT ts.id FROM TrainingSession ts")
@NamedQuery(name=TrainingSession.GET_TRAININGSESSIONS_COUNT, query="SELECT COUNT(ts) FROM TrainingSession ts")
public class TrainingSession extends GenericEntity{

	public static final String GET_ALL_TRAININGSESSIONS = "Answer.getAllTrainingSessions";
	public static final String GET_ALL_TRAININGSESSIONS_IDS = "Answer.getAllTrainingSessionsIds";
	public static final String GET_TRAININGSESSIONS_COUNT = "Answer.getTrainingSessionsCount";
	
	private static final long serialVersionUID = 1L;
	
		private String title;
		private String localization;
		private int capacity;
		private String requirements;
		
		public TrainingSession() {

		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getLocalization() {
			return localization;
		}

		public void setLocalization(String localization) {
			this.localization = localization;
		}

		public int getCapacity() {
			return capacity;
		}

		public void setCapacity(int capacity) {
			this.capacity = capacity;
		}

		public String getRequirements() {
			return requirements;
		}

		public void setRequirements(String requirements) {
			this.requirements = requirements;
		}

}