package datamodels;

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
}
