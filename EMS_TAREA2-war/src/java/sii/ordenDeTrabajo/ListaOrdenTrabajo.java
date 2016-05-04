/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ordenDeTrabajo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import jpa.Aviso;
import jpa.OrdenTrabajo.Estado;
import jpa.OrdenTrabajo.Prioridad;
import jpa.Brigada;
import jpa.OrdenTrabajo;

/**
 *
 * @author Tigre
 */

@Named(value = "listaOT")
@SessionScoped
public class ListaOrdenTrabajo implements Serializable {

    private Prioridad prioridad_seleccionada;
    private Estado estado_seleccionado;
    private String taller_seleccionado;
    private String id_prioridad_seleccionada;
    private String id_estado_seleccionado;
    private String id_taller_seleccionado;

    //
    private List<OrdenTrabajo> datos;

    private Integer id_OT;
    private Integer trabajo;

    private String motivo;
    private String ubicacion;
    private Date fecha_creac, fecha_progr;
    private Estado estado;
    private String estado_id;

    private String taller;
    private Prioridad prioridad;
    private String prioridad_id;

    private String observaciones;
    private String calle;
    private String localidad;
    private Integer cp;
    private String ut;
    private OrdenTrabajo ordenMostrada;

    private Integer pto_trabajo;
    private Aviso aviso = null;
    private Brigada brigada_ot;

    //@Inject
    //MostrarAviso ma;
    //////////////////////////////////////////////////////////////////////////////////////// Esto es lo nuevo para poder modificar y borrar 
    public String borrarOT(OrdenTrabajo o) {
        boolean encontrado = false;
        for (OrdenTrabajo a : datos) {
            if (a.getId_OT().equals(o.getId_OT())) {
                datos.remove(o);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            return "error.xhtml";
        }
        return "OTborrada.xhtml";
    }

    // Se le llama desde un aviso pasandole este 
    /*
    public String avisoLink(Aviso a){
        aviso = a;
        return "NuevaOrdenTrabajo.xhtml";
    }
     */
    public String OrdenModicar(OrdenTrabajo o) {
        ordenMostrada = o;
        return "modificarOT.xhtml";
    }

    public String modificarOT() {
        int pos = 0;
        for (OrdenTrabajo otra : datos) {
            if (otra.getId_OT().equals(ordenMostrada.getId_OT())) {
                break;
            }
            pos++;
        }
        if (pos >= datos.size()) {
            return "error.xhtml";
        }
        if (!motivo.equals("")) {
            datos.get(pos).setMotivo(motivo);
        }
        Date date = new Date();
        datos.get(pos).setFecha_creac(date);
        if (fecha_progr != null) {
            datos.get(pos).setFecha_progr(fecha_progr);
        }
        if (!taller.equals("")) {
            datos.get(pos).setTaller(taller);
        }
        if (pto_trabajo != null) {
            datos.get(pos).setPto_trabajo(pto_trabajo);
        }
        if (!observaciones.equals("")) {
            datos.get(pos).setObservaciones(observaciones);
        }
        if (!ubicacion.equals("")) {
            datos.get(pos).setUbicacion(ubicacion);
        }
        if (!estado_id.equals("")) {
            datos.get(pos).setEstado(stringEstado(estado_id));
        }
        if (!prioridad_id.equals("")) {
            datos.get(pos).setPrioridad(stringPrioridad(prioridad_id));
        }

        motivo = "";
        ubicacion = "";
        estado = null;
        taller = "";
        prioridad = null;
        this.fecha_progr = date;
        this.fecha_creac = date;
        observaciones = "";
        calle = "";
        localidad = "";
        cp = null;
        ut = "";
        pto_trabajo = null;
        fecha_creac = null;
        fecha_progr = null;

        return "OTmodificada.xhtml";
    }

    /////////////////////////////////////////////////////////////////////////////////////
    public String volverGrid() {
        Date date = new Date();
        motivo = "";
        ubicacion = "";
        estado = null;
        taller = "";
        prioridad = null;
        this.fecha_progr = date;
        this.fecha_creac = date;
        observaciones = "";
        calle = "";
        localidad = "";
        cp = null;
        ut = "";
        pto_trabajo = null;
        fecha_creac = null;
        fecha_progr = null;
        return "grid_ordenTrabajo.xhtml";
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

    public String getId_taller_seleccionado() {
        return this.id_taller_seleccionado;
    }

    public void setId_taller_seleccionado(String ids) {
        this.id_taller_seleccionado = ids;
    }

    public String setOrdenMostrada2(OrdenTrabajo ordenMostrada) {
        this.ordenMostrada = ordenMostrada;
        return "ordentrabajo.xhtml";
    }

    public void setOrdenMostrada(OrdenTrabajo ordenMostrada) {
        this.ordenMostrada = ordenMostrada;
    }

    public OrdenTrabajo getOrdenMostrada() {
        return ordenMostrada;
    }

    public List<OrdenTrabajo> getDatos() {
        return datos;
    }

    public void setDatos(List<OrdenTrabajo> datos) {
        this.datos = datos;
    }

    public ListaOrdenTrabajo() {
        datos = new ArrayList<>();
        OrdenTrabajo ot = new OrdenTrabajo();
        ot.setMotivo("ho");
        ot.setEstado(Estado.CERRADO);
        Date date = new Date();
        ot.setFecha_creac(date);
        ot.setFecha_progr(date);
        ot.setTaller("Taller2");
        ot.setPto_trabajo(12);
        ot.setObservaciones("hola");
        ot.setUbicacion("calle de la alegria");
        Random rd = new Random();
        ot.setId_OT(rd.nextInt(1993));
        Aviso av = new Aviso();
        av.setId_aviso(123);
        ot.setAviso(av);
        ot.setPrioridad(Prioridad.URGENTE);
        datos.add(ot);
        // TEMPORAL
        //aviso = ma.getAviso();
        //Integer i = new Integer(1234567);
        //aviso.setId_aviso(i);

    }

    public void setOT(OrdenTrabajo ot) {
        datos.add(ot);
    }

    public String cancelar() {
        return "grid_ordenTrabajo.xhtml";
    }

    public void setPrioridad_selecionada(String id) {

        switch (id) {
            case "1":
                prioridad_seleccionada = Prioridad.URGENTE;
                break;
            case "2":
                prioridad_seleccionada = Prioridad.PLANIFICADO;
                break;
            default:
                prioridad_seleccionada = Prioridad.TODOS;
                break;
        }

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

    public void setEstado_selecionado(String id) {
        switch (id) {
            case "1":
                estado_seleccionado = Estado.CERRADO;
                break;
            case "2":
                estado_seleccionado = Estado.EN_PROCESO;
                break;
            default:
                estado_seleccionado = Estado.TODOS;
                break;
        }
    }

    public void setTaller_selecionado(String id) {
        switch (id) {
            case "1":
                taller_seleccionado = "Taller1";
                break;
            case "2":
                taller_seleccionado = "Taller2";
                break;
            case "3":
                taller_seleccionado = "Taller3";
                break;
            default:
                taller_seleccionado = "Taller4";
                break;
        }
    }

    public String guardar() {
        OrdenTrabajo ot = new OrdenTrabajo();
        ot.setMotivo(motivo);
        Date date = new Date();
        ot.setFecha_creac(date);
        ot.setFecha_progr(fecha_progr);
        ot.setTaller(taller);
        ot.setPto_trabajo(pto_trabajo);
        ot.setObservaciones(observaciones);
        ubicacion = calle + "\n" + localidad + " " + cp.toString() + "\n" + ut;
        ot.setUbicacion(ubicacion);
        Random rd = new Random();
        ot.setId_OT(rd.nextInt(1993));
        ot.setAviso(aviso);
        ot.setEstado(stringEstado(estado_id));
        ot.setPrioridad(stringPrioridad(prioridad_id));
        datos.add(ot);

        //ordenMostrada = ot;
        motivo = "";
        ubicacion = "";
        estado = null;
        taller = "";
        prioridad = null;
        this.fecha_progr = date;
        this.fecha_creac = date;
        observaciones = "";
        calle = "";
        localidad = "";
        cp = null;
        ut = "";
        pto_trabajo = null;
        fecha_creac = null;
        fecha_progr = null;
        return "OTcreado.xhtml";
    }

    public String asignarBrigada() {
        return "index.xhtml";
    }

    public String getTaller_seleccionado() {
        return taller_seleccionado;
    }

    public Prioridad getPrioridad_seleccionada() {
        return prioridad_seleccionada;
    }

    public Estado getEstado_seleccionado() {
        return estado_seleccionado;
    }

    public String getId_prioridad_seleccionada() {
        return id_prioridad_seleccionada;
    }

    public void setId_prioridad_seleccionada(String id_prioridad_seleccionada) {
        this.id_prioridad_seleccionada = id_prioridad_seleccionada;
    }

    public String getId_estado_seleccionado() {
        return id_estado_seleccionado;
    }

    public void setId_estado_seleccionado(String id_estado_seleccionado) {
        this.id_estado_seleccionado = id_estado_seleccionado;
    }

    public List<OrdenTrabajo> getListaOT() {

        /*List<OrdenTrabajo> datos = new ArrayList<>();
        OrdenTrabajo ot = new OrdenTrabajo();
        ot.setMotivo("ho");
        ot.setEstado(Estado.CERRADO);
        Date date = new Date();
        ot.setFecha_creac(date);
        ot.setFecha_progr(date);
        ot.setTaller("Taller1");
        ot.setPto_trabajo(12);
        ot.setObservaciones("hola");
        ot.setUbicacion("calle de la alegria");
        Random rd = new Random();
        ot.setId_OT(rd.nextInt(1993));
        Aviso av = new Aviso();
        av.setId_aviso(123);
        ot.setAviso(av);
        ot.setPrioridad(Prioridad.URGENTE);
        datos.add(ot);
        
        datos.add(new OrdenTrabajo(12, "trabajo1", "", "Fuentequebrada",new Date(116, 9, 1), new Date(116, 9, 1), "","los manolos","URGENTE",  "0.3,34.3",  1));
        datos.add(new OrdenTrabajo(13, "trabajo2", "", "Fagirola",new Date(116, 3, 12), new Date(116, 9, 1), "","ferreteria manolo", "PLANIFICADO",  "0.3,34.3",  2));
        datos.add(new OrdenTrabajo(14, "trabajo3", "", "La palmilla",new Date(116, 0, 14), new Date(116, 9, 1), "","no tiene","URGENTE",  "0.3,34.3", 3));
         */
        return datos;
    }

    public Integer getId_OT() {
        return id_OT;
    }

    public void setId_OT(Integer id_OT) {
        this.id_OT = id_OT;
    }

    public Integer getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Integer trabajo) {
        this.trabajo = trabajo;
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

    public Integer getPto_trabajo() {
        return pto_trabajo;
    }

    public void setPto_trabajo(Integer pto_trabajo) {
        this.pto_trabajo = pto_trabajo;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public Brigada getBrigada_ot() {
        return brigada_ot;
    }

    public void setBrigada_ot(Brigada brigada_ot) {
        this.brigada_ot = brigada_ot;
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
}
