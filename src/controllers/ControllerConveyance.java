package controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.entries.Conveyance;


@ManagedBean(name = "controllerConveyance")
@ViewScoped
public class ControllerConveyance extends AbstarctController<Conveyance> implements Serializable {

	private static final long serialVersionUID = -3709992694215689104L;



	public Conveyance getConveyance() {
		return super.getRelatable();
	}



	public void setConveyance(Conveyance conveyance) {
		this.relatable = conveyance;
	}

}