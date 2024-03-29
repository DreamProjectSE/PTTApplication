package datamodels;

/** Datamodel to accomodate 'Teacher' object
 * 
 * @author Praharsh and Mona
 *
 */

import java.util.ArrayList;

/**Interacts with: Administrator Stores Teacher objects after reading a file as input 
 * Teachers will be matched with Courses based on the Course Requirements and their skills
 * Will return Teacher objects and the toString() method will print their info
 * 
 *
 */

public class Teacher extends Staff {

	// Attributes
	private ArrayList<Skill> skills;
	private String sub;
	private ArrayList<Skill> teachesSkills;
	
	// constructor
	public Teacher(int id, String name, String sub) {
		super(id, name);
		this.sub = sub;
		this.skills = new ArrayList<>();
		teachesSkills = new ArrayList<>();
	}

	// setting subject
	public void setSub(String sub) {
		this.sub = sub;
	}

	// get subject
	public String getSub() {
		return sub;
	}

	// get skills as a List of skill
	public ArrayList<Skill> getSkills() {
		return skills;
	}

	// set a list of skills for the teacher
	public void setTeacherSkills(ArrayList<Skill> teacherSkill) {
		this.skills = teacherSkill;
	}

	// get an arraylist of skills
	public ArrayList<Skill> getSkillsBeingTaught() {
		return teachesSkills;
	}
	
	// add a skill in the arraylist of the teach skill
	public void setSkillsBeingTaught(Skill s) {
		teachesSkills.add(s);
	}

	//set the skill in the the arraylist of the skills
	public void setSkill(Skill s){
		skills.add(s);
	}


	// print the skills
	private String printSkills(ArrayList<Skill> s) {
		String allSkills = "";
		for (Skill skill : s) {
            allSkills = allSkills +  " \n\t\t - " + skill.getSkillName();
		}
		return allSkills + " \n ";
	}

	// ToString to print Teacher objects
	@Override
	public String toString() {
		return "Teacher ID " + id + " " + name + " teaches \"" + sub +
				"\" and has the following skills:" + printSkills(getSkills()) + "\n";
	}
}
