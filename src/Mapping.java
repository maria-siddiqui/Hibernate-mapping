import java.util.ArrayList;
import java.util.List;

public class Mapping {
public static void main(String[] args) {
	
	//CRUD Operations of Contact model
//	Contact contact = new Contact();
//	contact.createContact(1234,"fb area");
//	contact.deleteContact(2l);
//	contact = contact.getContact(2l);
//	contact.updateContact(2l, "block2", 343d);
	
	// Retrieving laptops from database
	Laptop laptop1 = new Laptop();
	Laptop laptop2 = new Laptop();
	laptop1 = laptop1.getLaptop(14l);
	laptop2 = laptop2.getLaptop(15l);
	
	// Adding both laptops in list
	List<Laptop> laptops = new ArrayList<>();
	laptops.add(laptop2);
	laptops.add(laptop1);
	
	//Adding that list into student setLaptopList
	Student student = new Student();
	student.createStudent("rameen",100,1l,laptops);
//	student.updateStudent(8l,"sana",99);
//	student.deleteStudent(10l);
//	student = student.getStudent(5l);
	
//	Laptop laptop = new Laptop();
//	laptop.createLaptop(2019, "Mac");
	
	}
}
