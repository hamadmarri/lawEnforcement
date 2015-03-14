package entities.entries.contacts;

import javax.persistence.Entity;

import entities.entries.Person;


@Entity
public class OtherContact extends Contact {

	private static final long serialVersionUID = -8666042348814945984L;



	public OtherContact() {
		this.type = "Other";
	}



	public OtherContact(Person p, String content) {
		super(p);
		this.type = "Other";
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
