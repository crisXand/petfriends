package chr.springjpaxml.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="typepet")
	private String typepet;
	
	@Column(name="age")
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "idCustomer")
	private Customer customer;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTypepet() {
		return typepet;
	}

	public void setTypepet(String typepet) {
		this.typepet = typepet;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Pet(Long id, String name, String typepet, int age) {
		super();
		this.id = id;
		this.name = name;
		this.typepet = typepet;
		this.age = age;
	}
	
	public Pet() {}
	
}
