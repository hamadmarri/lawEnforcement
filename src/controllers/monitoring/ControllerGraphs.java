package controllers.monitoring;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.HorizontalBarChartModel;
import org.primefaces.model.chart.PieChartModel;


/**
 * @author hamadalmarri
 * 
 * @Pages
 * 
 * @Relative_Objects
 * 
 */
@ManagedBean(name = "controllerGraphs")
@RequestScoped
public class ControllerGraphs {

	private BarChartModel barModel;
	private HorizontalBarChartModel casesStatusBarModel;
	private PieChartModel pieModel1;

	@ManagedProperty(value = "#{controllerList}")
	private ControllerList controllerList;



	@PostConstruct
	public void init() {
		createBarModels();
	}



	public BarChartModel getBarModel() {
		return barModel;
	}



	public HorizontalBarChartModel getCasesStatusBarModel() {
		return casesStatusBarModel;
	}



	public PieChartModel getPieModel1() {
		return pieModel1;
	}



	private BarChartModel initBarModel() {
		BarChartModel model = new BarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 120);
		boys.set("2005", 100);
		boys.set("2006", 44);
		boys.set("2007", 150);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 110);
		girls.set("2007", 135);
		girls.set("2008", 120);

		model.addSeries(boys);
		model.addSeries(girls);

		return model;
	}



	private void createBarModels() {
		createBarModel();
		createHorizontalBarModel();
		createPieModel1();
	}



	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Bar Chart");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Gender");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Births");
		yAxis.setMin(0);
		yAxis.setMax(200);
	}



	private void createHorizontalBarModel() {
		casesStatusBarModel = new HorizontalBarChartModel();

		ChartSeries open = new ChartSeries();
		ChartSeries pending = new ChartSeries();
		ChartSeries inProgress = new ChartSeries();
		ChartSeries refused = new ChartSeries();
		ChartSeries closed = new ChartSeries();

		open.setLabel("Open");
		open.set("", (int) 4);

		pending.setLabel("Pending");
		pending.set("", 2);

		inProgress.setLabel("In Progress");
		inProgress.set("", 10);

		closed.setLabel("closed");
		closed.set("", 4);

		refused.setLabel("refused");
		refused.set("", 1);

		casesStatusBarModel.addSeries(open);
		casesStatusBarModel.addSeries(pending);
		casesStatusBarModel.addSeries(inProgress);
		casesStatusBarModel.addSeries(closed);
		casesStatusBarModel.addSeries(refused);

		casesStatusBarModel.setTitle("Cases Status");
		casesStatusBarModel.setLegendPosition("ne");

		Axis xAxis = casesStatusBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Number of cases");
		xAxis.setMin(0);
		// xAxis.setMax(200);

		Axis yAxis = casesStatusBarModel.getAxis(AxisType.Y);
		// yAxis.setLabel("Gender");
	}



	private void createPieModel1() {
		pieModel1 = new PieChartModel();

		pieModel1.set("Brand 1", 540);
		pieModel1.set("Brand 2", 325);
		pieModel1.set("Brand 3", 702);
		pieModel1.set("Brand 4", 421);

		pieModel1.setTitle("Simple Pie");
		pieModel1.setLegendPosition("w");
		pieModel1.setShowDataLabels(true);
	}



	public ControllerList getControllerList() {
		return controllerList;
	}



	public void setControllerList(ControllerList controllerList) {
		this.controllerList = controllerList;
	}

}
