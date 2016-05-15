/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@DiscriminatorValue("C")
@PrimaryKeyJoinColumn(name="C_EMPLEADOID")
public class Capataz extends Empleado implements Serializable {
    
    //  NUEVO CÓDIGO    //
    
    public void addBrigada (Brigada b) {
        if (!brigadas.isEmpty()) {
            brigadas.add(b);
        } else {
            brigadas = new ArrayList<>();
            brigadas.add(b);
        }
    }
    
    public void removeBrigada (Brigada b) {
        brigadas.remove(b);
    }
    
    //  FIN NUEVO CÓDIGO    //
    
    //  Relación de uno a muchos entre CAPATAZ Y BRIGADA
    @OneToMany(mappedBy="capataz")
    private List<Brigada> brigadas;
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
        if (!(object instanceof Capataz)) {
            return false;
        }
        Capataz other = (Capataz) object;
        if ((this.id_empl == null && other.id_empl != null) || (this.id_empl != null && !this.id_empl.equals(other.id_empl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emasa.Capataz[ id=" + this.id_empl + " ]";
    }
    
     /***************GETTERS Y SETTERS***************/
    
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
