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

    public String capturarYEditar() {
        return "editarAviso?faces-redirect=true";
    }

}
