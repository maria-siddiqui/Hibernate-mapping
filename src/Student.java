import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int marks;
	
	@OneToMany
	List<Laptop> laptopList;
	
	@OneToOne
	private Contact contact;
	
	public void createStudent(String name, int marks, long contactId, List<Laptop> laptops) {
		Student student= new Student();
		Contact contact= new Contact();
		student.setName(name);
		student.setMarks(marks);
		// Calling the getContact function from the Contact class which returns a contact obj and passing it to setContact
		student.setContact(contact.getContact(contactId));
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Project.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		student.setLaptopList(laptops);
		session.save(student);
		tx.commit();
		session.close();
		sf.close();
	}
	
	public Student getStudent(long id) {
		Student student = new Student();
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Project.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		student=(Student)session.get(Student.class, id);
		tx.commit();
		session.close();
		sf.close();
		return student;
	}
	
	public void updateStudent(long id, String name, int marks) {
		Student student = new Student();
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Project.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		student=(Student)session.get(Student.class, id); // We get the contact of the passed ID
		// Now we are updating the contact retrieved
		student.setName(name);
		student.setMarks(marks);
		// Now saving the contact in database
		session.save(student);
		tx.commit();
		session.close();
		sf.close();	
	}
	
	public void deleteStudent(long id) {
		Student student = new Student();
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Project.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		student=(Student)session.get(Student.class, id); // We get the student of the passed ID
		// Now deleting the student in database
		session.delete(student);
		tx.commit();
		session.close();
		sf.close();	
	}
	

	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
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
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

	public List<Laptop> getLaptopList() {
		return laptopList;
	}

	public void setLaptopList(List<Laptop> laptopList) {
		this.laptopList = laptopList;
	}
}
