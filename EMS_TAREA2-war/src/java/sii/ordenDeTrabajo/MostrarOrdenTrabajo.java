/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ordenDeTrabajo;

/**
 *
 * @author JenniferAdmin
 */
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import jpa.OrdenTrabajo;

@Named(value = "mostrarOrdenTrabajo")
@SessionScoped
public class MostrarOrdenTrabajo implements Serializable {

    OrdenTrabajo ordenTrabajo;

    public MostrarOrdenTrabajo() {

    }

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public String capturarYMostrarOrdenTrabajo(OrdenTrabajo ot) {
        this.ordenTrabajo = ot;
        return "ver_ordenTrabajo.xhtml";
    }

    public String capturarYEditar(OrdenTrabajo ot) {
        this.ordenTrabajo = ot;
        return "modificar_ordenTrabajo?faces-redirect=true";
    }

}
