import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderColumn;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rollNo;
	private String name;
	private int marks;
	
//	@OneToOne
//	private Laptop lap; //for one to one relation, laptop_id will become column in student table because laptop object is made in student class
//	public Laptop getLap() {
//		return lap;
//	}
//	public void setLap(Laptop lap) {
//		this.lap = lap;
//	}

//	@OneToMany(mappedBy="student") 
	
	@ManyToMany//creates only Laptop_student table
	private List<Laptop> lap = new ArrayList<>(); //creates arrayList of laptop because for multiple laptops there should be list of laptops
	public List<Laptop> getLap() {
		return lap;
	}
	public void setLap(List<Laptop> lap) { 
		this.lap = lap;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", marks=" + marks + "]";
	}
	
}
