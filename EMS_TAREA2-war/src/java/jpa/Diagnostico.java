/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Diagnostico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_diag;
    @Column(unique = true)
    private String nombre;
    private String descripcion;
    @ManyToMany(mappedBy = "esDeTipo")
    private List<Aviso> avisos;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_diag != null ? id_diag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diagnostico)) {
            return false;
        }
        Diagnostico other = (Diagnostico) object;
        if ((this.id_diag == null && other.id_diag != null) || (this.id_diag != null && !this.id_diag.equals(other.id_diag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emasa.Diagnostico[ id=" + id_diag + " ]";
    }

    /**
     * *************GETTERS Y SETTERS**************
     */
    public Long getId_diag() {
        return id_diag;
    }

    public void setId_diag(Long id_diag) {
        this.id_diag = id_diag;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the avisos
     */
    public List<Aviso> getAvisos() {
        return avisos;
    }

    /**
     * @param avisos the avisos to set
     */
    public void setAvisos(List<Aviso> avisos) {
        this.avisos = avisos;
    }

}
