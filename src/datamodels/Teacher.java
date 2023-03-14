package datamodels;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//authors Praharsh and Mona

//Interacts with: Administrator
//Stores Teacher objects after reading a file as input
//Teachers will be matched with Courses based on the Course Requirements and their skills
//Will return Teacher objects and the toString() method will print their info

public class Teacher extends Staff{
	private ArrayList<Integer> skills;

private String sub;
// private List<Skill> teacherSkill;

	public Teacher(int id,String name) {
		super(id, name);
	}
	
	// public Teacher(int id,String name, String sub, List<Skill> teacherSkill) {

	public Teacher(int id,String name, String sub) {
		super(id, name);
		this.sub=sub;
		this.skills = new ArrayList<>();

		// this.teacherSkill=teacherSkill;
	}
	
	public String toString2() {
		return "id: "+id+", name: "+name;
	}

	public void setSub(String sub){
		this.sub = sub;
	}

	public String getSub(){
		return sub;
	}

	public ArrayList<Integer> getSkills() {return skills;}
    
	public void setTeacherSkills(ArrayList<Integer> skills) {
		this.skills = skills;
	}

	//Method calls the filereader method in CSVReader
	//and creates Teacher objects from the csv file
	//It is called in main and given the file to read from

	public static List<Teacher> teachers(String filename){
		List<Teacher> teachersList = new ArrayList<>();
		List<String[]> file = CVSReader.wholeFile(filename);
		// //why is this ID here?
		// int id = 1;
	
	//Goes through the csv row by row (item)
	//first thing in item is the name, then id, then subject
	//Anything remaining on or after item[3] is a skill
	//numbered skills on or after item[3] will be added to the skills arrayList
	//Need to do it this way because there is a variable number of skills per teacher

	for(String[] item:file){
		String name = item[0];
		int id = Integer.parseInt(item[1]);
		String subject = item[2];
		ArrayList <Integer> skills = new ArrayList<>();
		for (int i = 3; i< item.length; i++){
			skills.add(Integer.parseInt(item[i]));
		}

		//Need to try to figure out what's going on here- starts at line 74 on CourseReq
		Teacher teacher = new Teacher(id, name, subject);
		teacher.setTeacherSkills(skills);
		teachersList.add(teacher);
	}
	return teachersList;
}

private String printSkills(ArrayList<Integer> s){
	String allSkills = "";
	for (Integer i:s){
		allSkills = allSkills + " | " + i;
	}
	return allSkills + " | ";
}

// ToString to print Teacher objects 
@Override
public String toString() {
	return "Teacher ID " + id + ": " + ", Name: " + name + " teaches " + sub +
			" and has the following skills:" + printSkills(getSkills())+"\n";
}

}
