package sii.avisos;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import jpa.Aviso;
import jpa.Supervisor;
import sii.ejb.BaseDeDatosLocal;

@Named(value = "mostrarAviso")
@SessionScoped
public class MostrarAviso implements Serializable {

    @EJB
    BaseDeDatosLocal bdl;
    
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

    public String editarAviso() {
        bdl.modificarAviso(aviso);
        
        return "grid_avisos.xhtml";
    }
    
    public String eliminarAviso() {
        bdl.eliminarAviso(aviso);
        
        return "grid_avisos.xhtml";
    }
}
