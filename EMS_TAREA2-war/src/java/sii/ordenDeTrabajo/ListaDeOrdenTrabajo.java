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
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Brigada;
import jpa.OrdenTrabajo;
import sii.avisos.ListaDeAvisos;
import sii.ejb.BaseDeDatosLocal;

/**
 * Esta clase contendrá todos los avisos de la base de datos
 */
@Named(value = "listaDeOrdenTrabajo")
@SessionScoped
public class ListaDeOrdenTrabajo implements Serializable {

    private List<OrdenTrabajo> datos;
    @EJB
    private BaseDeDatosLocal bdl;

    @Inject
    ListaDeAvisos la;

    public ListaDeOrdenTrabajo() {

        datos = new ArrayList<>();
    }

    public List<OrdenTrabajo> getDatosBD() {
        return bdl.getOrdenesTrabajo();
    }
    
    public List<OrdenTrabajo> getDatos() {
        List<OrdenTrabajo> ordenes = bdl.getOrdenesTrabajo();
        List<Aviso> avisos = la.getDatos();
        datos = new ArrayList<>();
        for (Aviso a : avisos) {
            for (OrdenTrabajo ot : ordenes) {
                if (ot.getAviso().getId_aviso().equals(a.getId_aviso())) {
                    datos.add(ot);
                }
            }
        }

        return datos;
    }

    public List<OrdenTrabajo> obtenerOTsVinculadas(Aviso a) {
        List<OrdenTrabajo> datosAvisos = new ArrayList<>();
        for (OrdenTrabajo ot : getDatos()) {
            if (ot.getAviso().getId_aviso() == a.getId_aviso()) {
                datosAvisos.add(ot);
            }
        }
        return datosAvisos;
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
