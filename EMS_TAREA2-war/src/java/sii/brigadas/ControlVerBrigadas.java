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
import jpa.Brigada;


@Named(value = "controlVerBrigadas")
@SessionScoped
public class ControlVerBrigadas implements Serializable {

    private boolean filtrado;
    private Integer id;
    private String contrata;

    public String getContrata() {
        return contrata;
    }

    public void setContrata(String contrata) {
        this.contrata = contrata;
    }

    
    public String filtrar() {
        filtrado = true;
        
        return "grid_ver_brigadas.xhtml";
    }

    public List<Brigada> getListaBrigadasFiltradas() {
        
        List<Brigada> brigadas = new ArrayList<>();
        List<String> os1 = new ArrayList<>();
        os1.add("Ned Stark");
        os1.add("Walter Frey");
        
        Brigada b1 = new Brigada (1, "Contratas Málaga S.L.", "Tyrion Lannister", os1);
        Brigada b2 = new Brigada (2, "Contratas Málaga S.L.", "Jaime Lannister", null);
        Brigada b3 = new Brigada (3, "Emasa", "Cersei Lannister", null);
        
        brigadas.add(b1);
        brigadas.add(b2);
        brigadas.add(b3);
        
        List<Brigada> resultado = new ArrayList<>();
                
        
        for (Brigada b : brigadas) {
            if (cumpleFiltroId(b)) {
                if ((cumpleFiltroContrata(b)) && (id == null)) resultado.add(b);
                else if ((id != null) && ((cumpleFiltroContrata(b) || (contrata.equals(""))))) resultado.add(b);
                else if ((id == null) && (contrata.equals(""))) resultado.add(b);
            }
            
        }
        
        return resultado;
    }

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlVerBrigadas() {
        filtrado = false;
    }
    
    private boolean cumpleFiltroId(Brigada b) {
        return id == null || b.getId().equals(id);
    }
    
    private boolean cumpleFiltroContrata(Brigada b) {
        return contrata == null || b.getContrata().equalsIgnoreCase(contrata);
    }

    public void limpiar() {
        filtrado = false;
        id = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isFiltrado() {
        return filtrado;
    }

    public void setFiltrado(boolean filtrado) {
        this.filtrado = filtrado;
    }
}
