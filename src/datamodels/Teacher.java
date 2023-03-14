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
	
	public String toString() {
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
		int id = 1;
	}

}
