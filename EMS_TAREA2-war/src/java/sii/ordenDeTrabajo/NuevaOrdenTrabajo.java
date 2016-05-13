/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ordenDeTrabajo;

import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Aviso;
import jpa.OrdenTrabajo.Estado;
import jpa.OrdenTrabajo.Prioridad;
import jpa.OrdenTrabajo;

/**
 *
 * @author JenniferAdmin
 */
@Named("nuevaOrdenTrabajo")
@RequestScoped
public class NuevaOrdenTrabajo {

    @Inject
    ListaDeOrdenTrabajo lot;
    private OrdenTrabajo ot;
    
    public NuevaOrdenTrabajo() {
        ot = new OrdenTrabajo();
    }

    private List<OrdenTrabajo> datos;

    private String motivo;
    private String ubicacion;
    private Date fecha_progr;
    private Estado estado;
    private String taller;
    private Prioridad prioridad;

    private String observaciones;
    private String calle;
    private String localidad;
    private Integer cp;
    private String ut;
    private Integer id_brigada;

    private Integer pto_trabajo;

    public String guardarAviso() {
        ot.setPrioridad(prioridad);
        ot.setEstado(estado);
        ot.setAviso(new Aviso());
        ot.setMotivo(motivo);
        ot.setUbicacion(ubicacion);
        ot.setFecha_progr(fecha_progr);
        ot.setTaller(taller);
        ot.setObservaciones(observaciones);
        ot.setUbicacion(calle+" "+ localidad +" " + cp + " " + ut);
        ot.setPto_trabajo(pto_trabajo);
        lot.addDatos(ot);

        return "grid_ordenTrabajo.xhtml";
    }

    public OrdenTrabajo getOt() {
        return ot;
    }

    public void setOt(OrdenTrabajo ot) {
        this.ot = ot;
    }

    public ListaDeOrdenTrabajo getLot() {
        return lot;
    }

    public void setLot(ListaDeOrdenTrabajo lot) {
        this.lot = lot;
    }

    public List<OrdenTrabajo> getDatos() {
        return datos;
    }

    public void setDatos(List<OrdenTrabajo> datos) {
        this.datos = datos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha_progr() {
        return fecha_progr;
    }

    public void setFecha_progr(Date fecha_progr) {
        this.fecha_progr = fecha_progr;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getUt() {
        return ut;
    }

    public void setUt(String ut) {
        this.ut = ut;
    }

    public Integer getPto_trabajo() {
        return pto_trabajo;
    }

    public void setPto_trabajo(Integer pto_trabajo) {
        this.pto_trabajo = pto_trabajo;
    }

    public Integer getId_brigada() {
        return id_brigada;
    }

    public void setId_brigada(Integer id_brigada) {
        this.id_brigada = id_brigada;
    }
    
    
}
