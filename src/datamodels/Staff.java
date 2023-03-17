package datamodels;

/** Datamodel to accomodate 'Staff' object
 * 
 * This is the super class of Teacher and Administrator classes
 * 
 * @author Saranya
 *
 */
public class Staff {

	protected int id;
	protected String name;
	protected int departmentID;
	

	/** constructor method
	 * 
	 * @param id
	 * @param name
	 */
	public Staff(int id,String name) {
		this.id=id;
		this.name=name;
		// this.departmentID=departmentID;
	}
	

	/** constructor method
	 * 
	 * @param id
	 * @param name
	 * @param departmentID
	 */
	public Staff(int id,String name,int departmentID) {
		this.id=id;
		this.name=name;
		this.departmentID=departmentID;
	}
	
	/** Setter and getter methods for 'id'
	 * 
	 * @param id
	 */
	public void setID(int id) {
		this.id=id;
	}
	
	public int getID() {
		return id;
	}
	
	/** Setter and getter methods for 'name'
	 * 
	 * @param id
	 */
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	/** Setter and getter methods for 'departmentID'
	 * 
	 * @param id
	 */
	public void setDepartmentID(int departmentID) {
		this.departmentID=departmentID;
	}
	
	public int getDepartmentID() {
		return departmentID;
	}
}
