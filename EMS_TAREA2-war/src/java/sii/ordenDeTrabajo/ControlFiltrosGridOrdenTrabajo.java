/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ordenDeTrabajo;

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
import javax.inject.Inject;
import jpa.OrdenTrabajo.Estado;
import jpa.OrdenTrabajo.Prioridad;
import jpa.OrdenTrabajo;

@Named(value = "controlFiltrosGridOrdenTrabajo")
@SessionScoped
public class ControlFiltrosGridOrdenTrabajo implements Serializable {

    private Prioridad prioridad;
    private Estado estado;
    private Date fecha_creacion;
    private Date fecha_programada;
    private Integer id_ot;

    @Inject
    ListaDeOrdenTrabajo lot;

    public ControlFiltrosGridOrdenTrabajo() {
        prioridad = Prioridad.TODOS;
        estado = Estado.TODOS;
        fecha_creacion = null;
        fecha_programada = null;
        id_ot = null;
    }

    public List<OrdenTrabajo> getListaOrdenTrabajoFiltrados() {
        List<OrdenTrabajo> datos = lot.getDatos();
        List<OrdenTrabajo> resultado = new ArrayList<>();

        for (OrdenTrabajo ot : datos) {
            if (cumpleFiltroPrioridad(ot) && cumpleFiltroEstado(ot)
                    && cumpleFiltroFechaCreacion(ot) && cumpleFiltroFechaProgramada(ot)
                    && cumpleFiltroId(ot)) {
                resultado.add(ot);
            }
        }
        return resultado;
    }

    public void resetear() {
        prioridad = Prioridad.TODOS;
        estado = Estado.TODOS;
        fecha_creacion = null;
        fecha_programada = null;
        id_ot = null;
    }

    private boolean cumpleFiltroPrioridad(OrdenTrabajo a) {
        return a.getPrioridad().equals(prioridad) || prioridad.equals(Prioridad.TODOS);
    }

    private boolean cumpleFiltroEstado(OrdenTrabajo ot) {
        return ot.getEstado().equals(estado) || estado.equals(Estado.TODOS);
    }

    private boolean cumpleFiltroFechaCreacion(OrdenTrabajo a) {
        return (fecha_creacion == null) || a.getFecha_creac().equals(fecha_creacion);
    }

    private boolean cumpleFiltroFechaProgramada(OrdenTrabajo a) {
        return (fecha_programada == null) || a.getFecha_progr().equals(fecha_programada);
    }

    private boolean cumpleFiltroId(OrdenTrabajo a) {
        return id_ot == null || a.getId_OT().equals(id_ot);
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

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_programada() {
        return fecha_programada;
    }

    public void setFecha_programada(Date fecha_programada) {
        this.fecha_programada = fecha_programada;
    }

    public Integer getId_ot() {
        return id_ot;
    }

    public void setId_ot(Integer id_ot) {
        this.id_ot = id_ot;
    }

    public ListaDeOrdenTrabajo getLot() {
        return lot;
    }

    public void setLot(ListaDeOrdenTrabajo lot) {
        this.lot = lot;
    }

}
