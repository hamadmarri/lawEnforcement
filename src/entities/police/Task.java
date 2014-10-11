package entities.police;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Task implements Serializable {

	private static final long serialVersionUID = 7579247009001810295L;

	@Id
	@GeneratedValue
	Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private InvestigativeCase investigativeCase;



	// TODO: need to implement Task fields

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
