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

/**
 * Esta clase contendrá todos los avisos de la base de datos
 */
@Named(value = "listaDeAvisos")
@SessionScoped
public class ListaDeAvisos implements Serializable {

    List<Aviso> datos;

    public ListaDeAvisos() {

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

    public List<Aviso> getDatos() {
        return datos;
    }

    public void setDatos(List<Aviso> datos) {
        this.datos = datos;
    }
    
    public void addDatos(Aviso a){
        this.datos.add(a);
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
        a.setSupervisor(null);

        datos.add(a);

        return "grid_avisos.xhtml";
    }
}