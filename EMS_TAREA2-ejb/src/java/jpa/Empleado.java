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
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import static javax.persistence.InheritanceType.JOINED;
import javax.persistence.OneToMany;



@Entity
@Inheritance(strategy = JOINED)
public class Empleado implements Serializable {

    // private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id_empl;
    private String nombre;
    private String apellido1, apellido2;
    private String password;
    @Temporal(TemporalType.DATE)
    private Date inic_cont, fin_cont;
    private String tipo_horario;
    private Long salario;

    //  Relación de uno a muchos entre EMPLEADOS Y AVISO
    @OneToMany(mappedBy = "empleado")
    private List<Aviso> avisos;
    //-----------------------------------------------//

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId_empl() != null ? getId_empl().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.getId_empl() == null && other.getId_empl() != null) || (this.getId_empl() != null && !this.id_empl.equals(other.id_empl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emasa.Empleado[ id=" + getId_empl() + " ]";
    }

    
    /**
     * *************GETTERS Y SETTERS**************
     */
    public Long getId() {
        return getId_empl();
    }

    public void setId(Long id) {
        this.setId_empl(getId_empl());
    }

    public List<Aviso> getAvisos() {
        return avisos;
    }

    public void setAvisos(List<Aviso> avisos) {
        this.avisos = avisos;
    }

    /**
     * @return the id_empl
     */
    public Long getId_empl() {
        return id_empl;
    }

    /**
     * @param id_empl the id_empl to set
     */
    public void setId_empl(Long id_empl) {
        this.id_empl = id_empl;
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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the inic_cont
     */
    public Date getInic_cont() {
        return inic_cont;
    }

    /**
     * @param inic_cont the inic_cont to set
     */
    public void setInic_cont(Date inic_cont) {
        this.inic_cont = inic_cont;
    }

    /**
     * @return the fin_cont
     */
    public Date getFin_cont() {
        return fin_cont;
    }

    /**
     * @param fin_cont the fin_cont to set
     */
    public void setFin_cont(Date fin_cont) {
        this.fin_cont = fin_cont;
    }

    /**
     * @return the tipo_horario
     */
    public String getTipo_horario() {
        return tipo_horario;
    }

    /**
     * @param tipo_horario the tipo_horario to set
     */
    public void setTipo_horario(String tipo_horario) {
        this.tipo_horario = tipo_horario;
    }

    /**
     * @return the salario
     */
    public Long getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(Long salario) {
        this.salario = salario;
    }

}
