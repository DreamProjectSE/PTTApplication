import java.util.ArrayList;

import datamodels.CourseRequirement;
import datamodels.Skill;
import datamodels.Staff;
import datamodels.Teacher;
import datamodels.Training;

/**  Class to accomodate 'Administartor' object and execute its functionalities
 * 
 *@author Daniel
 */
public class Administrator extends Staff{


	public Administrator(int id,String name,int departmentID) {
		super(id, name, departmentID);
		
	}
	

	
	public boolean analyzeTerm(int courseID, ArrayList<CourseRequirement> courseRequirements, ArrayList<Teacher> teachers, ArrayList<Training> trainings) 
	{

		// View Course Requirements for the specified course
		
		CourseRequirement courseReq=getCourseRequirement(courseID,courseRequirements);
		
		if(courseReq==null)
		{
			System.out.println(" <<<<< Course requirement cannot be found! >>>>>\n");
			return false;
		}
		
		System.out.println("\n <------------- REQUESTED COURSE REQUIREMENT ------------> "+courseReq);

		ArrayList<Teacher> courseTeachers= getTeachersOfSameCourse(courseReq.getName(),teachers);
		
		System.out.println("\n  <------------- AVAILABLE TEACHERS ------------>  \n"+courseTeachers);

		// View list of available teachers and their skills for the specified course		
		// if teachers doesn't have requuired skill, check for available training 
		
		for(Teacher tr:courseTeachers)
		{
			System.out.println("\n\n Checking available training for "+tr.getName()+"...........................");

			boolean trainingStatus=false;
			for(Skill sk:courseReq.getRequiredSkills())
			{
				if(!checkIfskillIsPresent(sk.getSkillID(),tr.getSkills()))
				{
					

					// Retrieve list of available trainings for the given skill
					Training availableTraining=getAvailableTrainings(sk.getSkillID(),trainings);
					

					// If any training is available, proceed further
					if(availableTraining!=null)
					{
						// If teacher is already enrolled, skip. Otherwise, enrol teacher for that training
						if(!checkIfTeacherAlreadyEnrolled(tr.getID(),availableTraining.getEnrollmentList()))
						{
							// Assign teacher to training course
							availableTraining.enrolTeacher(tr);
							System.out.println("\n"+tr.getName()+" ENROLLED FOR \""+availableTraining.getTrainingName());
							trainingStatus=true;
							System.out.println("\n UPDATED TRAINING: "+availableTraining);

						}else {
							System.out.println("\n UPDATE: "+tr.getName()+" HAS ALREADY ENROLLED FOR \""+availableTraining.getTrainingName()+"\" ["+sk.getSkillName()+"]");
							trainingStatus=false;
						}				

					}else {
						System.out.println("\n UPDATE: NO AVAILABLE TRAINING ["+sk.getSkillName()+"] FOR "+tr.getName());
						trainingStatus=false;
						break;
					}					
				}else {
					// All skills present for teacher. No need of training
					trainingStatus=true;
				}
			}
			
			if(trainingStatus==true) // If a teacher has been enrolled for a training course
			{
				// Reduce number of teachers required for the course
				courseReq.setTeachers(courseReq.getTeachers()-1);
				System.out.println("\n UPDATED COURSE REQUIREMENT : "+courseReq);
			}
		}
	
		return true;
		
	}

	

	private boolean checkIfTeacherAlreadyEnrolled(int teacherID, ArrayList<Teacher> enrollmentList) {

		for(Teacher tr:enrollmentList)
		{
			if(tr.getID()==teacherID)
			{
				return true;
			}
		}
		return false;
	}



	private boolean checkIfskillIsPresent(int skillID, ArrayList<Skill> skills) {

		for(Skill sk:skills)
		{
			if(sk.getSkillID()==skillID)
			{
				return true;
			}
		}
		return false;
	}



	private ArrayList<Teacher> getTeachersOfSameCourse(String sName, ArrayList<Teacher> teachers) {
		
		ArrayList<Teacher> teachersToReturn=new ArrayList<>();
		
		for(Teacher tr:teachers)
		{
			if(tr.getSub().equalsIgnoreCase(sName))
			{
				teachersToReturn.add(tr);
			}
		}
		return teachersToReturn;
	}



	private CourseRequirement getCourseRequirement(int courseID, ArrayList<CourseRequirement> courseRequirements) {

		CourseRequirement courseReq=null;
		
		for(CourseRequirement cr:courseRequirements)
		{
			if(cr.getID()==courseID)
			{
				courseReq=cr;
				break;
			}
		}
		return courseReq;
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
