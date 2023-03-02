package datamodels;

import java.util.ArrayList;

/** Datamodel to accomodate 'Training' object
 * 
 * @author Saranya
 *
 */

public class Training {
	
	private int id; // unique identifier
	private String name;
	private int totalSpots; 
	private boolean isOpen=true;
	
	private Skill skill;
	
	private ArrayList<Teacher> enrollments = new ArrayList<>(); // List of teachers already enrolled for the training
	
	/** constructor method
	 * 
	 * @param id
	 * @param name
	 */
	public Training(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	/** Setter and getter methods for 'id'
	 * 
	 * @param id
	 */
	public void setTrainingID(int id) {
		this.id=id;
	}
	
	public int getTrainingID() {
		return id;
	}
	
	/** setter and getter methods for 'name'
	 * 
	 * @param name
	 */
	public void setTrainingName(String name) {
		this.name=name;
	}
	
	public String getTrainingName() {
		return name;
	}
	
	/** setter and getter methods for associated 'skill'
	 * 
	 * @param skill
	 */
	
	public void setSkill(Skill skill) {
		this.skill=skill;
	}
	
	public Skill getSkill() {
		return skill;
	}
	
	
	
	/** setter and getter methods for 'totalSpots'
	 * 
	 * @param totalSpots
	 */
	public void setTotalSpots(int totalSpots) {
		this.totalSpots=totalSpots;
	}
	
	public int getTotalSpots() {
		return totalSpots;
	}
	
		
	/** setter and getter methods for 'isOpen'
	 * 
	 * @param isOpen
	 */
	public void setTrainingStatus(boolean isOpen) {
		this.isOpen=isOpen;
	}
	
	public boolean isTrainingOpen() {
		return isOpen;
	}
	
	/** setter and getter methods for 'enrollments'
	 * 
	 * @param enrollments
	 */
	public void setEnrollmentList(ArrayList<Teacher> enrollments) {
		this.enrollments=enrollments;
	}
	
	public ArrayList<Teacher> getEnrollmentList() {
		return enrollments;
	}
	
	/** add a teacher to the enrollment list
	 * 
	 * @param teacher
	 */
	public void enrolTeacher(Teacher teacher) {
		this.enrollments.add(teacher);
		
		// check the enrolled count and update training status
		if(enrollments.size()==totalSpots)
			setTrainingStatus(false);
	}
	
	public String toString() {
		String text="\n\tEnrolled list: ";
		for(Teacher teacher:enrollments)
		{
			text=text+"\n\t "+teacher;
		}
		
		text="id: "+id+", name: "+name+", totalSpots: "+totalSpots+", isOpen: "+isOpen+" ,"+skill+text;
		
		
		return text;
	}
	
	

}
