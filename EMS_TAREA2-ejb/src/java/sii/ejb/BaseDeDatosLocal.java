/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ejb;

import java.util.List;
import javax.ejb.Local;
import sii.exception.EmasaException;
import jpa.*;

/**
 *
 * @author JenniferAdmin
 */
@Local
public interface BaseDeDatosLocal {

    public List<Aviso> getAvisos();

    public void compruebaLogin(Empleado empleado) throws EmasaException;

    public void insertarAviso(Aviso aviso);

    public void modificarAviso(Aviso aviso);

    public void eliminarAviso(Aviso aviso);

    public List<OrdenTrabajo> getOrdenesTrabajo();

    public void insertarOT(OrdenTrabajo a);

    public void modificarOT(OrdenTrabajo a);

    public OrdenTrabajo mostrarOT(OrdenTrabajo ot);

    //private void compruebaOT(OrdenTrabajo ot);
    public void borrarOT(OrdenTrabajo ot);

}
