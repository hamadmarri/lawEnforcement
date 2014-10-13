package controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.police.Activity;
import entities.police.InvestigativeCase;
import entities.police.Investigator;


@ManagedBean(name = "controllerActivity")
@ViewScoped
public class ControllerActivity {

	@EJB
	protected AbstractEjb<Activity> ejbActivity;

	@EJB
	private AbstractEjb<Investigator> ejbInvestigator;

	@EJB
	private AbstractEjb<InvestigativeCase> ejbInvestigativeCase;

	protected String id;
	protected Activity activity;
	protected List<Activity> list = null;
	protected boolean newActivity = false;
	private Long investigatorId = null;
	private Long investigativeCaseId = null;



	@PostConstruct
	public void initAbstract() {
		this.ejbActivity.setEntityName("Activity");
	}



	public String submit() {

		// update investigator based on its id
		if (this.investigatorId != null) {
			Investigator inv = (Investigator) this.ejbInvestigator.getEntity(this.investigatorId, "Investigator");
			this.getActivity().setInvestigator(inv);
		}

		// update investigativeCase based on its id
		if (this.investigativeCaseId != null) {
			InvestigativeCase invCase = (InvestigativeCase) this.ejbInvestigativeCase.getEntity(
					this.investigativeCaseId, "InvestigativeCase");
			this.getActivity().setInvestigativeCase(invCase);
		}

		if (isNewActivity())
			ejbActivity.add(this.activity);
		else
			ejbActivity.save(this.activity);

		return "success";
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public void createNewActivity() {
		this.activity = new Activity();
		this.setNewActivity(true);
	}



	public Activity getActivity() {
		if (this.activity != null)
			return this.activity;

		if (this.id == null)
			return null;

		this.activity = (Activity) ejbActivity.getEntity(Long.parseLong(this.id));

		// hold the id of investigator
		if (this.investigatorId == null && this.activity != null && this.activity.getInvestigator() != null)
			setInvestigatorId(this.activity.getInvestigator().getId());

		// hold the id of investigativeCase
		if (this.investigativeCaseId == null && this.activity != null && this.activity.getInvestigativeCase() != null)
			setInvestigativeCaseId(this.activity.getInvestigativeCase().getId());

		return this.activity;
	}



	public void setActivity(Activity activity) {
		this.activity = activity;
	}



	public List<Activity> getList() {
		if (this.list == null)
			this.list = (List<Activity>) ejbActivity.getList();

		return list;
	}



	public void setList(List<Activity> list) {
		this.list = list;
	}



	public boolean isNewActivity() {
		return newActivity;
	}



	public void setNewActivity(boolean newActivity) {
		this.newActivity = newActivity;
	}



	public Long getInvestigatorId() {
		return investigatorId;
	}



	public void setInvestigatorId(Long investigatorId) {
		this.investigatorId = investigatorId;
	}



	public Long getInvestigativeCaseId() {
		return investigativeCaseId;
	}



	public void setInvestigativeCaseId(Long investigativeCaseId) {
		this.investigativeCaseId = investigativeCaseId;
	}

}
