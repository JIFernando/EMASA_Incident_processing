/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@DiscriminatorValue("O")
@PrimaryKeyJoinColumn(name = "O_EMPLEADOID")
public class Operario extends Empleado implements Serializable {

    //  Relación de muchos a uno entre OPERARIO Y BRIGADA
    @ManyToOne
    private Brigada brigada_operario;
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
        if (!(object instanceof Operario)) {
            return false;
        }
        Operario other = (Operario) object;
        if ((this.id_empl == null && other.id_empl != null) || (this.id_empl != null && !this.id_empl.equals(other.id_empl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emasa.Operario[ id=" + this.id_empl + " ]";
    }

    /**
     * *************GETTERS Y SETTERS**************
     */
    public Long getId() {
        return this.id_empl;
    }

    public void setId(Long id) {
        this.id_empl = id;
    }

    public Brigada getBrigada_operario() {
        return brigada_operario;
    }

    public void setBrigada_operario(Brigada brigada_operario) {
        this.brigada_operario = brigada_operario;
    }

    public Long getId_empl() {
        return id_empl;
    }

    public void setId_empl(Long id_empl) {
        this.id_empl = id_empl;
    }

}
