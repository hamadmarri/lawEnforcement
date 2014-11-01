package entities.entries.contacts;

import javax.persistence.Entity;

import entities.entries.Person;


@Entity
public class Telephone extends Contact {

	private static final long serialVersionUID = -5841139598243346492L;



	public Telephone() {
		this.type = "Telephone";
	}



	public Telephone(Person p, String content) {
		super(p);
		this.type = "Telephone";
		setContent(content);
	}



	@Override
	public String getContent() {
		return this.content;
	}



	@Override
	public void setContent(String content) {
		this.content = content;
	}

}
