/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.brigadas;

/**
 *
 * @author JenniferAdmin
 */
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Inject;
import jpa.Aviso;
import jpa.Brigada;
import sii.ejb.BaseDeDatosLocal;

@Named(value = "controlFiltrosGridBrigadas")
@SessionScoped
public class ControlFiltrosGridBrigadas implements Serializable {

    private Integer id_brigada;
    private String contrata;

    @Inject
    ListaDeBrigadas lb;

    public ControlFiltrosGridBrigadas() {
        contrata = null;
        id_brigada = null;
    }

    public List<Brigada> getListaBrigadasFiltrados() {
        List<Brigada> datos = lb.getDatos();
        List<Brigada> resultado = new ArrayList<>();

        for (Brigada b : datos) {
            if (cumpleFiltroIdBrigada(b) && cumpleFiltroContrata(b)) {               
                resultado.add(b);               
            }
        }        
        return resultado;
    }

    public void resetear() {
        contrata = null;
        id_brigada = null;
    }
    
    public void buscar(){
        
    }

    private boolean cumpleFiltroIdBrigada(Brigada b) {
        return b.getId_brigada().equals(id_brigada) || id_brigada == null ;
    }

    private boolean cumpleFiltroContrata(Brigada b) {
        return b.getNombreContrata().equalsIgnoreCase(contrata) || contrata == null || contrata.equals("");
    }

    public Integer getId_brigada() {
        return id_brigada;
    }

    public void setId_brigada(Integer id_brigada) {
        this.id_brigada = id_brigada;
        System.out.print("Brigada");
    }

    public String getContrata() {
        return contrata;
    }

    public void setContrata(String contrata) {
        this.contrata = contrata;
    }

    public ListaDeBrigadas getLb() {
        return lb;
    }

    public void setLb(ListaDeBrigadas lb) {
        this.lb = lb;
    }
    
    /*
    @EJB
    BaseDeDatosLocal bdl;
    
    
    public int getNumAvisos () {
        List<Aviso> avisos = bdl.getAvisos();
        List<Aviso> avisosBrigada;
        avisosBrigada = new ArrayList<>();
        
        for (Aviso aviso : avisos) {
            if (id_brigada.equals(aviso.getBrigada().getId_brigada())) {
                avisosBrigada.add(aviso);
            }
        }
        //return avisosBrigada.size();
        return avisos.size();
    }*/

}
