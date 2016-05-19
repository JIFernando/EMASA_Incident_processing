/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ejb;

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
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Aviso> getAvisos() {
        List<Aviso> res = em.createQuery("select a from Aviso a", Aviso.class).getResultList();
        return res;
    }

    @Override
    public void compruebaLogin(Empleado empleado) throws EmasaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarAviso(Aviso aviso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarAviso(Aviso aviso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarAviso(Aviso aviso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<OrdenTrabajo> getOrdenesTrabajo() {
        return em.createQuery("select u from OrdenTrabajo u", OrdenTrabajo.class).getResultList();
    }

    public void insertarOT(OrdenTrabajo a) {
        em.persist(a);
    }

    public void modificarOT(OrdenTrabajo a) {
        em.merge(a);
    }
}
