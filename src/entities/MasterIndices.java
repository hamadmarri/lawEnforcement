package entities;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

import entities.entries.Entry;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 * Entity implementation class for Entity: MasterIndices
 * 
 */
@Entity
public class MasterIndices implements Serializable {

	private static final long serialVersionUID = 7398053196433761468L;

	@Id
	@GeneratedValue
	private Long id;



	public MasterIndices() {
		super();
	}



	public List<Entry> search() {
		// TODO: search()
		throw new NotImplementedException();
	}



	public void add() {
		// TODO: add()
		throw new NotImplementedException();
	}



	public void remove() {
		// TODO: remove()
		throw new NotImplementedException();
	}

}
