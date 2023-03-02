package datamodels;

public class Teacher extends Staff{

	public Teacher(int id,String name) {
		super(id, name);
	}
	
	
	public String toString() {
		return "id: "+id+", name: "+name;
	}
}
