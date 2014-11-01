package entities.entries.files.images;

import javax.persistence.Entity;

import entities.entries.files.EntryFile;


@Entity
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
