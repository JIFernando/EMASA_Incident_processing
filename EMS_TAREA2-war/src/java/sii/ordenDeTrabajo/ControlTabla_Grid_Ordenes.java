/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ordenDeTrabajo;

/**
 *
 * @author Tigre
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import jpa.Aviso.Estado;
import jpa.Aviso.Prioridad;
import jpa.OrdenTrabajo;


@Named(value = "controlTabla_OT")
@SessionScoped
public class ControlTabla_Grid_Ordenes implements Serializable {

    private boolean filtrado;
    private Prioridad prioridad;
    private Estado estado;
    private Date fecha_creac;
    private Date fecha_progr;
    private Integer id_OT;

    public void filtrar(String p, String e, Date d1, Date d2) {
        
        filtrado = true;
        prioridad = stringPrioridad(p);
        estado = stringEstado(e);
        if (d1 != null) {
            fecha_creac = new Date(d1.getYear(), d1.getMonth(), d1.getDate());
        } else {
            fecha_creac = null;
        }
        if (d2 != null) {
            fecha_progr = new Date(d2.getYear(), d2.getMonth(), d2.getDate());
        } else {
            fecha_progr = null;
        }
       
    }

    @Inject
    private ListaOrdenTrabajo lTO;
    
    public List<OrdenTrabajo> getListaOTFiltradas() {

        List<OrdenTrabajo> resultado = new ArrayList<>();

        for (OrdenTrabajo a : lTO.getDatos()) {
            if (cumpleFiltroPrioridad(a) && cumpleFiltroEstado(a) && cumpleFiltroFechaInicio(a) && cumpleFiltroFechaFin(a) && cumpleFiltroId(a)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    
    public ControlTabla_Grid_Ordenes() {
        filtrado = false;
    }
    public String cancelar(){
        return "ordentrabajo.xhtml";
    }
    private Prioridad stringPrioridad(String p) {
        Prioridad res;
        
        switch (p) {
            case "1":
                res = Prioridad.URGENTE;
                break;
            case "2":
                res = Prioridad.PLANIFICADO;
                break;
            default:
                res = Prioridad.TODOS;
                break;
        }
        return res;
    }

    private Estado stringEstado(String e) {
        Estado res;
        switch (e) {
            case "1":
                res = Estado.CERRADO;
                break;
            case "2":
                res = Estado.EN_PROCESO;
                break;
            case "4":
                res = Estado.SIN_ATENDER;
                break;    
            default:
                res = Estado.TODOS;
                break;
        }
        return res;
    }
    
    private Prioridad p(String p){
        Prioridad res;
        
        switch (p) {
            case "URGENTE":
                res = Prioridad.URGENTE;
                break;
            case "PLANIFICADO":
                res = Prioridad.PLANIFICADO;
                break;
            default:
                res = Prioridad.TODOS;
                break;
        }
        return res;
    }
    
    private boolean cumpleFiltroPrioridad(OrdenTrabajo a) {
        return p(a.getPrioridad().toString()).equals(prioridad) || prioridad.equals(Prioridad.TODOS);
    }
    
    private boolean cumpleFiltroEstado(OrdenTrabajo a) {
        return a.getEstado().equals(estado) || estado.equals(Estado.TODOS);
    }

    private boolean cumpleFiltroFechaInicio(OrdenTrabajo a) {
        return (fecha_creac == null) || a.getFecha_creac().after(fecha_creac) || a.getFecha_creac().equals(fecha_creac);
    }

    private boolean cumpleFiltroFechaFin(OrdenTrabajo a) {
        return (fecha_progr == null) || a.getFecha_progr().before(fecha_progr) || a.getFecha_progr().equals(fecha_progr);
    }

    private boolean cumpleFiltroId(OrdenTrabajo a) {
        return id_OT == null || a.getId_OT().equals(id_OT);
    }

    private boolean campoVacio(String p) {
        return !(p.equals("1") || p.equals("2") || p.equals("3"));
    }

    public void limpiar() {
        filtrado = false;
        prioridad = null;
        fecha_creac = null;
        fecha_progr = null;
        id_OT = null;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFecha_creac() {
        return fecha_creac;
    }

    public void setFecha_creac(Date fecha_creac) {
        this.fecha_creac = fecha_creac;
    }

    public Date getFecha_progr() {
        return fecha_progr;
    }

    public void setFecha_progr(Date fecha_progr) {
        this.fecha_progr = fecha_progr;
    }

    public Integer getId_OT() {
        return id_OT;
    }

    public void setId_OT(Integer id_OT) {
        this.id_OT = id_OT;
    }

    public boolean isFiltrado() {
        return filtrado;
    }

    public void setFiltrado(boolean filtrado) {
        this.filtrado = filtrado;
    }
}

 