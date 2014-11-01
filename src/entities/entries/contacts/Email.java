package entities.entries.contacts;

import javax.persistence.Entity;

import entities.entries.Person;


@Entity
public class Email extends Contact {

	private static final long serialVersionUID = -5841139598243346492L;



	public Email() {
		this.type = "Email";
	}



	public Email(Person p, String content) {
		super(p);
		this.type = "Email";
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
