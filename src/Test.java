import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity
public class Test {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private double cellNum;
	private String address;
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
