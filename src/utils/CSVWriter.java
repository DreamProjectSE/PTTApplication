package utils;

/** Helper class to read contents from file and populate data models
 * 
 *@author Ruari
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import datamodels.Skill;
import datamodels.Teacher;
import datamodels.Training;

public class CSVWriter {

    public CSVWriter() {
    }

		/*
	 * This method takes in an ArrayList of trainings and writes them to a CSV file in the same format as the original Trainings.csv file,
	 * this is so that the data in the updated file can be used again by the CSVReader methods after the program has been run.
	 */
	public static void writeTrainings(ArrayList<Training> trainings, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            // Write header row
            fileWriter.write("ID,Training name,Skill,Total spots,Status,Enrollment list,\n");

            // Write each training
            for (Training training : trainings) {
                fileWriter.write(training.getTrainingID() + ",");
                fileWriter.write(training.getTrainingName() + ",");
                fileWriter.write(training.getSkill().getSkillID() + ",");
                fileWriter.write(training.getTotalSpots() + ",");
                fileWriter.write(training.getStatus() + ",");
				if(training.getEnrollmentList().size() == 0) {
					fileWriter.write(",\n");
				}else {
				
					for(int i = 0; i < training.getEnrollmentList().size(); i++) {
						fileWriter.write(training.getEnrollmentList().get(i).getID() + ",");
						if(i == training.getEnrollmentList().size() - 1) {
							fileWriter.write("\n");
					}
				}
				}
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	/*
	 * This method takes in an ArrayList of teachers and writes them to a CSV file in the same format as the original Teacher.csv file.
	 */
	public static void writeTeachers(ArrayList<Teacher> teachers, String fileName) {
		try (FileWriter fileWriter = new FileWriter(fileName)) {
			// Write header row
			fileWriter.write("ID,Name,Course,Skills,,,,,,,,,\n");
	
			// Write each teacher
			for (Teacher teacher : teachers) {
				fileWriter.write(teacher.getID() + ",");
				fileWriter.write(teacher.getName() + ",");
				fileWriter.write(teacher.getSub() + ",");
				List<Skill> skills = teacher.getSkills();
				for (int i = 0; i < skills.size(); i++) {
					fileWriter.write(skills.get(i).getSkillID() + ",");
				}
				if(skills.size() < 10) {
					for(int i = skills.size(); i < 10; i++) {
						fileWriter.write(",");
					}
				}
				fileWriter.write("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
