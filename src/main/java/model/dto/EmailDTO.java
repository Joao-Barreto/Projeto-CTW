package model.dto;

public class EmailDTO {

	private String title;
	private String instructorName;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	@Override
	public String toString() {
		return "EmailDTO [title=" + title + ", instructorName=" + instructorName + "]";
	}
}
