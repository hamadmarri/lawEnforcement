package entities.police;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Activity implements Serializable {

	private static final long serialVersionUID = -4496487588138153339L;

	@Id
	@GeneratedValue
	Long id;


	@ManyToOne(cascade = CascadeType.ALL)
	private InvestigativeCase investigativeCase;
	

	// TODO: need to implement Activity fields

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
