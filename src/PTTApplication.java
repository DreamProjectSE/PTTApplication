import datamodels.CourseRequirement;
import datamodels.Skill;
import datamodels.Teacher;
import datamodels.Training;
import utils.CSVReader;
import utils.CSVWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class PTTApplication {

	public static void main (String args[])
	{
		System.out.println("*** PTT application ****");
		

		//Assume the term id is 2
		// int termID=2;
	
		// Read file and populate data models

		System.out.println("\n******************************** SKILLS *********************************************");

		// Populate skills list from CSV file
		String path=new File("src/assets/Skills.csv").getAbsolutePath();		
		ArrayList<Skill> skills = CSVReader.populateSkills(path);
		System.out.println(skills);

		System.out.println("\n******************************** COURSE REQUIREMENTS *********************************************");

		// Populate courserequirements list from CSV file
		path=new File("src/assets/CourseReq.csv").getAbsolutePath();
		ArrayList<CourseRequirement> courseRequirements = CSVReader.populateCourseRequirements(path,skills);
		System.out.println(courseRequirements);
		
		
		System.out.println("\n********************************** TEACHERS **********************************************");

		// Populate teachers list from CSV file
		path = new File("src/assets/Teacher.csv").getAbsolutePath();
		ArrayList<Teacher> teachers = CSVReader.populateTeachers(path,skills);
		System.out.println(teachers);
		
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
		
		admin1.analyzeTerm(courseID,courseRequirements,teachers,trainings);

		// Printing the updated toString representations of the data models after the administrator has executed the analyzeTerm method
		System.out.println("\n********************************** UPDATED TRAINING **********************************************");
		System.out.println(trainings);
		System.out.println("\n********************************** UPDATED TEACHERS **********************************************");
		System.out.println(teachers);

		/*
		 * Testing the writeTrainings and writeTeachers methods with the following steps:
		 * 1. Write the trainings and teachers arraylists to the corresponding CSV files, in this case they are tests but can be changed to update the originals.
		 * 2. Read the CSV files that were just written to and populate the trainings and teachers arraylists with the new data.
		 * 3. Print the new toString representations of the datamodels to the console.
		 * If the output is the same as the toString representations of the updated training and teachers arraylists
		 * that were printed after the administrator executed the analyseTerm method, 
		 * and before the writer tests, then the CSVWriter methods are working as intended.
		 */
		System.out.println("\n********************************** writeTrainings TEST **********************************************");
		path=new File("src/assets/TrainingsTest.csv").getAbsolutePath();
		CSVWriter.writeTrainings(trainings, path);
		ArrayList<Training> testTrainings = CSVReader.populateTrainings(path,skills,teachers);
		System.out.println(testTrainings);


		System.out.println("\n********************************** writeTeachers TEST **********************************************");
		path=new File("src/assets/TeacherTest.csv").getAbsolutePath();
		CSVWriter.writeTeachers(teachers, path);
		ArrayList<Teacher> testTeachers = CSVReader.populateTeachers(path,skills);
		System.out.println(testTeachers);
	
		//skills.get(0).setSkillName("test####"); // Updating skill name will reflect changes throughout all arraylists having skill object
		
		//System.out.println("\n********************************** UPDATED COURSE REQUIREMENTS **********************************************");		
		//System.out.println(courseRequirements);
		
		//System.out.println("\n********************************** UPDATED TRAINING **********************************************");		
		//System.out.println(trainings);

		// Write to file
		

	}


}
