package entities.police;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import security.Authorizable;
import entities.entries.history.Action;
 

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



	@Override
	public void logChanges(Object old) {

		InvestigativeGroup oldInvGrp = (InvestigativeGroup) old;

		if (!this.name.equals(oldInvGrp.name))
			this.getHistory().addAction(new Action("name", this.name, oldInvGrp.name));

		if (this.authorizables.size() != oldInvGrp.authorizables.size()) {
			StringBuilder newData = new StringBuilder();
			StringBuilder oldData = new StringBuilder();

			for (Authorizable id : this.authorizables)
				newData.append(id.toString() + " ");

			for (Authorizable id : oldInvGrp.authorizables)
				oldData.append(id.toString() + " ");

			this.getHistory().addAction(new Action("authorizables", newData.toString(), oldData.toString()));
		} else {
			for (int i = 0; i < this.authorizables.size(); i++) {
				if (this.authorizables.get(i).getId().compareTo(oldInvGrp.authorizables.get(i).getId()) != 0)
					this.getHistory().addAction(
							new Action("authorizables", this.authorizables.get(i).toString(), oldInvGrp.authorizables
									.get(i).toString()));
			}
		}

	}

}
