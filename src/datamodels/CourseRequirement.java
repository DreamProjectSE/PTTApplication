package datamodels;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

//authors Kaela and Glenn

//Interacts with: Administrator
//stores objects of course requirements after reading a file as input
//called based on the course the administrator wants to fill
//String taken from scanner object in the main - prompts admin to fill
//returns object, passes through the printer method and print it
public class CourseRequirement {
    private int ID;
    private String name;
    private int departmentID;
    private int numTeachers;
    private ArrayList<Skill> requiredSkills;

    public CourseRequirement(int ID, String name, int departmentID, int numTeachers) {
        this.ID = ID;
        this.name = name;
        this.departmentID = departmentID;
        this.numTeachers = numTeachers;
        this.requiredSkills = new ArrayList<>();
    }

    public void setID(int ID){
        this.ID = ID;
    }
    public int getID(){
        return ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDepID(int departmentID){
        this.departmentID = departmentID;
    }
    public int getDepID(){
        return departmentID;
    }
    public void setTeachers(int numTeachers){
        this.numTeachers = numTeachers;
    }
    public int getTeachers(){
        return numTeachers;
    }
    public ArrayList<Skill> getRequiredSkills() {return requiredSkills;}
    public void setRequiredSkills(ArrayList<Skill> requiredSkills) {this.requiredSkills = requiredSkills;}


    // This method calls the filereader method in CVSReader and creates courserequirement objects from the supplied
    // file. This is called in main and given the file to read from

//    public static ArrayList<CourseRequirement> requirements(String filename){
//    	ArrayList<CourseRequirement> courseRequirements = new ArrayList<>();
//        List<String[]> file = CVSReader.wholeFile(filename);
//        int ID =1;
//
//        for (String[] data: file) {
//            String name = data[0];
//            int departmentId = Integer.parseInt(data[1]);
//            int numTeachers = Integer.parseInt(data[2]);
//            ArrayList <Integer> requiredSkills = new ArrayList<>();
//            for (int i = 3; i < data.length; i++) {
//                requiredSkills.add(Integer.parseInt(data[i]));
//            }
//            CourseRequirement courseRequirement = new CourseRequirement(ID,name, departmentId,numTeachers);
//            courseRequirement.setRequiredSkills(requiredSkills);
//            courseRequirements.add(courseRequirement);
//            ID++;
//        }
//        return courseRequirements;
//    }

   private String printSkills(ArrayList<Skill> skills){
        String allSkills = "";
        for (Skill skill:skills) {
            allSkills = allSkills +  " \n\t\t\t - " + skill.getSkillName();
        }
        return allSkills + " \n";
    }

    // ToString to test the object creations
    @Override
    public String toString() {
        return "\nRequirements ID " + ID + ": " + "The \"" + name + "\" course currently requires [" + numTeachers +
                "] teachers with the following skills:" + printSkills(getRequiredSkills())+"\n";
    }

}
