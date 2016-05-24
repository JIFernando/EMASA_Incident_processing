/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.avisos;

import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Aviso.Estado;
import jpa.Aviso.Prioridad;
import jpa.Supervisor;
import sii.ejb.BaseDeDatosLocal;

/**
 *
 * @author JenniferAdmin
 */
@Named("nuevoAviso")
@RequestScoped
public class NuevoAviso {

    private Estado estado;
    private Prioridad prioridad;

    /*Aquí vamos a declarar un Integer que guardará el ID de la brigada
    Tendremos que hacer un método que, a partir de ese ID, busque el objeto
    Brigada correspondiente dentro de la BD y lo asigne al aviso*/
    private Integer id_brigada;

    @Inject
    ListaDeAvisos lda;
    private Aviso aviso;

    @EJB
    BaseDeDatosLocal bdl;

    public NuevoAviso() {
        aviso = new Aviso();
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public String guardarAviso() {
        List<Supervisor> supervisores = bdl.getSupervisores();
        int num = supervisores.size();

        Random rnd = new Random();
        int aleatorio = rnd.nextInt(num);

        Supervisor sup = supervisores.get(aleatorio);
        aviso.setSupervisor(sup);

        aviso.setFecha_creacion(new Date());
        aviso.setPrioridad(prioridad);
        aviso.setEstado(estado);

        aviso.setId_aviso(tomarMaximoId() + 1);

        System.out.println("Id en NuevoAviso: " + aviso.getId_aviso());
        bdl.insertarAviso(aviso);

        return "grid_avisos.xhtml";
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public ListaDeAvisos getLda() {
        return lda;
    }

    public void setLda(ListaDeAvisos lda) {
        this.lda = lda;
    }

    public Integer getId_brigada() {
        return id_brigada;
    }

    public void setId_brigada(Integer id_brigada) {
        this.id_brigada = id_brigada;
    }

    public BaseDeDatosLocal getBdl() {
        return bdl;
    }

    public void setBdl(BaseDeDatosLocal bdl) {
        this.bdl = bdl;
    }

    public Integer tomarMaximoId() {
        List<Aviso> avisos = lda.getDatos();
        int maximo = Integer.MIN_VALUE;
        for (Aviso a : avisos) {
            if (maximo < a.getId_aviso()) {
                maximo = a.getId_aviso();
            }
        }
        System.out.println("Nuevo id: " + (maximo+1));
        return maximo;
    }
    
     public Integer tomarSiguienteId() {
        return tomarMaximoId()+1;
    }
}
