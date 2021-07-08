import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int rollNo;
	private String name;
	private int marks;
	
//	@OneToOne //for one to one relationship
//	private Laptop lap; //for one to one relation, laptop_lid will become column in student table because laptop object is made in student class
	/*for one to one only*/
//	public Laptop getLap() {
//		return lap;
//	}
//	public void setLap(Laptop lap) {
//		this.lap = lap;
//	}

//	@OneToMany(mappedBy="student") //for Student it is one to many relationship because one student can have multiple laptops and it will not create table because mapped by laptop
	
	@ManyToMany(mappedBy="student") //creates only Laptop_student table
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
