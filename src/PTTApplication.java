import datamodels.CourseRequirement;
import datamodels.Skill;
import datamodels.Teacher;
import datamodels.Training;
import utils.CSVReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PTTApplication {

	public static void main (String args[])
	{
		System.out.println("*** PTT application ****");
		

		//Assume the term id is 2
		int termID=2;
	
		// Read file and populate data models

		//System.out.println("\n******************************** SKILLS *********************************************");

		// Populate skills list from CSV file
		String path=new File("src/assets/Skills.csv").getAbsolutePath();		
		ArrayList<Skill> skills = CSVReader.populateSkills(path);
		//System.out.println(skills);

		System.out.println("\n******************************** COURSE REQUIREMENTS *********************************************");

		// Populate courserequirements list from CSV file
		path=new File("src/assets/CourseReq.csv").getAbsolutePath();
		ArrayList<CourseRequirement> courseRequirements = CSVReader.populateCourseRequirements(path,skills);
		System.out.println(courseRequirements);
		
		
		//System.out.println("\n********************************** TEACHERS **********************************************");

		// Populate teachers list from CSV file
		path = new File("src/assets/Teacher.csv").getAbsolutePath();
		ArrayList<Teacher> teachers = CSVReader.populateTeachers(path,skills);
		//System.out.println(teachers);
		
		// Populate training list from CSV file
		System.out.println("\n********************************** TRAINING **********************************************");
		path=new File("src/assets/Trainings.csv").getAbsolutePath();
		ArrayList<Training> trainings = CSVReader.populateTrainings(path,skills,teachers);
		System.out.println(trainings);
		
		
		
		// Admin from departmentID=4 with id 193
		Administrator admin1=new Administrator(193, "Tom", 4);
		
		System.out.println("\n---------------- Analyzing the term requirements ------------------");
		
		Scanner inputScanner = new Scanner(System.in);  // Create a Scanner object
		
	    System.out.println("Enter the course ID to start analyzing requirements...\n");
	    
	    int courseID=inputScanner.nextInt();
		
		boolean updateStatus=admin1.analyzeTerm(courseID,courseRequirements,teachers,trainings);
		
		
		//System.out.println("\n********************************** UPDATED COURSE REQUIREMENTS **********************************************");		
		//System.out.println(courseRequirements);
		
		//System.out.println("\n********************************** UPDATED TRAINING **********************************************");		
		//System.out.println("\n"+trainings);

		// Write to file
		

	}
}
