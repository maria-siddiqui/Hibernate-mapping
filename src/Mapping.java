import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {
public static void main(String[] args) {
	
	Laptop laptop = new Laptop();
	laptop.setLid(101);
	laptop.setLname("Dell");
	
	Student s = new Student();
	s.setRollNo(98);
	s.setName("Maria Siddiqui");
	s.setMarks(70);
	s.getLaptop().add(laptop); //getLaptop gives arrayList from the added arrayList

	Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
	SessionFactory sf = config.buildSessionFactory();
	Session session = sf.openSession();
	Transaction tx = session.beginTransaction();
	session.save(s);
	session.save(laptop);
	tx.commit();
	
	}
}
