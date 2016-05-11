/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.avisos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Aviso.Estado;
import jpa.Aviso.Prioridad;
import jpa.Supervisor;

/**
 *
 * @author JenniferAdmin
 */
@Named(value = "listaAvisos")
@SessionScoped
public class ListaAvisos implements Serializable {

    private Prioridad prioridad_seleccionada;
    private Estado estado_seleccionado;
    private String id_prioridad_seleccionada;
    private String id_estado_seleccionado;
    List<Aviso> datos;
    Aviso aviso = new Aviso();

    Supervisor supervisor = new Supervisor();

    public ListaAvisos() {

        datos = new ArrayList<>();

        Aviso a1 = new Aviso();
        a1.setId_aviso(12);
        a1.setFecha_creacion(new Date(116, 9, 1));
        a1.setInic_Averia(new Date(116, 9, 1));
        a1.setFin_averia(new Date(116, 9, 1));
        a1.setFecha_asig(new Date(116, 9, 1));
        a1.setUbicacion("Ciudad Jardín");
        a1.setCoordenada("0.3,34.3");
        a1.setObservaciones("observaciones");
        a1.setPrioridad(Aviso.Prioridad.URGENTE);
        a1.setEstado(Aviso.Estado.SIN_ATENDER);
        Aviso a2 = new Aviso();
        a2.setId_aviso(13);
        a2.setFecha_creacion(new Date(116, 3, 12));
        a2.setInic_Averia(new Date(116, 9, 1));
        a2.setFin_averia(new Date(116, 9, 1));
        a2.setFecha_asig(new Date(116, 9, 1));
        a2.setUbicacion("El Palo");
        a2.setCoordenada("0.3,34.3");
        a2.setObservaciones("observaciones");
        a2.setPrioridad(Aviso.Prioridad.PLANIFICADO);
        a2.setEstado(Aviso.Estado.EN_PROCESO);
        Aviso a3 = new Aviso();
        a3.setId_aviso(14);
        a3.setFecha_creacion(new Date(116, 0, 14));
        a3.setInic_Averia(new Date(116, 9, 1));
        a3.setFin_averia(new Date(116, 9, 1));
        a3.setFecha_asig(new Date(116, 9, 1));
        a3.setUbicacion("Centro");
        a3.setCoordenada("0.3,34.3");
        a3.setObservaciones("observaciones");
        a3.setPrioridad(Aviso.Prioridad.URGENTE);
        a3.setEstado(Aviso.Estado.EN_PROCESO);
        datos.add(a1);
        datos.add(a2);
        datos.add(a3);
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

    public void setEstado_selecionado(String id) {
        switch (id) {
            case "1":
                estado_seleccionado = Estado.SIN_ATENDER;
                break;
            case "2":
                estado_seleccionado = Estado.EN_PROCESO;
                break;
            case "3":
                estado_seleccionado = Estado.CERRADO;
                break;
            default:
                estado_seleccionado = Estado.TODOS;
                break;
        }
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

    public List<Aviso> getListaAvisos() {

        return datos;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public String crearAviso(int id, Date fechaInicio, Date fechaFinal, String ubicacion, String coordenadas, String observaciones, Aviso.Prioridad prioridad, Aviso.Estado estado) {
        Date fecha_creacion = new Date();

        Aviso a = new Aviso();
        a.setId_aviso(id);
        a.setFecha_creacion(fecha_creacion);
        a.setInic_Averia(fechaInicio);
        a.setFin_averia(fechaFinal);
        a.setUbicacion(ubicacion);
        a.setCoordenada(coordenadas);
        a.setObservaciones(observaciones);
        a.setPrioridad(prioridad);
        a.setEstado(estado);
        a.setSupervisor(supervisor);

        datos.add(a);

        return "grid_avisos?faces-redirect=true";
    }

}
