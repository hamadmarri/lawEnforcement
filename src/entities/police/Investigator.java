package entities.police;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Investigator
 * 
 */
@Entity
public class Investigator implements Serializable {

	private static final long serialVersionUID = 8113176629170268715L;

	@Id
	@GeneratedValue
	Long id;

	@ManyToMany(mappedBy = "investigators")
	private List<InvestigativeCase> cases;



	public Investigator() {
		super();
	}



	public Long getId() {
		return id;
	}



	public List<InvestigativeCase> getCases() {
		return cases;
	}

}
