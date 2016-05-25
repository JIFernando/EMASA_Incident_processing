package sii.avisos;

import static java.awt.Color.white;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import jpa.*;
import jpa.Aviso.Estado;
import jpa.Aviso.Prioridad;
import org.primefaces.event.ItemSelectEvent;
 
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.PieChartModel;
import sii.ejb.*;
 
 
@ManagedBean
public class ChartView implements Serializable {
 
    private BarChartModel barModel;
    private PieChartModel pieModel1;
 
    @PostConstruct
    public void init() {
        createBarModels();
        createPieModels();
    }
    @EJB
    BaseDeDatosLocal bdl;
 
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
        xAxis.setLabel("Fecha");
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Cantidad");
        yAxis.setMin((int) 0);
        yAxis.setMax((int) 20);
        
    }

    private BarChartModel initBarModel() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        Date d =  new Date(); 

        Calendar c = Calendar.getInstance(); 
        c.setTime(d);
        c.add(Calendar.DATE, -1);
        Date d2 = c.getTime();
        c.add(Calendar.DATE, -1);
        Date d3 = c.getTime();
        
        
        
        BarChartModel model = new BarChartModel();
        
        ChartSeries urg = new ChartSeries();
        urg.setLabel("Urgente");
        

	String date = sdf.format(d); 
        String date2 = sdf.format(d2); 
	String date3 = sdf.format(d3); 

        urg.set(date3,(int)  bdl.avisosPrioridad(Prioridad.URGENTE, d3));
        urg.set(date2,(int)  bdl.avisosPrioridad(Prioridad.URGENTE, d2));
        urg.set(date,(int)   bdl.avisosPrioridad(Prioridad.URGENTE, d));
        
        
        
        ChartSeries plani = new ChartSeries();
        plani.setLabel("Planificado");

        plani.set(date3,(int)  bdl.avisosPrioridad(Prioridad.PLANIFICADO, d3));
        plani.set(date2,(int)  bdl.avisosPrioridad(Prioridad.PLANIFICADO, d2));
        plani.set(date,(int)   bdl.avisosPrioridad(Prioridad.PLANIFICADO, d));


        ChartSeries briDisp = new ChartSeries();
        /*briDisp.setLabel("Brigadas Disponibles");
        int da = bdl.getAvisosConBrigradas(d3);
        int da2 =bdl.getAvisosConBrigradas(d2);
        int da3 =bdl.getAvisosConBrigradas(d);
        
        briDisp.set(date3,(int)  da);
        briDisp.set(date2,(int)  da2);
        briDisp.set(date,(int)  da3);

        
        briDisp.set(date,1);*/
        model.addSeries(urg);
        model.addSeries(plani);
        //model.addSeries(briDisp);

        return model;
    }
 
    private void createPieModels() {
        createPieModel1();
    }
     
    
    
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
         
        pieModel1.set("SIN ATENDER", avisosEstado(Estado.SIN_ATENDER).size());
        pieModel1.set("EN PROCESO", avisosEstado(Estado.EN_PROCESO).size());

        pieModel1.setTitle("Estado De Avisos");
        pieModel1.setLegendPosition("w");
    }
    
    private List<Aviso> avisosEstado(Estado estado) {
        List<Aviso> la= bdl.getAvisos();
        List<Aviso> aux = new ArrayList<>(); 
        for(Aviso a : la){
            if(a.getEstado().equals(estado)){
                aux.add(a);
            }
        }        
        return aux;
    }

    /*public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Elemento seleccionado",
                        "Elemento: " + event.getItemIndex() + "" + event.getSeriesIndex());
         
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    */
}