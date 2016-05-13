package sii.avisos;

import static java.awt.Color.white;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
 
 
@ManagedBean
public class ChartView implements Serializable {
 
    private BarChartModel barModel;
    private PieChartModel pieModel1;
 
    @PostConstruct
    public void init() {
        createBarModels();
        createPieModels();
    }
 
    public BarChartModel getBarModel() {
        return barModel;
    }
     
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
 
    private void createBarModels() {
        createBarModel();
    }
     
    private void createBarModel() {
        barModel = initBarModel();
         
        barModel.setTitle("");
        barModel.setLegendPosition("ne");
         
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Trimestres ");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Avisos ");
        yAxis.setMin(0 );
        yAxis.setMax(150 );
        
    }
     
    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        
        ChartSeries boys = new ChartSeries();
        boys.setLabel("Actual");
        boys.set("1º ", 80);
        boys.set("2º ", 60);
        boys.set("3º ", 120);
        boys.set("4º ", 90);
        //boys.set("2015", 100);
 
        ChartSeries girls = new ChartSeries();
        girls.setLabel("Anterior");
        girls.set("1º ", 52);
        girls.set("2º ", 60);
        girls.set("3º ", 110);
        girls.set("4º ", 135);
        //girls.set("2008", 120);
 
        model.addSeries(boys);
        model.addSeries(girls);
         
        return model;
    }
 
    private void createPieModels() {
        createPieModel1();
    }
     
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("2016", 320);
        pieModel1.set("2015", 425);
        pieModel1.set("2014", 702);
        pieModel1.set("2013", 521);
        pieModel1.setTitle("");
        pieModel1.setLegendPosition("w");
    }
 
    /*public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento seleccionado",
                        "Elemento: " + event.getItemIndex() + "" + event.getSeriesIndex());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    */
}