package datamodels;

import java.util.ArrayList;
import java.util.List;

//authors Praharsh and Mona

//Interacts with: Administrator
//Stores Teacher objects after reading a file as input
//Teachers will be matched with Courses based on the Course Requirements and their skills
//Will return Teacher objects and the toString() method will print their info

public class Teacher extends Staff {

	// attributes
	private List<Integer> skills;
	private String sub;
	// private List<Skill> teacherSkill;

	// public Teacher(int id,String name) {
	// super(id, name);
	// }

	// public Teacher(int id,String name, String sub, List<Skill> teacherSkill) {

	// constructor
	public Teacher(int id, String name, String sub) {
		super(id, name);
		this.sub = sub;
		this.skills = new ArrayList<>();

		// this.teacherSkill=teacherSkill;
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
	public List<Integer> getSkills() {
		return skills;
	}

	// set a list of skills for the teacher
	public void setTeacherSkills(List<Integer> teacherSkill) {
		this.skills = teacherSkill;
	}

	// Method calls the filereader method in CSVReader
	// and creates Teacher objects from the csv file
	// It is called in main and given the file to read from

	public static List<Teacher> teachers(String filename) {
		List<Teacher> teachersList = new ArrayList<>();
		List<String[]> file = CVSReader.wholeFile(filename);
		// //why is this ID here?
		// int id = 1;

		// Goes through the csv row by row (item)
		// first thing in item is the name, then id, then subject
		// Anything remaining on or after item[3] is a skill
		// numbered skills on or after item[3] will be added to the skills arrayList
		// Need to do it this way because there is a variable number of skills per
		// teacher

		for (String[] item : file) {
			String name = item[0];// name
			int id = Integer.parseInt(item[1]);// teacher id
			String subject = item[2];// subject
			List<Integer> teacherSkill = new ArrayList<Integer>();
			for (int i = 3; i < item.length; i++) {// rest of the values are the skills
				teacherSkill.add(Integer.parseInt(item[i]));
			}
			Teacher teacher = new Teacher(id, name, subject);// initialize the object
			teacher.setTeacherSkills(teacherSkill);// set the skills
			teachersList.add(teacher);// add the teacher into the a list of teacher
		}
		return teachersList;
	}


	// print the skills
	private String printSkills(List<Integer> s) {
		String allSkills = "";
		for (Integer i : s) {
			allSkills = allSkills + " | " + i;
		}
		return allSkills + " | ";
	}

	// ToString to print Teacher objects
	@Override
	public String toString() {
		return "Teacher ID " + id + ": " + " Name: " + name + " teaches " + sub +
				" and has the following skills:" + printSkills(getSkills()) + "\n";
	}

}
