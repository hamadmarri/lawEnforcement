package entities.police;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import security.Authorizable;


@Entity
@NamedQueries({
		@NamedQuery(name = "InvestigativeGroup.findAll", query = "select i from InvestigativeGroup i"),
		@NamedQuery(name = "InvestigativeGroup.findById", query = "select i from InvestigativeGroup i WHERE i.id = :id") })
public class InvestigativeGroup extends Authorizable {

	private static final long serialVersionUID = 5554321183998170829L;

	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Authorizable> authorizables;

	private String name;



	public InvestigativeGroup() {
		super();
		this.type = "InvestigativeGroup";
	}



	public InvestigativeGroup(String name) {
		super();
		this.type = "InvestigativeGroup";
		this.name = name;
	}



	public List<Authorizable> getAuthorizables() {
		return authorizables;
	}



	public void setAuthorizables(List<Authorizable> authorizables) {
		this.authorizables = authorizables;
	}



	public void addAuthorizable(Authorizable authorizable) {
		if (this.authorizables == null)
			this.authorizables = new ArrayList<Authorizable>();

		this.authorizables.add(authorizable);
	}



	@Override
	public String toString() {
		return name;
	}



	@Override
	public String getName() {
		return this.toString();
	}



	public void setName(String name) {
		this.name = name;
	}

}
