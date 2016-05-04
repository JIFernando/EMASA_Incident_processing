/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class OrdenTrabajo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_OT;
    private String trabajo;
    private String motivo;
    private String ubicacion;
    @Temporal(TemporalType.DATE)
    private Date fecha_creac, fecha_progr;
    private String estado;
    private String taller;
    private String prioridad;
    private String observaciones;
    private Long pto_trabajo;

    // Relación muchos a uno entre ORDENDETRABAJO y AVISO
    @ManyToOne
    @JoinColumn(nullable = false)
    private Aviso aviso;
    //------------------------------------------//

    //  Relación de muchos a uno entre ORDENDETRABAJO Y BRIGADA
    @ManyToOne
    private Brigada brigada_ot;
    //------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_OT != null ? id_OT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenTrabajo)) {
            return false;
        }
        OrdenTrabajo other = (OrdenTrabajo) object;
        if ((this.id_OT == null && other.id_OT != null) || (this.id_OT != null && !this.id_OT.equals(other.id_OT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emasa.OrdenTrabajo[ id=" + id_OT + " ]";
    }

    /**
     * *************GETTERS Y SETTERS**************
     */
    public Long getId_OT() {
        return id_OT;
    }

    public void setId_OT(Long id_OT) {
        this.id_OT = id_OT;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFecha_creac() {
        return fecha_creac;
    }

    public void setFecha_creac(Date fecha_creac) {
        this.fecha_creac = fecha_creac;
    }

    public Date getFecha_progr() {
        return fecha_progr;
    }

    public void setFecha_progr(Date fecha_progr) {
        this.fecha_progr = fecha_progr;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getPto_trabajo() {
        return pto_trabajo;
    }

    public void setPto_trabajo(Long pto_trabajo) {
        this.pto_trabajo = pto_trabajo;
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public Brigada getBrigada_ot() {
        return brigada_ot;
    }

    public void setBrigada_ot(Brigada brigada_ot) {
        this.brigada_ot = brigada_ot;
    }

}
