import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {
public static void main(String[] args) {
	
	//Laptop laptop = new Laptop();
	
//	laptop.setLid(103);
//	laptop.setLname("Toshiba");
	
//	Student s = new Student();
//	s.setRollNo(99);
//	s.setName("Affan");
//	s.setMarks(70);
//	s.setLap(laptop); //for one to one, student gets laptop object
//	s.getLap().add(laptop); //for one to many and also for many to many, student gets laptop from the arraylist of laptop objects
//	s.getLap().add(laptop2);
	
//	laptop.setStudent(s); // for many to one , laptop gets student object
//	laptop.getStudent().add(s); //for many to many, laptop gets student from the arraylist of student object
	
	Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	SessionFactory sf = config.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	//session.save(s);
//	session.save(laptop);
//	session.save(laptop2); 
	Laptop laptop,laptop1 = new Laptop();
	//laptop=(Laptop)session.get(Laptop.class, 47); //fetching data from database
	laptop1=(Laptop)session.get(Laptop.class, 48); //fetching data from database

// is mai wo laptop ajaega dell wala
	Student student= new Student();
	student=(Student)session.get(Student.class, 48);
	// is mai usman
	List<Laptop> laptops = new ArrayList<>();
	//laptops.add(laptop)
	laptops.add(laptop1);
	//jo oopr laptop fetch kiya wo is list mai dala, now is list ko student mai
	student.setLaptops(laptops);
	session.save(student);
	tx.commit();
	
	}
}
