package entities.entries;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Relation implements Serializable {

	private static final long serialVersionUID = -8623094115473557995L;

	@Id
	@GeneratedValue
	private Long id;

	private Entry something;
	private String typeOfRelation;
	private Entry somethingElse;

}
