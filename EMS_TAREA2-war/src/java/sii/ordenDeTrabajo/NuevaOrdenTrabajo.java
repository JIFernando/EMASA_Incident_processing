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
import jpa.Brigada;
import jpa.OrdenTrabajo.Estado;
import jpa.OrdenTrabajo.Prioridad;
import jpa.OrdenTrabajo;
import sii.avisos.MostrarAviso;

/**
 *
 * @author JenniferAdmin
 */
@Named("nuevaOrdenTrabajo")
@RequestScoped
public class NuevaOrdenTrabajo {

    @Inject
    ListaDeOrdenTrabajo lot;
    @Inject
    MostrarAviso ma;
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
    private String estado_id;
    private String prioridad_id;

    private String observaciones;
    private String calle;
    private String localidad;
    private Integer cp;
    private String ut;
    private Integer id_brigada;

    private Integer pto_trabajo;

    public String guardarOT() {
//        OrdenTrabajo not = new OrdenTrabajo();
//        not.setPrioridad(prioridad);
//        not.setEstado(estado);
//        //mostrarAviso.aviso.id_aviso
//        not.setAviso(ma.getAviso());
//        not.setMotivo(motivo);
//        not.setUbicacion(ubicacion);
//        not.setFecha_progr(fecha_progr);
//        not.setTaller(taller);
//        not.setObservaciones(observaciones);
//        not.setUbicacion(calle+" "+ localidad +" " + cp + " " + ut);
//        not.setPto_trabajo(pto_trabajo);
        if (id_brigada != null) {
            Brigada b = this.lot.getBrigada(id_brigada);
            if (b != null) {
                ot.setBrigada_ot(b);
            } else {
                return "errorBrigadaNoEncontrada.xhtml";
            }
        }
        ot.setAviso(ma.getAviso());
        Date d = new Date();
        ot.setFecha_creac(d);
//        ot.setTaller(taller);
        ubicacion = calle + " " + localidad + " " + cp + " " + ut;
        if (ubicacion != null) {
            ot.setUbicacion(ubicacion);
        }
        ot.setEstado(this.stringEstado(this.estado_id));
        ot.setPrioridad(this.stringPrioridad(this.prioridad_id));
        ot.setId_OT(tomarSiguienteId());
        lot.setOT(ot);
        ot = new OrdenTrabajo();
        return "grid_ordenTrabajo.xhtml";
    }

    public Integer tomarMaximoId() {
        List<OrdenTrabajo> ots = lot.datos;
        System.out.println("Ordenes: " + ots);
        if (ots.isEmpty()) {
            return 0;
        } else {
            int maximo = Integer.MIN_VALUE;
            for (OrdenTrabajo orden : ots) {
                if (maximo < orden.getId_OT()) {
                    maximo = orden.getId_OT();
                }
            }
            return maximo;
        }
    }

    public Integer tomarSiguienteId() {
        return tomarMaximoId() + 1;
    }

    public <T> T nvl(T arg0, T arg1) {
        return (arg0 == null) ? arg1 : arg0;
    }

    private Estado stringEstado(String e) {
        Estado res;
        switch (e) {
            case "CERRADO":
                res = Estado.CERRADO;
                break;
            case "EN_PROCESO":
                res = Estado.EN_PROCESO;
                break;
            default:
                res = Estado.SIN_ATENDER;
                break;
        }
        return res;
    }

    private Prioridad stringPrioridad(String p) {
        Prioridad res;

        switch (p) {
            case "URGENTE":
                res = Prioridad.URGENTE;
                break;
            default:
                res = Prioridad.PLANIFICADO;
                break;

        }
        return res;
    }

    public MostrarAviso getMa() {
        return ma;
    }

    public void setMa(MostrarAviso ma) {
        this.ma = ma;
    }

    public String getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(String estado_id) {
        this.estado_id = estado_id;
    }

    public String getPrioridad_id() {
        return prioridad_id;
    }

    public void setPrioridad_id(String prioridad_id) {
        this.prioridad_id = prioridad_id;
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
