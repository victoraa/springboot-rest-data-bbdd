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
public class Garbage {

	@GeneratedValue (strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
    @Id
    private Integer id;
	
	@Column
	private String description;

	
	public Garbage () {
	}
	
	public Garbage (Integer idIn, final String desc) {
		this.id= idIn;
		this.description= desc;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
