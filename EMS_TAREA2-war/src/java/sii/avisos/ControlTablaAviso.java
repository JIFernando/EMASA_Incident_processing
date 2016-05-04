/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.avisos;

/**
 *
 * @author JenniferAdmin
 */
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import jpa.Aviso;
import jpa.Aviso.Estado;
import jpa.Aviso.Prioridad;

@Named(value = "controlTabla")
@SessionScoped
public class ControlTablaAviso implements Serializable {

    private boolean filtrado;
    private Prioridad prioridad;
    private Estado estado;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Integer id_aviso;
    
    @Inject
    ListaAvisos la;

    public void filtrar(String p, String e, Date d1, Date d2) {
        filtrado = true;
        prioridad = stringPrioridad(p);
        estado = stringEstado(e);
        if (d1 != null) {
            fecha_inicio = new Date(d1.getYear(), d1.getMonth(), d1.getDate());
        } else {
            fecha_inicio = null;
        }
        if (d2 != null) {
            fecha_fin = new Date(d2.getYear(), d2.getMonth(), d2.getDate());
        } else {
            fecha_fin = null;
        }
    }

    public List<Aviso> getListaAvisosFiltrados() {
       List<Aviso> datos = la.getListaAvisos();
        List<Aviso> resultado = new ArrayList<>();

        for (Aviso a : datos) {
            if (cumpleFiltroPrioridad(a) && cumpleFiltroEstado(a) && cumpleFiltroFechaInicio(a) && cumpleFiltroFechaFin(a) && cumpleFiltroId(a)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlTablaAviso() {
        filtrado = false;
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
                res = Estado.SIN_ATENDER;
                break;
            case "2":
                res = Estado.EN_PROCESO;
                break;
            case "3":
                res = Estado.CERRADO;
                break;
            default:
                res = Estado.TODOS;
                break;
        }
        return res;
    }

    private boolean cumpleFiltroPrioridad(Aviso a) {
        return a.getPrioridad().equals(prioridad) || prioridad.equals(Prioridad.TODOS);
    }

    private boolean cumpleFiltroEstado(Aviso a) {
        return a.getEstado().equals(estado) || estado.equals(Estado.TODOS);
    }

    private boolean cumpleFiltroFechaInicio(Aviso a) {
        return (fecha_inicio == null) || a.getFecha_creacion().after(fecha_inicio) || a.getFecha_creacion().equals(fecha_inicio);
    }

    private boolean cumpleFiltroFechaFin(Aviso a) {
        return (fecha_fin == null) || a.getFecha_creacion().before(fecha_fin) || a.getFecha_creacion().equals(fecha_fin);
    }

    private boolean cumpleFiltroId(Aviso a) {
        return id_aviso == null || a.getId_aviso().equals(id_aviso);
    }

    private boolean campoVacio(String p) {
        return !(p.equals("1") || p.equals("2") || p.equals("3") || p.equals("4"));
    }

    public void limpiar() {
        filtrado = false;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getId_aviso() {
        return id_aviso;
    }

    public void setId_aviso(Integer id_aviso) {
        this.id_aviso = id_aviso;
    }

    public boolean isFiltrado() {
        return filtrado;
    }

    public void setFiltrado(boolean filtrado) {
        this.filtrado = filtrado;
    }
}
