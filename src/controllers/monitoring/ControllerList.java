package controllers.monitoring;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


/**
 * @author hamadalmarri
 * 
 * @Pages
 * 
 * @Relative_Objects
 * 
 */
@ManagedBean(name = "controllerList")
@ViewScoped
public class ControllerList {
	private List<String> list;



	@PostConstruct
	public void init() {
		this.list = new ArrayList<String>();

		for (int i = 0; i < 10; i++) {
			list.add(Integer.toString(i));
		}

	}



	public List<String> getList() {
		return list;
	}



	public void setList(List<String> list) {
		this.list = list;
	}

}
