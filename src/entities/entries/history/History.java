package entities.entries.history;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class History implements Serializable {

	private static final long serialVersionUID = -1213900379697482433L;

	@Id
	@GeneratedValue
	private Long id;

	private List<Action> actions;

}
