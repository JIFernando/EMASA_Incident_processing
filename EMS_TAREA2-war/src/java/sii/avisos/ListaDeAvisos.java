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
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Diagnostico;
import jpa.Empleado;
import jpa.Supervisor;
import sii.ejb.BaseDeDatosLocal;

/**
 * Esta clase contendrá todos los avisos de la base de datos
 */
@Named(value = "listaDeAvisos")
@SessionScoped
public class ListaDeAvisos implements Serializable {

    List<Aviso> datos;

    @EJB
    BaseDeDatosLocal bdl;

    public ListaDeAvisos() {
    }

    public List<Aviso> getDatos() {
        datos = bdl.getAvisos();
        return datos;
    }
//    public List<Aviso> getAvisosVinculados(Aviso avs) {
//        //List<Aviso> avisos = bdl.getAvisos();
//        return avs.getAvisoEnlazado();
//    }

    public void setDatos(List<Aviso> datos) {
        this.datos = datos;
    }

    public void addDatos(Aviso a) {
        this.datos.add(a);
    }

    public String crearAvisoVinculado(int id, Date fechaInicio, Date fechaFinal, String ubicacion, String coordenadas, String observaciones, Aviso.Prioridad prioridad, Aviso.Estado estado, Aviso vin) {
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

        Supervisor sup = bdl.obtenerSupervisor(1);
        a.setSupervisor(sup);
        if (vin.getAvisoEnlazado() == null) {
            List<Aviso> avisosVincu2 = new ArrayList<>();
            avisosVincu2.add(a);
            vin.setAvisoEnlazado(avisosVincu2);
        } else {
            List<Aviso> avi = vin.getAvisoEnlazado();
            avi.add(a);
            vin.setAvisoEnlazado(avi);
        }

        List<Aviso> avisosVincu = new ArrayList<>();
        avisosVincu.add(vin);
        a.setAvisoEnlazado(avisosVincu);

        // a.setSupervisor(null);
        bdl.insertarAviso(a);
        bdl.modificarAviso(vin);
        //datos.add(a);

        return "grid_avisos.xhtml";
    }
    
    public List<Diagnostico> getDiagnosticos(){
        return bdl.getDiagnosticos();
    }
}
