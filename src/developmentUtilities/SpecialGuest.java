package developmentUtilities;

import javax.persistence.Entity;

import developmentUtilities.Guest;


@Entity
public class SpecialGuest extends Guest {

	private static final long serialVersionUID = 8329072146735811731L;

	private String speciality;

}
