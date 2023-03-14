package datamodels;

import java.util.ArrayList;

public class Administrator extends Staff{


	public Administrator(int id,String name,int departmentID) {
		super(id, name, departmentID);
		
	}
	

	
	public void analyzeTerm(ArrayList<CourseRequirement> courseRequirements, ArrayList<Teacher> teachers, ArrayList<Training> trainings) 
	{

		// View Course Requirements
		
		// View list of available teachers and their skills
		
		//Match teachers and skill
		
		int skillID=3;
		
		System.out.println("\n Checking available training for skillID - "+skillID);

		// View list of available trainings and their capacity
		Training availableTraining=getAvailableTrainings(skillID,trainings);
		
		System.out.println("\n AvailableTraining - "+availableTraining);

		// If any training is available, proceed further
		if(availableTraining!=null)
		{
			// Assign teachers to training courses
		}else {
			// **** No trainings available ***
		}
		
	}

	

	/** Method to retrieve available training (isOpen=true) for given skill and return the training object,if exists
	 * 
	 * @param skillID
	 * @param trainings
	 * @return
	 */
	private Training getAvailableTrainings(int skillID, ArrayList<Training> trainings) {
		
	Training availableTraining = null;
		
	// Iterate through training list and find any available training for the given skill
		for(Training training:trainings) {

			// if the training is for the given skill and the training is still open, return that object
			if(training.getSkill().getSkillID()==skillID && training.isTrainingOpen()==true) 
			{
				availableTraining=training;
				break;
			}
		}

		return availableTraining;
	}
	
	
	
	
	
}
