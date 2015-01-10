package ejbs;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import entities.Groups;
import entities.Users;
import entities.VUsersGroup;


/**
 * Session Bean implementation class UserGroupEJB
 */
/**
 * @author hamadalmarri
 * 
 */
@Stateless
public class UserGroupEJB {

	@PersistenceContext(unitName = "adalaSecurityPersistenceUnit")
	private EntityManager em;
	private String emailTo = new String("");



	@SuppressWarnings("unchecked")
	public List<VUsersGroup> findAll() {
		return em.createNamedQuery("VUsersGroup.findAll").getResultList();
	}



	@SuppressWarnings("unchecked")
	public List<Users> findAllUsers() {
		// return this.allUsers;
		return (List<Users>) em.createNamedQuery("Users.findAllUsers").getResultList();
	}



	public Users findUser(int userId) {
		return (Users) em.find(Users.class, userId);
	}



	public Users findUser(String username) {
		try {
			return (Users) em.createNamedQuery("Users.findByUsername").setParameter("username", username)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}



	public Users findByValidationCode(String validationCode) {
		try {
			return (Users) em.createNamedQuery("Users.findByValidationCode")
					.setParameter("validationCode", validationCode).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}



	public void validateUser(Users user) {
		user.setValidated((short) 1);
		em.merge(user);
		// em.flush();
		// em.refresh(user);
	}



	public void deleteUser(int userId) {
		try {
			Users user = em.find(Users.class, userId);
			em.remove(user);
			em.flush();
		} catch (NoResultException e) {
			return;
		}
	}



	public void addUser(Users users, int groupId) {
		Groups groups = em.find(Groups.class, groupId);
		List<Groups> groupList = new ArrayList<Groups>();
		groupList.add(groups);
		users.setGroupsList(groupList);
		em.persist(users);
		em.flush();
		em.refresh(users);
	}



	public String getEmailTo() {
		return emailTo;
	}



	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

}
