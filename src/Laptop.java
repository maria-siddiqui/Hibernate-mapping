import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Laptop { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int lid;
	private String lname;
	
//	@ManyToOne //for Laptop it is Many to One relationship because multiple laptops belong to one student only
//	private Student student; //by this laptop will know about student i.e.it has one more field in table of student_rollNo
	/*for many to one*/
//	public Student getStudent() {
//		return student;
//	}
//	public void setStudent(Student student) {
//		this.student = student;
//	}
	
	@ManyToMany
	private List<Student> student = new ArrayList<>();
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

}
