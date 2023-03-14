package datamodels;

import java.util.List;

public class Teacher extends Staff{

String sub;
List<Skill> teacherSkill;

	public Teacher(int id,String name) {
		super(id, name);
	}
	
	public Teacher(int id,String name, String sub, List<Skill> teacherSkill) {
		super(id, name);
		this.sub=sub;
		this.teacherSkill=teacherSkill;
	}
	
	public String toString() {
		return "id: "+id+", name: "+name;
	}
}
