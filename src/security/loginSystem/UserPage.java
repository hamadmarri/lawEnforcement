package security.loginSystem;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;

import security.loginSystem.qualifiers.Username;
import ejbs.UserGroupEJB;
import entities.Users;


@Named
@RequestScoped
public class UserPage {

	@EJB
	private UserGroupEJB userGroupEJB;

	@Inject
	@Username
	private String username;
	private Users user = null;
	private LineChartModel lineModel;
	private boolean loggedIn = false;



	@PostConstruct
	void init() {
		this.loggedIn = !this.username.isEmpty();
	}



	public void checkUserIfValidated() {
		this.user = userGroupEJB.findUser(username);
	}



	public Users getUser() {
		return user;
	}



	public void setUser(Users user) {
		this.user = user;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public boolean isLoggedIn() {
		return this.loggedIn;
	}



	public void insistNotLogedIn() {
		if (isLoggedIn()) {
			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/ENSE353Project/");
			} catch (IOException e) {
				return;
			}
		}
	}



	public LineChartModel getLineModel() {
		lineModel = initCategoryModel();
		lineModel.setTitle("Category Chart");
		lineModel.setLegendPosition("e");
		lineModel.setShowPointLabels(true);
		lineModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
		Axis yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setLabel("Stocks");
		yAxis.setMin(0);
		yAxis.setMax(100);
		return lineModel;
	}



	private LineChartModel initCategoryModel() {
		LineChartModel model = new LineChartModel();

		ChartSeries uofr = new ChartSeries();
		uofr.setLabel("UofR");
		uofr.set("2000", Math.random() * 100);
		uofr.set("2001", Math.random() * 100);
		uofr.set("2002", Math.random() * 100);
		uofr.set("2003", Math.random() * 100);
		uofr.set("2004", Math.random() * 100);
		uofr.set("2005", Math.random() * 100);
		uofr.set("2006", Math.random() * 100);
		uofr.set("2007", Math.random() * 100);
		uofr.set("2008", Math.random() * 100);

		ChartSeries mit = new ChartSeries();
		mit.setLabel("MIT");
		mit.set("2000", Math.random() * 100);
		mit.set("2001", Math.random() * 100);
		mit.set("2002", Math.random() * 100);
		mit.set("2003", Math.random() * 100);
		mit.set("2004", Math.random() * 100);
		mit.set("2005", Math.random() * 100);
		mit.set("2006", Math.random() * 100);
		mit.set("2007", Math.random() * 100);
		mit.set("2008", Math.random() * 100);

		model.addSeries(uofr);
		model.addSeries(mit);

		return model;
	}

}
