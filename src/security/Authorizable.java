package security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import entities.entries.history.Changeable;
import entities.police.InvestigativeGroup;
import entities.police.Notification;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQueries({ @NamedQuery(name = "Authorizable.findAll", query = "select a from Authorizable a"),
		@NamedQuery(name = "Authorizable.findById", query = "select a from Authorizable a WHERE a.id = :id") })
public class Authorizable extends Changeable implements Serializable {

	private static final long serialVersionUID = -2605602317234236536L;

	@OneToMany(mappedBy = "authorizable")
	protected List<Permission> permissions;

	@ManyToMany(mappedBy = "authorizables")
	protected List<InvestigativeGroup> investigativeGroups;

	@OneToMany(mappedBy = "causedBy")
	private List<Notification> causesNotifications = new ArrayList<Notification>();

	@OneToMany(mappedBy = "to")
	private List<Notification> recivedNotifications = new ArrayList<Notification>();

	protected String type;



	public List<Permission> getPermissions() {
		return this.permissions;
	}



	public List<InvestigativeGroup> getInvestigativeGroups() {
		return investigativeGroups;
	}



	public String getName() {
		return "";
	}



	public List<Notification> getCausesNotifications() {
		return causesNotifications;
	}



	public void setCausesNotificatiosn(List<Notification> causesNotifications) {
		this.causesNotifications = causesNotifications;
	}



	public void addCausesNotification(Notification causesNotification) {
		this.causesNotifications.add(causesNotification);
	}



	public List<Notification> getRecivedNotifications() {
		return recivedNotifications;
	}



	public void setRecivedNotifications(List<Notification> recivedNotifications) {
		this.recivedNotifications = recivedNotifications;
	}



	public void addRecivedNotification(Notification recivedNotification) {
		this.recivedNotifications.add(recivedNotification);
	}



	public String getType() {
		return type;
	}



	@Override
	public void logChanges(Object old) {
		// TODO Auto-generated method stub

	}

}
