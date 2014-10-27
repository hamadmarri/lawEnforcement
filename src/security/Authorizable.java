package security;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import entities.police.InvestigativeGroup;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({ @NamedQuery(name = "Authorizable.findAll", query = "select a from Authorizable a"),
		@NamedQuery(name = "Authorizable.findById", query = "select a from Authorizable a WHERE a.id = :id") })
public class Authorizable implements Serializable {

	private static final long serialVersionUID = -2605602317234236536L;

	@Id
	@GeneratedValue
	Long id;

	@OneToMany(mappedBy = "authorizable")
	protected List<Permission> permissions;

	@ManyToMany(mappedBy = "authorizables")
	protected List<InvestigativeGroup> investigativeGroups;

	protected String type;



	public Long getId() {
		return id;
	}



	public List<Permission> getPermissions() {
		return this.permissions;
	}



	public List<InvestigativeGroup> getInvestigativeGroups() {
		return investigativeGroups;
	}



	public String getName() {
		return "";
	}



	public String getType() {
		return type;
	}

}
