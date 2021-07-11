import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class Laptop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private String name;
	private int model;
	
	public void createLaptop(int model, String name) {
		Laptop laptop = new Laptop();
		laptop.setName(name);
		laptop.setModel(model);
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(laptop);
		tx.commit();
		session.close();
		sf.close();
	}
	
	public Laptop getLaptop(long id) {
		Laptop laptop = new Laptop();
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		laptop=(Laptop)session.get(Laptop.class, id);
		tx.commit();
		session.close();
		sf.close();
		return laptop;
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

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}
	
	
	

}
