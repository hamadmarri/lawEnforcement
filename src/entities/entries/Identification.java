package entities.entries;

import java.io.Serializable;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Identification
 * 
 */
@Entity
public class Identification implements Serializable {

	private static final long serialVersionUID = 5245866625576748003L;

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	private String content;

	@ManyToOne
	private Person owner;



	public Identification() {
		super();
		this.name = new String();
		this.content = new String();
	}



	public Identification(Person owner) {
		this.owner = owner;
	}



	public Identification(Person owner, String name, String content) {
		this.owner = owner;
		this.name = name;
		this.content = content;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Long getId() {
		return id;
	}

}
