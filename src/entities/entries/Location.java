package entities.entries;

import javax.persistence.Entity;

import entities.entries.history.Changeable;


/**
 * Entity implementation class for Entity: Location
 * 
 */
@Entity
public class Location extends Entry implements Changeable {

	private static final long serialVersionUID = -5026404539659981489L;



	public Location() {
		super();
	}



	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "My location value";
	}

}
