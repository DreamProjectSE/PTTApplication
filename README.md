# PTTApplication
The main method, where we interact with the Administartor. The file path of the respective csv files will be assigned to path and passed as a parameter while populating arraylists. At first, the skills arraylist will be populated from Skills.csv file. The skills will be passed as a parameter to populateCourseRequirements() method for populating courseRequirements list from CourseReq.csv file. After that, teachers will be populated using populateTeachers() method and skills list. At last, trainings list will be populated using the populateTrainings() method and skills list.

#Skill
Data model to accomodate skills


#Course Requirement
Data model to accomodate course requirements

#Teacher
Data model to accomodate teachers

#Training
Data model to accomodate tarining details

#Administrator
Class to accomodate administrator with core functionality methods

#CSVReader
File helper class to read csv files and populate respective arraylists

#CSVWriter
File helper class to write csv files and populate respective arraylists

