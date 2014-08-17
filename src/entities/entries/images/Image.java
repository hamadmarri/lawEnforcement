package entities.entries.images;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import entities.entries.Entry;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Image extends Entry {

	private static final long serialVersionUID = 3099664754672904721L;

	private String caption;
	private String link;



	public Image() {
		super();
	}



	public Image(String caption, String link) {
		super();
		this.caption = caption;
		this.link = link;
	}



	public String getCaption() {
		return caption;
	}



	public void setCaption(String caption) {
		this.caption = caption;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	@Override
	public String toString() {
		return this.caption;
	}

}
