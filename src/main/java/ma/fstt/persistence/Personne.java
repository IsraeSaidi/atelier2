package ma.fstt.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "personne")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
public abstract class Personne implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "email",unique=true)
	private String email;
	@Column(name = "password")
	private String password; 
	@Column(name = "role")
	private String role;
	public Personne() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Personne(int id, String email, String password, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
}
