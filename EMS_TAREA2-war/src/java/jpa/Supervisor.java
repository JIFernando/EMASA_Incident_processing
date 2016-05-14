/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@DiscriminatorValue("S")
@PrimaryKeyJoinColumn(name = "S_EMPLEADOID")
public class Supervisor extends Empleado implements Serializable {

    //  Relación de uno a muchos entre SUPERVISOR Y AVISO
    @OneToMany(mappedBy = "supervisor")
    private List<Aviso> avisos;
    //------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.id_empl != null ? this.id_empl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supervisor)) {
            return false;
        }
        Supervisor other = (Supervisor) object;
        if ((this.id_empl == null && other.id_empl != null) || (this.id_empl != null && !this.id_empl.equals(other.id_empl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emasa.Supervisor[ id=" + this.id_empl + " ]";
    }

    /**
     * *************GETTERS Y SETTERS**************
     */

    public List<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Aviso> avisos) {
        this.avisos = avisos;
    }


}
