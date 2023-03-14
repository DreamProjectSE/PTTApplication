package datamodels;

import java.util.ArrayList;

/** Datamodel to accomodate 'Skill' object
 * 
 * @author Saranya
 *
 */

public class Skill {
	
	private int id; // unique identifier
	private String name;
	
	/** constructor method
	 * 
	 * @param id
	 * @param name
	 */
	public Skill(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	/** Setter and getter methods for 'id'
	 * 
	 * @param id
	 */
	public void setSkillID(int id) {
		this.id=id;
	}
	
	public int getSkillID() {
		return id;
	}
	
	/** setter and getter methods for 'name'
	 * 
	 * @param name
	 */
	public void setSkillName(String name) {
		this.name=name;
	}
	
	public String getSkillName() {
		return name;
	}
	

	public String toString() {
		return "\nid: "+id+", name: "+name;
	}

}
