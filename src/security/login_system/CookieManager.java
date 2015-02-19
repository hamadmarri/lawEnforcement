package security.login_system;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;


public class CookieManager {

	public void setCookie(HttpServletResponse httpServletResponse, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setSecure(true);
		cookie.setMaxAge(365 * 24 * 60 * 60);
		httpServletResponse.addCookie(cookie);
	}



	public String getCookie(FacesContext fc, String name) {
		Map<String, Object> cookies = fc.getExternalContext().getRequestCookieMap();
		Cookie cookie = (Cookie) cookies.get(name);
		return cookie.getValue();
	}



	public void removeCookie(HttpServletResponse httpServletResponse, String name, String value) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(0);
		httpServletResponse.addCookie(cookie);
	}
}
