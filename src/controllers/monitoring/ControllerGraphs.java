package controllers.monitoring;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
@ViewScoped
public class ControllerGraphs {

	private BarChartModel barModel;
	private HorizontalBarChartModel horizontalBarModel;
	private PieChartModel pieModel1;



	@PostConstruct
	public void init() {
		createBarModels();
	}



	public BarChartModel getBarModel() {
		return barModel;
	}



	public HorizontalBarChartModel getHorizontalBarModel() {
		return horizontalBarModel;
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
		horizontalBarModel = new HorizontalBarChartModel();

		ChartSeries boys = new ChartSeries();
		boys.setLabel("Boys");
		boys.set("2004", 50);
		boys.set("2005", 96);
		boys.set("2006", 44);
		boys.set("2007", 55);
		boys.set("2008", 25);

		ChartSeries girls = new ChartSeries();
		girls.setLabel("Girls");
		girls.set("2004", 52);
		girls.set("2005", 60);
		girls.set("2006", 82);
		girls.set("2007", 35);
		girls.set("2008", 120);

		horizontalBarModel.addSeries(boys);
		horizontalBarModel.addSeries(girls);

		horizontalBarModel.setTitle("Horizontal and Stacked");
		horizontalBarModel.setLegendPosition("e");
		horizontalBarModel.setStacked(true);

		Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
		xAxis.setLabel("Births");
		xAxis.setMin(0);
		xAxis.setMax(200);

		Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
		yAxis.setLabel("Gender");
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
	
}
