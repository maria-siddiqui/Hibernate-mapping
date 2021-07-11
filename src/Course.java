import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private int creditHrs;
	
	@ManyToOne  
	private Student student;

	public void createCourse(String name, int creditHrs, long studentId) {
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Project.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Course course= new Course();
		Student student = new Student();
		course.setStudent(student.getStudent(studentId));
		//Student student=(Student)session.get(Student.class, studentId); //fetching data from database
	//	course.setStudent(student);
		course.setName(name);
		course.setCreditHrs(creditHrs);
		session.save(course);
		tx.commit();
		session.close();
		sf.close();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCreditHrs() {
		return creditHrs;
	}

	public void setCreditHrs(int creditHrs) {
		this.creditHrs = creditHrs;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
