/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.avisos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import jpa.Aviso;
import static jpa.Aviso.Estado.SIN_ATENDER;
import sii.ejb.BaseDeDatosLocal;

/**
 *
 * @author ALE
 */

@Named(value = "listaDeAvisosSinAsignar")
@RequestScoped
public class ListaDeAvisosSinAsignar {
    @EJB
    BaseDeDatosLocal bdl;
    
    public List<Aviso> getAvisosSinAsignar() {
        List<Aviso> avisos;
        List<Aviso> avisosSinAsignar;
        avisosSinAsignar = new ArrayList<>();
        
        avisos = bdl.getAvisos();
        
        for (Aviso aviso : avisos) {
            if (aviso.getEstado().equals(SIN_ATENDER)) {
                avisosSinAsignar.add(aviso);
            }
        }
        return avisosSinAsignar;
    }
}
