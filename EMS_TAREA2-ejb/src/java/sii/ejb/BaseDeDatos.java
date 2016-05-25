/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sii.exception.EmasaException;
import jpa.*;

/**
 *
 * @author JenniferAdmin
 */
@Stateless
public class BaseDeDatos implements BaseDeDatosLocal {

    @PersistenceContext(unitName = "EMS_TAREA2-ejbPU")
    private EntityManager em;

    /**
     *
     * Devuelve una lista con todos los avisos creados
     *
     * @return
     */
    @Override
    public List<Aviso> getAvisos() {
        List<Aviso> res = em.createQuery("select a from Aviso a", Aviso.class).getResultList();
        return res;
    }

    /**
     *
     * Inserta un aviso en la base de datos
     *
     * @param aviso
     */
    @Override
    public void insertarAviso(Aviso aviso) {
        // throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("NUEVO ID: " + aviso.getId_aviso());
        em.persist(aviso);
    }

    /**
     *
     * Modifica un aviso que ya existe en la base de datos
     *
     * @param aviso
     */
    @Override
    public void modificarAviso(Aviso aviso) {
        // throw new UnsupportedOperationException("Not supported yet.");
        em.merge(aviso);
    }

    /**
     *
     * Elimina un aviso de la base de datos
     *
     * @param aviso
     */
    @Override
    public void eliminarAviso(Aviso aviso) {
        // throw new UnsupportedOperationException("Not supported yet.");
        // em.remove(em.merge(aviso));
    }

    @Override
    public List<OrdenTrabajo> getOrdenesTrabajo() {
        return em.createQuery("select u from OrdenTrabajo u", OrdenTrabajo.class).getResultList();
    }

    @Override
    public void insertarOT(OrdenTrabajo a) {
        em.persist(a);
    }

    @Override
    public void modificarOT(OrdenTrabajo ot) {
        em.merge(ot);
        if (ot.getEstado().equals(OrdenTrabajo.Estado.CERRADO)) {
            cerrarAviso(ot.getAviso().getId_aviso());
        }
    }

    @Override
    public OrdenTrabajo mostrarOT(OrdenTrabajo ot) {
        //compruebaOT(ot);
        OrdenTrabajo o = em.find(OrdenTrabajo.class, ot.getId_OT());
        return o;
    }

    @Override
    public void borrarOT(OrdenTrabajo ot) {
        //compruebaOT(ot);
        em.remove(em.merge(ot));
    }

    /*@Override
    private void compruebaOT(OrdenTrabajo ot) throws otException{
        OrdenTrabajo u2 = em.find(OrdenTrabajo.class, ot);
        
        if (u2 == null) {
            throw new otException();
        }
    }*/
    @Override
    public Brigada obtenerBrigada(Integer id) {
        Brigada sup = em.find(Brigada.class, id);

        return sup;
    }

    @Override
    public Supervisor obtenerSupervisor(Integer id) {
        Supervisor sup = em.find(Supervisor.class, id);

        return sup;
    }

    @Override
    public Empleado obtenerEmpleado(Integer id) {
        Empleado emp = em.find(Empleado.class, id);

        return emp;
    }

    @Override
    public Ciudadano obtenerCiudadano(Integer id) {
        Ciudadano ciu = em.find(Ciudadano.class, id);

        return ciu;
    }

    @Override
    public List<Supervisor> getSupervisores() {
        List<Supervisor> res = em.createQuery("select s from Supervisor s", Supervisor.class).getResultList();
        return res;
    }

    @Override
    public List<Brigada> getBrigadas() {
        List<Brigada> res = em.createQuery("select b from Brigada b", Brigada.class).getResultList();
        return res;
    }

    @Override
    public List<Operario> getOperarios() {
        List<Operario> res = em.createQuery("select o from Operario o", Operario.class).getResultList();
        return res;
    }

    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> res = em.createQuery("select e from Empleado e", Empleado.class).getResultList();
        return res;
    }

    public List<Ciudadano> getCiudadanos() {
        List<Ciudadano> res = em.createQuery("select c from Ciudadano c", Ciudadano.class).getResultList();
        return res;
    }

    @Override
    public void cerrarAviso(Integer id_aviso) {
        List<Aviso> avisos = getAvisos();
        Aviso aviso;
        for (Aviso a : avisos) {
            if (a.getId_aviso().equals(id_aviso)) {
                aviso = a;
                aviso.setEstado(Aviso.Estado.CERRADO);
                em.merge(aviso);
            }
        }
    }
}
