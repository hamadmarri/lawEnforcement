package controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import ejbs.AbstractEjb;
import entities.events.Event;
import entities.police.Activity;
import entities.police.InvestigativeCase;
import entities.police.Officer;


@ManagedBean(name = "controllerActivity")
@ViewScoped
public class ControllerActivity {

	@EJB
	protected AbstractEjb<Activity> ejbActivity;

	protected String id;
	protected Activity activity;
	protected List<Activity> list = null;
	protected boolean newActivity = false;



	@PostConstruct
	public void initAbstract() {
		this.ejbActivity.setEntityName("Activity");
	}



	public String submit() {

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



	public Activity getActivity() {
		if (this.activity != null)
			return this.activity;

		if (this.id == null)
			return null;

		this.activity = (Activity) ejbActivity.getEntity(Long.parseLong(this.id));

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

}
