package security;

import java.util.Calendar;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("birthDateValidator")
public class BirthDateValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		if (value == null) {
			return;
		}

		Date birthDate = (Date) value;
		Calendar cal = Calendar.getInstance();

		cal.add(Calendar.YEAR, -150);

		if (birthDate.before(cal.getTime()) || birthDate.after(new Date())) {

			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Start date may not be after end date.", null));
		}

	}

}
