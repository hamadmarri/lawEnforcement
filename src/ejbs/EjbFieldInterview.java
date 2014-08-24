package ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import entities.events.FieldInterview;


@Stateless
public class EjbFieldInterview extends AbstractEjb<FieldInterview> {

	@PostConstruct
	public void init() {
		this.entityName = "FieldInterview";
	}

}
