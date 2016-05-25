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

    // Devuelve una lista con todos los avisos creados
    public List<Aviso> getAvisos();

    // Inserta un aviso en la base de datos
    public void insertarAviso(Aviso aviso);

    // Modifica un aviso que ya existe en la base de datos
    public void modificarAviso(Aviso aviso);

    // Elimina un aviso de la base de datos
    public void eliminarAviso(Aviso aviso);

    public List<OrdenTrabajo> getOrdenesTrabajo();

    public void insertarOT(OrdenTrabajo a);

    public void modificarOT(OrdenTrabajo a);

    public OrdenTrabajo mostrarOT(OrdenTrabajo ot);

    //private void compruebaOT(OrdenTrabajo ot);
    public void borrarOT(OrdenTrabajo ot);

    public Brigada obtenerBrigada(Integer id);
    
    public Supervisor obtenerSupervisor(Integer id);
    
    public Empleado obtenerEmpleado(Integer id);
    
    public Ciudadano obtenerCiudadano(Integer id);
    
    public List<Supervisor> getSupervisores();

    public List<Brigada> getBrigadas();

    public List<Operario> getOperarios();

    public List<Empleado> getEmpleados();
    
    public List<Ciudadano> getCiudadanos();
    
    public void cerrarAviso(Integer id_aviso);
}
