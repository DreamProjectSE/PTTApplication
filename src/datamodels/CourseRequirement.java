package datamodels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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

    public CourseRequirement(int ID, String name, int departmentID, int numTeachers) {
        this.ID = ID;
        this.name = name;
        this.departmentID = departmentID;
        this.numTeachers = numTeachers;
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


    // takes in a filename and then reads from the file and created course requirement objects , assigning
    // each a unique id and adds them to an arraylist before returning the list
    public static List<CourseRequirement> courseReqReader(String filename) {
        List<CourseRequirement> courseRequirements = new ArrayList<>();
        int ID=1;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0].trim();
                int departmentID = Integer.parseInt(parts[1].trim());
                int numTeachers = Integer.parseInt(parts[2].trim());

                CourseRequirement courseRequirement = new CourseRequirement(ID, name, departmentID, numTeachers);
                courseRequirements.add(courseRequirement);
                ID++;
            }

        } catch (IOException e) {
            System.err.format("Error: ", e);
        }

        return courseRequirements;
    }

    // ToString to test the object creations
    @Override
    public String toString() {
        return "Requirements ID: " + ID + "\n" + "The " + name + " course currently requires " + numTeachers + " teachers.\n";
    }

}
