package entities.entries.files;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import entities.Relatable;
import entities.entries.Entry;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({ @NamedQuery(name = "EntryFile.findAll", query = "select e from EntryFile e"),
		@NamedQuery(name = "EntryFile.findById", query = "select e from EntryFile e WHERE e.id = :id") })
public class EntryFile extends Entry {

	private static final long serialVersionUID = 998978197930518505L;

	protected String caption;

	@Column(unique = true)
	protected String absoluteLink;

	protected String relativeLink;

	@ManyToOne(cascade = CascadeType.MERGE)
	protected Relatable relatable; 



	public EntryFile() {
		super();
		this.type = "File";
		this.caption = new String();
		this.absoluteLink = new String();
	}



	public EntryFile(String caption, String link) {
		super();
		this.type = "File";
		this.caption = caption;
		this.absoluteLink = link;
	}



	public String getCaption() {
		return caption;
	}



	public void setCaption(String caption) {
		this.caption = caption;
	}



	public String getAbsoluteLink() {
		return absoluteLink;
	}



	public void setAbsoluteLink(String absoluteLink) {
		this.absoluteLink = absoluteLink;
		this.relativeLink = absoluteLink.substring(absoluteLink.indexOf("/upload"));
	}



	public String getRelativeLink() {
		return relativeLink;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Relatable getRelatable() {
		return relatable;
	}



	public void setRelatable(Relatable relatable) {
		this.relatable = relatable;
	}



	@Override
	public String toString() {
		return this.caption;
	}

}
