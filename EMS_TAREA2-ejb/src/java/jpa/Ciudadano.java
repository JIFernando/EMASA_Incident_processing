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
public class Ciudadano implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_ciudadano;
    private String email;
    private String nombre, apellido1, apellido2;

    //  Relación de uno a muchos entre CIUDADANO Y AVISOS
    @OneToMany(mappedBy = "ciudadano")
    private List<Aviso> avisos;
    //------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_ciudadano != null ? id_ciudadano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ciudadano)) {
            return false;
        }
        Ciudadano other = (Ciudadano) object;
        if ((this.id_ciudadano == null && other.id_ciudadano != null) || (this.id_ciudadano != null && !this.id_ciudadano.equals(other.id_ciudadano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emasa.Ciudadano[ id=" + id_ciudadano + " ]";
    }

    /**
     * *************GETTERS Y SETTERS**************
     */
    
    public Long getId_ciudadano() {
        return id_ciudadano;
    }

    public void setId_ciudadano(Long id_ciudadano) {
        this.id_ciudadano = id_ciudadano;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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
     * @return the apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * @param apellido1 the apellido1 to set
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    /**
     * @return the apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * @param apellido2 the apellido2 to set
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
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
