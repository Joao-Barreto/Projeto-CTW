package model.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class TrainingSessionDTO extends BaseDTO{
	private static final SimpleDateFormat dateFormat
    = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	private String title;
	private String location;
	private int capacity;
	private String requirements;
	private String sessionDate;
	private String duration;
	private long instructor;
	
	public Date getSubmissionDateConverted(String timezone) throws ParseException {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        return dateFormat.parse(this.sessionDate);
    }
 
    public long getInstructor() {
		return instructor;
	}

	public void setInstructor(long instructor) {
		this.instructor = instructor;
	}

	public void setSubmissionDate(Date date, String timezone) {
        dateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        this.sessionDate = dateFormat.format(date);
	
}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(String sessionDate) {
		this.sessionDate = sessionDate;
	}

	public static SimpleDateFormat getDateformat() {
		return dateFormat;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
}
