package entities.entries.files.images;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import entities.entries.files.EntryFile;


@Entity
@NamedQueries({ @NamedQuery(name = "Image.findAll", query = "select e from Image e"),
	@NamedQuery(name = "Image.findById", query = "select e from Image e WHERE e.id = :id") })
public class Image extends EntryFile {

	private static final long serialVersionUID = 3099664754672904721L;



	public Image() {
		super();
		this.type = "Image";
	}



	public Image(String caption, String link) {
		super(caption, link);
		this.type = "Image";
	}

}
