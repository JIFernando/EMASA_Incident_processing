/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.avisos;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Aviso.Estado;
import jpa.Aviso.Prioridad;

/**
 *
 * @author JenniferAdmin
 */
@Named("nuevoAviso")
@RequestScoped
public class NuevoAviso {

    private Estado estado;
    private Prioridad prioridad;

    @Inject
    ListaDeAvisos lda;
    private Aviso aviso;

    public NuevoAviso() {
        aviso = new Aviso();
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public String guardarAviso() {
        aviso.setPrioridad(prioridad);
        aviso.setEstado(estado);
        lda.addDatos(aviso);

        return "grid_avisos.xhtml";
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public ListaDeAvisos getLda() {
        return lda;
    }

    public void setLda(ListaDeAvisos lda) {
        this.lda = lda;
    }

}
