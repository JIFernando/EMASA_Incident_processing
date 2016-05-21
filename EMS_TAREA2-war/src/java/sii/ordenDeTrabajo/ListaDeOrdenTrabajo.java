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
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Brigada;
import jpa.OrdenTrabajo;
import sii.ejb.BaseDeDatosLocal;

/**
 * Esta clase contendrá todos los avisos de la base de datos
 */
@Named(value = "listaDeOrdenTrabajo")
@SessionScoped
public class ListaDeOrdenTrabajo implements Serializable {

    List<OrdenTrabajo> datos;
    @EJB
    BaseDeDatosLocal bdl;
    public ListaDeOrdenTrabajo() {

        datos = new ArrayList<>();

        /*OrdenTrabajo ot = new OrdenTrabajo();
        ot.setMotivo("Motivo1");
        ot.setEstado(OrdenTrabajo.Estado.CERRADO);
        ot.setFecha_creac(new Date(116, 3, 12));
        ot.setFecha_progr(new Date(116, 3, 12));
        ot.setTaller("Taller2");
        ot.setPto_trabajo(12);
        ot.setObservaciones("Observaciones");
        ot.setUbicacion("Calle Alegría");
        Random rd = new Random();
        ot.setId_OT(rd.nextInt(1993));
        Aviso av = new Aviso();
        av.setId_aviso(123);
        ot.setAviso(av);
        ot.setPrioridad(OrdenTrabajo.Prioridad.URGENTE);
        datos.add(ot);*/
    }

    public List<OrdenTrabajo> getDatos() {
        datos = bdl.getOrdenesTrabajo();
        return datos;
    }

    public Brigada getBrigada(Integer id) {
        return bdl.obtenerBrigada(id);
    }
    public void setDatos(List<OrdenTrabajo> datos) {
        this.datos = datos;
    }
    public void setOT(OrdenTrabajo ots) {
        bdl.insertarOT(ots);
    }
    public void addDatos(OrdenTrabajo ot) {
        this.datos.add(ot);
    }
}
