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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Brigada implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //private Long id_brigada;
    private Integer id_brigada;

    //  Relación de muchos a uno entre BRIGADA Y CAPATAZ
    @ManyToOne
    @JoinColumn(nullable = false)
    private Capataz capataz;
    
    //------------------------------------------//

    //  Relación de uno a muchos entre BRIGADA Y AVISO
    @OneToMany(mappedBy = "brigada")
    private List<Aviso> avisos;
    //------------------------------------------//

    //  Relación de uno a muchos entre BRIGADA Y OPERARIO
    @OneToMany(mappedBy = "brigada_operario")
    private List<Operario> operarios;

    public String getContrata() {    
        return contrata;
    }

    public void setContrata(String contrata) {
        this.contrata = contrata;
    }

    public String getNombreCapataz() {
        return nombreCapataz;
    }

    public void setNombreCapataz(String nombreCapataz) {
        this.nombreCapataz = nombreCapataz;
    }

    public List<String> getNombreOperarios() {
        return nombreOperarios;
    }

    public void setNombreOperarios(List<String> nombreOperarios) {
        this.nombreOperarios = nombreOperarios;
    }

    
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    private String contrata;
    private String nombreCapataz;
    private List<String> nombreOperarios;
    
    public Brigada (int id, String contrata, String nombreCapataz, List<String> nombreOperarios) {
        this.id = id;
        this.contrata = contrata;
        this.nombreCapataz = nombreCapataz;
        this.nombreOperarios = nombreOperarios;
    }
    
    public int getNumOperarios (List<Operario> listaOperarios) {
        return operarios.size() + 1;
    }
    //------------------------------------------//

    //  Relación de uno a muchos entre BRIGADA Y ORDENDETRABAJO
    @OneToMany(mappedBy = "brigada_ot")
    private List<OrdenTrabajo> ordentrabajo;
    //------------------------------------------//

    //  Relación de muchos a uno entre BRIGADA Y CONTRATA
    @ManyToOne
    private Contrata contrata_brigada;
    //------------------------------------------//
        

    @Override
    public String toString() {
        return "emasa.Brigada[ id=" + id_brigada + " ]";
    }

    /**
     * **************GETTERS Y SETTERS***************
     */
    public Integer getId_brigada() {
        return id_brigada;
    }

    public void setId_brigada(Integer id_brigada) {
        this.id_brigada = id_brigada;
    }

    public Capataz getCapataz() {
        return capataz;
    }

    /**
     * @param capataz the capataz to set
     */
    public void setCapataz(Capataz capataz) {
        this.capataz = capataz;
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

    /**
     * @return the operarios
     */
    public List<Operario> getOperarios() {
        return operarios;
    }

    /**
     * @param operarios the operarios to set
     */
    public void setOperarios(List<Operario> operarios) {
        this.operarios = operarios;
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
     * @return the contrata_brigada
     */
    public Contrata getContrata_brigada() {
        return contrata_brigada;
    }

    /**
     * @param contrata_brigada the contrata_brigada to set
     */
    public void setContrata_brigada(Contrata contrata_brigada) {
        this.contrata_brigada = contrata_brigada;
    }
    
    public String getNombreCompletoCapataz () {
        return "capataz.getNombre()" + " capataz.getApellido1()" + " capataz.getApellido2()";
    }

}
