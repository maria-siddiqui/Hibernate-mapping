import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Mapping {
public static void main(String[] args) {
	
	
	//CRUD Operations of Contact model
//	Contact contact = new Contact();
//	contact.createContact(2342d,"ABCD");
//	contact.deleteContact(2l);
//	contact = contact.getContact(2l);
//	contact.updateContact(2l, "block2", 343d);
	
//	Laptop laptop = new Laptop();
//	laptop.createLaptop(2019, "Lenovo");

	//Many to One - Creating course
	//Course course= new Course();
	//course.createCourse("English", 3, 16l);
	
	// Retrieving laptops from database
//	Laptop laptop1 = new Laptop();
//	Laptop laptop2 = new Laptop();

//	laptop1 = laptop1.getLaptop(2l);
//	laptop2 = laptop2.getLaptop(4l);

	// Adding both laptops in list
//	List<Laptop> laptops = new ArrayList<>();
//	laptops.add(laptop2);
//	laptops.add(laptop1);
	
	//Adding that list into student setLaptopList
//	Student student = new Student();
//	student.createStudent("Faarid",87,7l,laptops);
//	student.updateStudent(8l,"sana",99);
//	student.deleteStudent(10l);
//	student = student.getStudent(5l);
	
	
	//For ManyToMany
	// Retrieving student from database
//	Student student1 = new Student();
//	Student student2 = new Student();
//	
//	student1 = student1.getStudent(17l);
//	student2 = student2.getStudent(14l);
//	
//	List<Student> students = new ArrayList<>();
//	students.add(student2);
//	students.add(student1);
//	
//	Project project = new Project();
//	project.createProject("mm Project", students);

	
	// JPA Implentation
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("per");
	EntityManager em = emf.createEntityManager();
	em.getTransaction().begin();
//	Student s = em.find(Student.class,17l);
//	System.out.println(s.getName());
	
//	Test test = new Test();
//	test.setAddress("testing");
//	test.setCellNum(444d);
//	em.persist(test);
//	em.getTransaction().commit();

	// HQL GET RECORDS
//	Query query=em.createQuery("from Student");
//	query.setFirstResult(5);  
//	query.setMaxResults(7);  
//	List<Student> students=query.getResultList();
//	
//	for(Student student: students) {
//		System.out.println(student.getName());		
//	}
	
	// HQL UPDATE
//	Query q=em.createQuery("update Student set name=:n where id=:i");  
//	q.setParameter("n","Humna");  
//	q.setParameter("i",15l);
//	q.executeUpdate();
	
	//HQL DELETE
	Query query=em.createQuery("delete from Student where id=15");  
	query.executeUpdate(); 
	}
}
