package datamodels;

public class Staff {

	private int id;
	private String name;
	private int departmentID;
	
	public Staff(int id,String name,int departmentID) {
		this.id=id;
		this.name=name;
		this.departmentID=departmentID;
	}
	
	public void setID(int id) {
		this.id=id;
	}
	
	public int getID() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDepartmentID(int departmentID) {
		this.departmentID=departmentID;
	}
	
	public int getDepartmentID() {
		return departmentID;
	}
}
