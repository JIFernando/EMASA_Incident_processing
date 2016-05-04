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
import java.util.Date;
import jpa.Aviso;

@Named(value = "mostrarAviso")
@SessionScoped
public class MostrarAviso implements Serializable {

    Aviso aviso;

    public MostrarAviso() {

    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public String capturarYMostrar(Aviso a) {
        this.aviso = a;
        return "verAviso?faces-redirect=true";
    }

    /*
    public String capturarYEditar(Date fechaInicio, Date fechaFinal, String ubicacion, String coordenadas, String observaciones, Aviso.Prioridad prioridad, Aviso.Estado estado) {
        aviso.setInic_Averia(fechaInicio);
        aviso.setFin_averia(fechaFinal);
        aviso.setUbicacion(ubicacion);
        aviso.setCoordenada(coordenadas);
        aviso.setObservaciones(observaciones);
        aviso.setPrioridad(prioridad);
        aviso.setEstado(estado);

        return "editarAviso?faces-redirect=true";
    }
     */
    public String capturarYEditar() {
        return "editarAviso?faces-redirect=true";
    }

}
