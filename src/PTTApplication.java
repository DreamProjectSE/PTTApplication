import datamodels.Administrator;
import datamodels.CourseRequirement;
import datamodels.Skill;
import datamodels.Teacher;
import datamodels.Training;
import utils.DummyData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PTTApplication {

	public static void main (String args[])
	{
		System.out.println("*** PTT application ****");
		
		// Read file and populate data models
		
// *************************************************************************************
		
		DummyData.setUpTeachers();
		DummyData.PopulateTraining();
		
//		for(Training training: DummyData.trainingList)
//		{
//			System.out.println("Training : "+training);
//
//		}

		
// **************************************************************************************
		
		//Assume the term id is 2
		int termID=2;
		
		// Admin from departmentID=4 with id 193
		Administrator admin1=new Administrator(193, "Tom", 4);
		admin1.setTermID(termID);
		admin1.setTeachers(DummyData.teachers);
		admin1.setTermTrainings(DummyData.trainingList);
		admin1.analyzeTerm(termID);

		String basePath = new File("").getAbsolutePath();
		System.out.println(basePath);

		String path = new File("src/datamodels/CourseReq.csv").getAbsolutePath();
		System.out.println(path);
		//printing a toString of all course requirements (Test)
		List<CourseRequirement> courseRequirements = CourseRequirement.requirements(path);
		System.out.println(courseRequirements);

		String path2 = new File("src/datamodels/Teacher.csv").getAbsolutePath();
		System.out.println(path2);
		//printing a toString of all Teachr requirements (Test)
		List<Teacher> teachers = Teacher.teachers(path2);
		System.out.println(teachers);


	}
}
