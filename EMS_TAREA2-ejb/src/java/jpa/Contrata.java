/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Contrata implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_contrata;
    private String nif;
    private String nombre;
    private String sede;

    //  Relación de uno a muchos entre CONTRATA Y BRIGADA
    @OneToMany(mappedBy = "contrata_brigada")
    private List<Brigada> brigadas;
    //------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_contrata != null ? id_contrata.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contrata)) {
            return false;
        }
        Contrata other = (Contrata) object;
        if ((this.id_contrata == null && other.id_contrata != null) || (this.id_contrata != null && !this.id_contrata.equals(other.id_contrata))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emasa.Contrata[ id=" + id_contrata + " ]";
    }

    /**
     * *************GETTERS Y SETTERS**************
     */
    public Long getId_contrata() {
        return id_contrata;
    }

    public void setId_contrata(Long id_contrata) {
        this.id_contrata = id_contrata;
    }

    /**
     * @return the nif
     */
    public String getNif() {
        return nif;
    }

    /**
     * @param nif the nif to set
     */
    public void setNif(String nif) {
        this.nif = nif;
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
     * @return the sede
     */
    public String getSede() {
        return sede;
    }

    /**
     * @param sede the sede to set
     */
    public void setSede(String sede) {
        this.sede = sede;
    }

    /**
     * @return the brigadas
     */
    public List<Brigada> getBrigadas() {
        return brigadas;
    }

    /**
     * @param brigadas the brigadas to set
     */
    public void setBrigadas(List<Brigada> brigadas) {
        this.brigadas = brigadas;
    }

}
