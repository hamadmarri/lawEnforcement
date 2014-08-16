package entities.events;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


/**
 * Entity implementation class for Entity: Permit
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Permit extends Event {

	private static final long serialVersionUID = 3382900005934861030L;



	public Permit() {
		super();
	}

}
