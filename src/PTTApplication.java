import datamodels.Administrator;

public class PTTApplication {

	public static void main (String args[])
	{
		System.out.println("*** PTT application ****");
		
		// Read file and populate data models
		
		// Admin from departmentID=4 with id 193
		Administrator admin1=new Administrator(193, "Tom", 4);
		
	}
}
