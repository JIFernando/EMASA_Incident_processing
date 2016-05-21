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
import javax.ejb.EJB;
import jpa.OrdenTrabajo;
import sii.ejb.BaseDeDatosLocal;

@Named(value = "mostrarOrdenTrabajo")
@SessionScoped
public class MostrarOrdenTrabajo implements Serializable {

    @EJB
    BaseDeDatosLocal bdl;
    
    OrdenTrabajo ordenTrabajo;

    public OrdenTrabajo getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(OrdenTrabajo ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public String capturarYMostrarOrdenTrabajo(OrdenTrabajo ot) {
        this.ordenTrabajo = ot;
        bdl.mostrarOT(ordenTrabajo);
        return "ver_ordenTrabajo.xhtml";
    }

    public String eliminarOT(OrdenTrabajo ot){
        this.ordenTrabajo = ot;
        bdl.borrarOT(ordenTrabajo);
        return "OTborrada.xhtml";
    }
    
    public String capturarYEditar() {
        
        bdl.modificarOT(ordenTrabajo);
        
        //return "modificar_ordenTrabajo?faces-redirect=true";
        return "OTmodificada.xhtml";
    }
    
    public String capturarYEditar(OrdenTrabajo ot) {
        this.ordenTrabajo = ot;
        //bdl.modificarOT(ordenTrabajo);
        //return "modificar_ordenTrabajo.xhtml";
        return "modificar_ordenTrabajo.xhtml";
    }

}
