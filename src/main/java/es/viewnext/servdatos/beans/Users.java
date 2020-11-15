package es.viewnext.servdatos.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
/**
 * Bean de la tabla garbage
 *
 */

@Entity
public class Users {

	@GeneratedValue (strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
    @Id
    private Integer id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String fullname;
	
	@Column
	private String email;

	
	public Users () {
	}
	
 
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	
}
