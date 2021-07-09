import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {
public static void main(String[] args) {
	
	Laptop laptop = new Laptop();
	Laptop laptop2 = new Laptop();
	
	Student s = new Student();
	Student s2 = new Student();
	
	laptop.setLname("dell");
	laptop2.setLname("hp");
//	laptop.setStudent(s); // for many to one , laptop gets student object
	laptop.getStudent().add(s); //for many to many, laptop gets student from the arraylist of student object
	laptop2.getStudent().add(s);
	laptop.getStudent().add(s2);
	laptop2.getStudent().add(s2); 
	
	s.setName("sana");
	s.setMarks(79);
	s2.setName("maria");
	s2.setMarks(69);
//	s.setLap(laptop); //for one to one, student gets laptop object
	s.getLap().add(laptop); //for one to many and also for many to many, student gets laptop from the arraylist of laptop objects
	s.getLap().add(laptop2);
	s2.getLap().add(laptop);
	s2.getLap().add(laptop2);
	
	Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	SessionFactory sf = config.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	session.save(s);
	session.save(s2);
	session.save(laptop);
	session.save(laptop2);
	tx.commit();
	}
}
