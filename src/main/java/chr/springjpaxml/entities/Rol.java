package chr.springjpaxml.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "ROL")
public class Rol implements GrantedAuthority{
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE)
	private Long id_rol;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "ID_USER")
	private User user;

	public Rol(String name) {
		super();
		this.name = name;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return name;
	}
	
	
}
