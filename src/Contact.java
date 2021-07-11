import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private double cellNum;
	private String address;
	
	public void createContact(int cellNum, String address) {
		Contact contact = new Contact();
		contact.setCellNum(cellNum);
		contact.setAddress(address);
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(contact);
		tx.commit();
		session.close();
		sf.close();
	}
	
	public Contact getContact(long id) {
		Contact contact = new Contact();
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		contact=(Contact)session.get(Contact.class, id);
		tx.commit();
		session.close();
		sf.close();
		return contact;
	}
	
	public void updateContact(long id, String address, double cellNum) {
		Contact contact = new Contact();
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		contact=(Contact)session.get(Contact.class, id); // We get the contact of the passed ID
		// Now we are updating the contact retrieved
		contact.setCellNum(cellNum);
		contact.setAddress(address);
		// Now saving the contact in database
		session.save(contact);
		tx.commit();
		session.close();
		sf.close();		
	}
	

	public void deleteContact(long id) {
		Contact contact = new Contact();
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		contact=(Contact)session.get(Contact.class, id); // We get the contact of the passed ID
		// Now deleting the contact in database
		session.delete(contact);
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
	public double getCellNum() {
		return cellNum;
	}
	public void setCellNum(double cellNum) {
		this.cellNum = cellNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
