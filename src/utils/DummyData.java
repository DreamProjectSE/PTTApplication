package utils;

import java.util.ArrayList;

import datamodels.Skill;
import datamodels.Teacher;
import datamodels.Training;

public class DummyData {
	
	public static ArrayList<Teacher> teachers;
	public static ArrayList<Training> trainingList;

	
	public static void setUpTeachers() {
		
		teachers=new ArrayList<>();
		// Add 10 teachers
		for(int i=0;i<10;i++)
		{
		Teacher teacher=new Teacher(i, "teacher "+i);
		teachers.add(teacher);
		}
		
	}

	public static void PopulateTraining() {
		
		trainingList=new ArrayList<>();
		// Create a skill object
		Skill skill1=new Skill(1, "skill 1");
		Skill skill2=new Skill(2, "skill 2");
		Skill skill3=new Skill(3, "skill 3");
		
		// ------------ 1 ----------------------
		//Create a training object
		Training training=new Training(1, "training 1");
		training.setSkill(skill1);
		training.setTotalSpots(10);
		training.setTrainingStatus(true);
		
		// Add teachers to training
		training.enrolTeacher(teachers.get(0));
		training.enrolTeacher(teachers.get(1));
		training.enrolTeacher(teachers.get(2));
		training.enrolTeacher(teachers.get(3));
		
		// Add training to training arraylist
		trainingList.add(training);
	
		//--------------2-------------------
		 	training=new Training(2, "training 2");
			training.setSkill(skill3);
			training.setTotalSpots(5);
			training.setTrainingStatus(false);
			
			// Add teachers to training
			training.enrolTeacher(teachers.get(3));
			training.enrolTeacher(teachers.get(9));
			training.enrolTeacher(teachers.get(5));
			training.enrolTeacher(teachers.get(6));
			training.enrolTeacher(teachers.get(2));

			
			// Add training to training arraylist
			trainingList.add(training);

			//--------------3-------------------
		 	training=new Training(3, "training 3");
			training.setSkill(skill3);
			training.setTotalSpots(20);
			training.setTrainingStatus(true);
			
			// Add teachers to training
			training.enrolTeacher(teachers.get(3));
			training.enrolTeacher(teachers.get(9));
			

			
			// Add training to training arraylist
			trainingList.add(training);


	}
	

}
