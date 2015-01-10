
package security;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @authors Hamad Almarri, Ali Alqahtani, and Guangyi Zhang 
 * ErrorMessages: helper class to display error messages on view 
 */
public final class ErrorMessages {

    /*
     * adds error message to FacesMessage object,
     * which will display it on view page
     */
    final public void add(String item, String msg) {
        FacesContext fc = FacesContext.getCurrentInstance();
        FacesMessage facesMessage = new FacesMessage(msg);
        fc.addMessage(item, facesMessage);
    }
}
