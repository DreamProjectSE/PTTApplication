import datamodels.Administrator;
import datamodels.CourseRequirement;
import datamodels.Skill;
import datamodels.Training;
import utils.DummyData;

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

		//printing a toString of all course requirements (Test)
		List<CourseRequirement> courseRequirements = CourseRequirement.requirements("PTTApplication/src/datamodels/CourseReq.csv");
		System.out.println(courseRequirements);



	}
}
