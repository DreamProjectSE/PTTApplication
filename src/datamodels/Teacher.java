package datamodels;

/** Datamodel to accomodate 'Teacher' object
 * 
 * @authors Praharsh and Mona
 *
 */


import java.util.ArrayList;
import java.util.List;

import utils.CVSReader;


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
	
	// constructor
	public Teacher(int id, String name, String sub) {
		super(id, name);
		this.sub = sub;
		this.skills = new ArrayList<>();
	}

	// setting subject
	public void setSub(String sub) {
		this.sub = sub;
	}

	// get subject
	public String getSub() {
		return sub;
	}

	// get skills as a List of Integer values
	public ArrayList<Skill> getSkills() {
		return skills;
	}

	// set a list of skills for the teacher
	public void setTeacherSkills(ArrayList<Skill> teacherSkill) {
		this.skills = teacherSkill;
	}

	// Method calls the filereader method in CSVReader
	// and creates Teacher objects from the csv file
	// It is called in main and given the file to read from

//	public static ArrayList<Teacher> teachers(String filename) {
//		ArrayList<Teacher> teachersList = new ArrayList<>();
//		List<String[]> file = CVSReader.wholeFile(filename);
//		// //why is this ID here?
//		// int id = 1;
//
//		// Goes through the csv row by row (item)
//		// first thing in item is the name, then id, then subject
//		// Anything remaining on or after item[3] is a skill
//		// numbered skills on or after item[3] will be added to the skills arrayList
//		// Need to do it this way because there is a variable number of skills per
//		// teacher
//
//		for (String[] item : file) {
//			String name = item[1];// name
//			int id = Integer.parseInt(item[0]);// teacher id
//			String subject = item[2];// subject
//			List<Integer> teacherSkill = new ArrayList<Integer>();
//			for (int i = 3; i < item.length; i++) {// rest of the values are the skills
//				teacherSkill.add(Integer.parseInt(item[i]));
//			}
//			Teacher teacher = new Teacher(id, name, subject);// initialize the object
//			teacher.setTeacherSkills(teacherSkill);// set the skills
//			teachersList.add(teacher);// add the teacher into the a list of teacher
//		}
//		return teachersList;
//	}


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
		return "Teacher ID " + id + ": " + " " + name + " teaches \"" + sub +
				"\" and has the following skills:" + printSkills(getSkills()) + "\n";
	}

}
