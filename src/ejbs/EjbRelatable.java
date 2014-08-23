package ejbs;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import entities.Relatable;


@Stateless
public class EjbRelatable extends AbstractEjb<Relatable> {

	@PostConstruct
	public void init() {
		this.entityName = "Relatable";
	}

}
