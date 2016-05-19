/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
        return em.createQuery("select u from Aviso u", Aviso.class).getResultList();
    }
    @Override
    public List<OrdenTrabajo> getOrdenesTrabajo(){
        return em.createQuery("select u from OrdenTrabajo u", OrdenTrabajo.class).getResultList();
    }
    @Override
    public void insertarOT(OrdenTrabajo a){
        em.persist(a);
    }  
    @Override
    public void modificarOT(OrdenTrabajo a){
        em.merge(a);
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
}
