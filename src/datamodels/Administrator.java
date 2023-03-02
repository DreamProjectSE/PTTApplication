package datamodels;

import java.util.ArrayList;

public class Administrator extends Staff{
	
	private int termID;
	
	private ArrayList<Training> termTraining;
	private ArrayList<Teacher> teachers;


	public Administrator(int id,String name,int departmentID) {
		super(id, name, departmentID);
		
		termTraining=new ArrayList<>();
	}
	
	public void setTermID(int termID) {
		this.termID=termID;
	}
	
	public int getTermID() {
		return termID;
	}
	
	public void setTermTrainings(ArrayList<Training> termTraining) {
		this.termTraining=termTraining;		
	}
	
	public ArrayList<Training> getTermTrainings() {
		return termTraining;		
	}
	
	public void setTeachers(ArrayList<Teacher> teachers) {
		this.teachers=new ArrayList<>();
		this.teachers=teachers;
	}

	public ArrayList<Teacher> getTeachers() {
		return teachers;
	}
	
	public void analyzeTerm(int termID) {

		// View Course Requirements
		
		// View list of available teachers and their skills
		
		//Match teachers and skill
		
		int skillID=3;
		
		System.out.println("\n Checking available training for skillID - "+skillID);

		// View list of available trainings and their capacity
		Training availableTraining=getAvailableTrainings(skillID);
		
		System.out.println("\n AvailableTraining - "+availableTraining);

		// If any training is available, proceed further
		if(availableTraining!=null)
		{
			// Assign teachers to training courses
		}else {
			// **** No trainings available ***
		}
		
	
	}

	/** Method to retrieve available training for given skill and return the training object,if exists
	 * 
	 * @param skillID
	 * @return
	 */
	private Training getAvailableTrainings(int skillID) {
		
	
		Training availableTraining = null;
		
		for(Training training:termTraining) {

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
