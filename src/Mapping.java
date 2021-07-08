import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {
public static void main(String[] args) {
	
	Laptop laptop = new Laptop();
	
//	laptop.setLid(103);
	laptop.setLname("Dell");
	
	
	Student s = new Student();
//	s.setRollNo(91);
	s.setName("Usman");
	s.setMarks(80);
//	s.setLap(laptop); //for one to one, student gets laptop object
	s.getLap().add(laptop); //for one to many and also for many to many, student gets laptop from the arraylist of laptop objects
	 
	
//	laptop.setStudent(s); // for many to one , laptop gets student object
	laptop.getStudent().add(s); //for many to many, laptop gets student from the arraylist of student object
	
	Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	SessionFactory sf = config.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	session.save(s);
	session.save(laptop);
	
	tx.commit();
	
	}
}
