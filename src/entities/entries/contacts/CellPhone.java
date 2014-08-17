package entities.entries.contacts;

import javax.persistence.Entity;

import entities.entries.Person;


@Entity
public class CellPhone extends Contact {

	private static final long serialVersionUID = -5841139598243346492L;



	public CellPhone() {
		this.name = "CellPhone";
	}



	public CellPhone(Person p, String content) {
		super(p);
		this.name = "CellPhone";
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
