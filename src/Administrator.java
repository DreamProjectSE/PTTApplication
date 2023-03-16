
import java.util.ArrayList;
import java.util.Scanner;

import datamodels.CourseRequirement;
import datamodels.Teacher;
import datamodels.Training;
import datamodels.Staff;
import datamodels.Skill;

public class Administrator extends Staff{


	public Administrator(int id,String name,int departmentID) {
		super(id, name, departmentID);
		
	}

	public ArrayList<Skill> getRequiredTraining(CourseRequirement requirement, ArrayList<Teacher> teachers){
		int depID = requirement.getID();
		ArrayList<Skill> skillList = requirement.getRequiredSkills();
		int count = 0;
		int numOfTeachersRequired;

		ArrayList<Skill> requiredTrainings = new ArrayList<Skill>();

		for (Skill s : skillList){
			count = 0;
			int tempCount = 0;
			numOfTeachersRequired = requirement.getTeachers();
			while (count < numOfTeachersRequired){
				for (Teacher t : teachers){
					/*
					 * For each teacher skill, check if its the correct skill
					 * if so and teacher not teaching anything then add it
					 * 
					 */
					for (int i = 0; i < t.getSkills().size(); i++){
						Skill tSkill = t.getSkills().get(i);
						if (tSkill.getSkillID() == s.getSkillID()){
							if ((t.getSkillsBeingTaught() == null)){
								tempCount++;
								t.setSkillsBeingTaught(s);
								break;
							}
							/**
							 * Teacher is teaching something so need to
							 * check if they are teaching current skill
							 */
							else {
								if (t.getSkillsBeingTaught().contains(s)){
									break;
								}
								tempCount++;
								t.setSkillsBeingTaught(s);
								break;
							}
						}
					}
				}
				count++;
			}
			/**
			 * Now we know what skills are needed, add them to required trainings
			 */
			if (tempCount != numOfTeachersRequired){
				int numberNeeded = numOfTeachersRequired - tempCount;
				for (int i = 0 ; i < numberNeeded ; i++){
					requiredTrainings.add(s);
				}
			}
		}
		return requiredTrainings;
	}
	
	public void printCourseRequirements(CourseRequirement courseRequirements){
		System.out.println("\n Next Course \n");

			System.out.println("Course " + courseRequirements.getName() + " needs " +
								courseRequirements.getTeachers() + " with the following skills");
			for (Skill s : courseRequirements.getRequiredSkills()){
				System.out.println(s.getSkillName() + " : " + s.getSkillID());
			}
	}

	public void printRequiredTraining(ArrayList<Skill> requiredTrainings){
		for (Skill s : requiredTrainings){
			System.out.println(s.getSkillName());
		}
	}

	public ArrayList<Teacher> getAvailableTeachers(Skill skill, ArrayList<Teacher> teachers, int depID){
		ArrayList<Teacher> teachersWithAvaliablity = new ArrayList<Teacher>();
		for (Teacher t: teachers){
			if (!t.getSkills().contains(skill)){
				if (!t.getSkillsBeingTaught().contains(skill)){
					teachersWithAvaliablity.add(t);
				}
			}
		}
		return teachersWithAvaliablity;
	}

	
	public void analyzeTerm(int courseID, ArrayList<CourseRequirement> courseRequirements, ArrayList<Teacher> teachers, ArrayList<Training> trainings) 
	{
		ArrayList<String> teacherAssignments = new ArrayList<String>();
		Scanner s = new Scanner(System.in);


			/* Linear search for the relevant course requirement.
			* Decided there is no need for a faster search method
			* as schools/universities only have a few hundred courses
			*/
			
			for (CourseRequirement requirement : courseRequirements){
				printCourseRequirements(requirement);
				System.out.println("Do you want to assign teachers to this course? " + requirement.getName());
				System.out.println("Please enter 'Yes' or 'No'");
				String input = s.nextLine();
				if (input.equals("Yes")){
					/**
					 * Fetch a list of skills not avaliable in the current teacher skills
					 */
					ArrayList<Skill> requiredTrainings = getRequiredTraining(requirement, teachers);
					if (requiredTrainings.isEmpty()){
						System.out.println("All skills for this course are already avaliable, no need to train any teachers!");
						break;
					}
					System.out.println("The system will now automatically assign teachers to training courses...");

					/*
					 * The avaliable teachers just scans each skill through the teachers
					 * This is a relatively simple approach with O(m*n)
					 * where m is number of skills and n is number of teachers
					 */
					int total = requiredTrainings.size();
					int count = 0;

					for (Skill skill : requiredTrainings){
						ArrayList<Teacher> avaliableTeachers = getAvailableTeachers(skill, teachers, requirement.getDepID());

						Training availableTraining = getAvailableTrainings(skill.getSkillID(), trainings);
						if (availableTraining == null){
							System.out.println("Unable to assign teachers to " + skill);
							continue;
						}
						if (availableTraining.isTrainingOpen()){
							availableTraining.enrolTeacher(avaliableTeachers.get(0));
							count++;
						}

					}
					if (count == total){
						System.out.println("Teacher training has been assigned to meet all requirements");
					}
					else {
						System.out.println("Not enough training capacity to train all teachers");
					}
				}
				else {
					System.out.println("The system will skip assigning teachers to this course");
				}
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
