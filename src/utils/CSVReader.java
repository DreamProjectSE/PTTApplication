package utils;

/** Helper class to read contents from CSV file and populate data models
 * 
 *@author Glenn
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datamodels.CourseRequirement;
import datamodels.Skill;
import datamodels.Teacher;
import datamodels.Training;

public class CSVReader {

    public CSVReader() {
    }

    public static List<String[]> wholeFile(String fileName){
        List<String[]> lineRead = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while ((line = reader.readLine())!=null){
                String[] lines = line.split(",");
                lineRead.add(lines);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return lineRead;
    }

    
    // This method calls the filereader method in CVSReader and creates courserequirement objects from the supplied
    // file. This is called in main and given the file to read from

    public static ArrayList<CourseRequirement> populateCourseRequirements(String filename, ArrayList<Skill> skills){
    	ArrayList<CourseRequirement> courseRequirements = new ArrayList<>();
        List<String[]> file = wholeFile(filename);
        //int ID =1;
        boolean isHeading=true; //Skip first row

        for (String[] data: file) {
        	if(isHeading==false)
        	{
            int id = Integer.parseInt(data[0]);
            String name = data[1];
            int departmentId = Integer.parseInt(data[2]);
            int numTeachers = Integer.parseInt(data[3]);
            ArrayList <Skill> requiredSkills = new ArrayList<>();
            for (int i = 4; i < data.length; i++) {
                //requiredSkills.add(Integer.parseInt(data[i]));
                requiredSkills.add(getSkillObject(Integer.parseInt(data[i]),skills));
            }
            CourseRequirement courseRequirement = new CourseRequirement(id,name, departmentId,numTeachers);
            courseRequirement.setRequiredSkills(requiredSkills);
            courseRequirements.add(courseRequirement);
        	}else
        		isHeading=false;
        }
        return courseRequirements;
    }
    
    
    
	

	/** Method to populate skills arraylist from csv file
	 * 
	 * @param filename
	 * @return
	 */

	public static ArrayList<Skill> populateSkills(String filename) {
		ArrayList<Skill> skills = new ArrayList<>();
        List<String[]> file = wholeFile(filename);
        boolean isHeading=true; // Skip first row
        for (String[] data: file) {
        	if(isHeading==false)
        	{
            int skillID = Integer.parseInt(data[0]);
            String skillName = data[1];
            
            Skill skill = new Skill(skillID, skillName);
            skills.add(skill);
        	}else
        		isHeading=false;
            
        }
        return skills;
    
	}

	/** Method calls the filereader method in CSVReader and 
	 * creates Teacher objects from the csv file It is called in main and given the file to read from
	 * 
	 * @param filename
	 * @param skills 
	 * @return
	 */

	public static ArrayList<Teacher> populateTeachers(String filename, ArrayList<Skill> skills) {
		ArrayList<Teacher> teachersList = new ArrayList<>();
		List<String[]> file = CSVReader.wholeFile(filename);
	
		boolean isHeading=true;
		// Goes through the csv row by row (item)
		// first thing in item is the name, then id, then subject
		// Anything remaining on or after item[3] is a skill
		// numbered skills on or after item[3] will be added to the skills arrayList
		// Need to do it this way because there is a variable number of skills per
		// teacher

		for (String[] item : file) {
			if(isHeading==false)
			{
			String name = item[1];// name
			int id = Integer.parseInt(item[0]);// teacher id
			String subject = item[2];// subject
			 ArrayList <Skill> teacherSkills = new ArrayList<>();
	            for (int i = 3; i < item.length; i++) {
	                //requiredSkills.add(Integer.parseInt(data[i]));
	            	teacherSkills.add(getSkillObject(Integer.parseInt(item[i]),skills));
	            }
			Teacher teacher = new Teacher(id, name, subject);// initialize the object
			teacher.setTeacherSkills(teacherSkills);// set the skills
			teachersList.add(teacher);// add the teacher into the a list of teacher
			}else
				isHeading=false;
		}
		return teachersList;
	}
	
	
	/** Method reads the csv file and extracts the information.
	 * This information will be used to populate corresponding training objects and
	 * returns an arraylist of training objects
	 * @param filename
	 * @param skills
	 * @param teachers
	 * @return
	 */
	
	public static ArrayList<Training> populateTrainings(String filename, ArrayList<Skill> skills, ArrayList<Teacher> teachers) {
		
		ArrayList<Training> trainings = new ArrayList<>(); // Arraylist to return
		
        List<String[]> file = wholeFile(filename); // Read file contents to a list
        
        boolean isHeading=true; //Skip first row

        // Iterate the list and extracts data
        for (String[] data: file) {
        	if(isHeading==false)
        	{
            int trainingID = Integer.parseInt(data[0]); // Training ID
            String trainingName = data[1]; // Training name
            Skill skillID = getSkillObject(Integer.parseInt(data[2]),skills); // Skill ID
            int totalSpots = Integer.parseInt(data[3]); // Total spots
            
            // if the value from csv file is zero, isOpen will be set to false. Otherwise, isOpen will be set to true
            boolean isOpen = (Integer.parseInt(data[4])==0?false:true); //isOpen

            // A list of already enrolled teachers
            ArrayList <Teacher> enrolledTeachers = new ArrayList<>();
            for (int i = 5; i < data.length; i++) {
            	enrolledTeachers.add(getTeacherObject(Integer.parseInt(data[i]),teachers));
            }
            
            // Populate Training object
            Training training=new Training(trainingID, trainingName);
            training.setSkill(skillID);
    		training.setTotalSpots(totalSpots);
    		training.setTrainingStatus(isOpen);
    		training.setEnrollmentList(enrolledTeachers);
    		
    		// Add the updated Training object to the list
    		trainings.add(training);
        	}else
        		isHeading=false;
            
            
        }
        return trainings;
    }
	
	
	
	/** Method is used to link the corresponding  Skill object of a skillID, which is
	 * used by other data objects	
	 * @param skillID
	 * @param skills
	 * @return
	 */
private static Skill getSkillObject(int skillID, ArrayList<Skill> skills) {
		
		Skill skillToReturn = null;
		
		for(Skill skill: skills)
		{
			if(skill.getSkillID()==skillID)
				skillToReturn=skill;
		}
		
		return skillToReturn;
		
	}
	
	/** Method is used to link the corresponding Teacher object of a teacherID, which is
	 * used by other data objects	
	 * @param teacherID
	 * @param teachers
	 * @return
	 */
	private static Teacher getTeacherObject(int teacherID, ArrayList<Teacher> teachers) {
		
		Teacher teacherToReturn = null;
		
		for(Teacher teacher: teachers)
		{
			if(teacher.getID()==teacherID)
				teacherToReturn=teacher;
		}
		
		return teacherToReturn;
		
	}


    }