import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	@ManyToMany
	private List<Student> studentList;
	
	public void createProject(String name,List<Student> studentList) {
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Project.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Project project = new Project();
		project.setName(name);
		project.setStudentList(studentList);
		session.save(project);
		tx.commit();
		session.close();
		sf.close();
	}
	
	public Project getProject(long id) {
		Project project = new Project();
		Configuration config = new Configuration().configure("mapping.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Contact.class).addAnnotatedClass(Laptop.class).addAnnotatedClass(Project.class);
		SessionFactory sf = config.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		project=(Project)session.get(Project.class, id);
		tx.commit();
		session.close();
		sf.close();
		return project;
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

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
}
