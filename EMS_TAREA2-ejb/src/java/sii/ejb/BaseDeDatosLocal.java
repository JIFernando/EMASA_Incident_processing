/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ejb;

import java.util.List;
import javax.ejb.Local;
import jpa.*;

/**
 *
 * @author JenniferAdmin
 */
@Local
public interface BaseDeDatosLocal {
    public List<Aviso> getAvisos();
    public List<OrdenTrabajo> getOrdenesTrabajo();
    public void insertarOT(OrdenTrabajo a);
    public void modificarOT(OrdenTrabajo a);
}
