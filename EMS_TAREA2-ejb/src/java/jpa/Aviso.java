/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;
//

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Aviso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_aviso;
    @Temporal(TemporalType.DATE)
    private Date fecha_creacion, inic_Averia, fin_averia, fecha_asig;

    public enum Estado {
        SIN_ATENDER, EN_PROCESO, CERRADO, TODOS;
        
        @Override
        public String toString() {
            switch(this) {
                case SIN_ATENDER: return "Sin atender";
                case EN_PROCESO: return "En proceso";
                case CERRADO: return "Cerrado";
                case TODOS: return "Todos";
                default: throw new IllegalArgumentException();
            }
        }
    }
    private Estado estado;
    private String ubicacion;
    private String observaciones;

    public enum Prioridad {
        URGENTE, PLANIFICADO, TODOS;
        
        @Override
        public String toString() {
            switch(this) {
                case URGENTE: return "Urgente";
                case PLANIFICADO: return "Planificado";
                case TODOS: return "Todos";
                default: throw new IllegalArgumentException();
            }
        }
    }
    private Prioridad prioridad;
    private String coordenada;

    //  Relación de muchos a muchos entre AVISO Y DIAGNOSTICO
    @ManyToMany
    @JoinTable(name = "aviso_diagnostico", joinColumns = @JoinColumn(name = "aviso_fk"), inverseJoinColumns = @JoinColumn(name = "diagnostico_fk"))
    private List<Diagnostico> esDeTipo;
    //-----------------------------------------------//

    //  Relación de muchos a muchos REFLEXIVA  en AVISO
    @ManyToMany
    @JoinTable(name = "aviso_reflexivo", joinColumns = @JoinColumn(name = "aviso_ref_fk"), inverseJoinColumns = @JoinColumn(name = "aviso_ref_2_fk"))
    private List<Aviso> avisoEnlazado;
    @ManyToMany(mappedBy = "avisoEnlazado")
    private List<Aviso> avisoEnlazado2;
    
    //  NUEVO CÓDIGO AÑADIR AVISO ENLAZADO
    
    public void agnadirAvisoEnlazado (Aviso a) {
        avisoEnlazado.add(a);
    }
    
    //  FIN NUEVO CÓDIGO
    
    //-----------------------------------------------//

    //  Relación muchos a uno de AVISO a EMPLEADO
    @ManyToOne
    private Empleado empleado;
    //------------------------------------------//

    //  Relación de uno a muchos entre AVISO Y OrdenDeTrabajo
    @OneToMany(mappedBy = "aviso")
    private List<OrdenTrabajo> ordentrabajo;
    //------------------------------------------//

    //  Relación de muchos a uno entre AVISO Y CIUDADANOS
    @ManyToOne
    private Ciudadano ciudadano;
    //------------------------------------------//

    //  Relación de muchos a uno entre AVISO Y SUPERVISOR
    @ManyToOne
    @JoinColumn(nullable = false)
    private Supervisor supervisor;
    //------------------------------------------//

    //  Relación de muchos a uno entre AVISO Y BRIGADA
    @ManyToOne(fetch = FetchType.EAGER)
    private Brigada brigada;
    //------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_aviso != null ? id_aviso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aviso)) {
            return false;
        }
        Aviso other = (Aviso) object;
        if ((this.id_aviso == null && other.id_aviso != null) || (this.id_aviso != null && !this.id_aviso.equals(other.id_aviso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        //return "emasa.Aviso[ id=" + id_aviso + " ]";
        return "" + id_aviso;
    }

    /**
     * ***************GETTERS Y SETTERS****************
     * @return 
     */
    public Integer getId_aviso() {
        return id_aviso;
    }

    public void setId_aviso(Integer id_aviso) {
        this.id_aviso = id_aviso;
    }

    /**
     * @return the fecha_creacion
     */
    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    /**
     * @param fecha_creacion the fecha_creacion to set
     */
    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * @return the inic_Averia
     */
    public Date getInic_Averia() {
        return inic_Averia;
    }

    /**
     * @param inic_Averia the inic_Averia to set
     */
    public void setInic_Averia(Date inic_Averia) {
        this.inic_Averia = inic_Averia;
    }

    /**
     * @return the fin_averia
     */
    public Date getFin_averia() {
        return fin_averia;
    }

    /**
     * @param fin_averia the fin_averia to set
     */
    public void setFin_averia(Date fin_averia) {
        this.fin_averia = fin_averia;
    }

    /**
     * @return the fecha_asig
     */
    public Date getFecha_asig() {
        return fecha_asig;
    }

    /**
     * @param fecha_asig the fecha_asig to set
     */
    public void setFecha_asig(Date fecha_asig) {
        this.fecha_asig = fecha_asig;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the ubicacion
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the prioridad
     */
    public Prioridad getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the coordenada
     */
    public String getCoordenada() {
        return coordenada;
    }

    /**
     * @param coordenada the coordenada to set
     */
    public void setCoordenada(String coordenada) {
        this.coordenada = coordenada;
    }

    /**
     * @return the esDeTipo
     */
    public List<Diagnostico> getEsDeTipo() {
        return esDeTipo;
    }

    /**
     * @param esDeTipo the esDeTipo to set
     */
    public void setEsDeTipo(List<Diagnostico> esDeTipo) {
        this.esDeTipo = esDeTipo;
    }

    /**
     * @return the avisoEnlazado
     */
    public List<Aviso> getAvisoEnlazado() {
        return avisoEnlazado;
    }

    /**
     * @param avisoEnlazado the avisoEnlazado to set
     */
    public void setAvisoEnlazado(List<Aviso> avisoEnlazado) {
        this.avisoEnlazado = avisoEnlazado;
    }

    /**
     * @return the avisoEnlazado2
     */
    public List<Aviso> getAvisoEnlazado2() {
        return avisoEnlazado2;
    }

    /**
     * @param avisoEnlazado2 the avisoEnlazado2 to set
     */
    public void setAvisoEnlazado2(List<Aviso> avisoEnlazado2) {
        this.avisoEnlazado2 = avisoEnlazado2;
    }

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the ordentrabajo
     */
    public List<OrdenTrabajo> getOrdentrabajo() {
        return ordentrabajo;
    }

    /**
     * @param ordentrabajo the ordentrabajo to set
     */
    public void setOrdentrabajo(List<OrdenTrabajo> ordentrabajo) {
        this.ordentrabajo = ordentrabajo;
    }

    /**
     * @return the ciudadano
     */
    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    /**
     * @param ciudadano the ciudadano to set
     */
    public void setCiudadano(Ciudadano ciudadano) {
        this.ciudadano = ciudadano;
    }

    /**
     * @return the supervisor
     */
    public Supervisor getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the brigada
     */
    public Brigada getBrigada() {
        return brigada;
    }

    /**
     * @param brigada the brigada to set
     */
    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }
    
}
