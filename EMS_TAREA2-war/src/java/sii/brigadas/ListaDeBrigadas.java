/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.brigadas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Brigada;
import jpa.Capataz;
import jpa.Contrata;
import jpa.Operario;
import sii.ejb.BaseDeDatosLocal;

@Named(value = "listaDeBrigadas")
@SessionScoped
public class ListaDeBrigadas implements Serializable {

    List<Brigada> datos;
    List<Brigada> brigadas = new ArrayList<>();
    List<Operario> operarios;

    @EJB
    BaseDeDatosLocal bdl;

    public ListaDeBrigadas() {
        /*
        System.out.println("Creando operarios...");

        List<Operario> operarios1 = new ArrayList<>();
        List<Operario> operarios2 = new ArrayList<>();
        List<Operario> operarios3 = new ArrayList<>();
        Operario o1 = new Operario();
        o1.setId_empl(1);
        o1.setNombre("Roose");
        o1.setApellido1("Bolton");
        o1.setApellido2("");
        Operario o2 = new Operario();
        o2.setId_empl(2);
        o2.setNombre("Ramsay");
        o2.setApellido1("Bolton");
        o2.setApellido2("");
        Operario o3 = new Operario();
        o3.setId_empl(3);
        o3.setNombre("Jon");
        o3.setApellido1("Nieve");
        o3.setApellido2("");
        Operario o4 = new Operario();
        o4.setId_empl(4);
        o4.setNombre("Brandon");
        o4.setApellido1("Startk");
        o4.setApellido2("");
        Operario o5 = new Operario();
        o5.setId_empl(5);
        o5.setNombre("Rickon");
        o5.setApellido1("Stark");
        o5.setApellido2("");
        Operario o6 = new Operario();
        o6.setId_empl(6);
        o6.setNombre("Sansa");
        o6.setApellido1("Startk");
        o6.setApellido2("");

        operarios1.add(o1);
        operarios1.add(o2);
        operarios2.add(o3);
        operarios2.add(o4);
        operarios3.add(o5);
        operarios3.add(o6);

        System.out.println(operarios1.isEmpty() ? "No hay ningún operario" : "Hay " + operarios1.size() + " operarios");

        //  CREACIÓN MANUAL DE LOS CAPATACES
        Capataz cp1 = new Capataz();
        cp1.setNombre("Eddard");
        Capataz cp2 = new Capataz();
        cp2.setNombre("Stannis");
        Capataz cp3 = new Capataz();
        cp3.setNombre("Joffrey");

        //  CREACIÓN MANUAL DE LAS CONTRATAS
        Contrata c1 = new Contrata();
        Contrata c2 = new Contrata();
        Contrata c3 = new Contrata();

        c1.setNombre("Emasa");
        c2.setNombre("Stark");
        c3.setNombre("Bolton");

        //  CREACIÓN MANUAL DE LAS BRIGADAS
        Brigada b1 = new Brigada();
        Brigada b2 = new Brigada();
        Brigada b3 = new Brigada();

        b1.setId_brigada(1);
        b2.setId_brigada(2);
        b3.setId_brigada(3);

        brigadas.add(b1);
        brigadas.add(b2);
        brigadas.add(b3);
         */
 /*
        
        b1.addOperario(o1);
        b1.addOperario(o2);
        b2.addOperario(o3);
        b2.addOperario(o4);
        b3.addOperario(o5);
        b3.addOperario(o6);
        
         */
 /*
        b1.setCapataz(cp1);
        b2.setCapataz(cp2);
        b3.setCapataz(cp3);

        b1.setOperarios(operarios1);
        b2.setOperarios(operarios2);
        b3.setOperarios(operarios3);

        b1.setContrata_brigada(c1);
        b2.setContrata_brigada(c2);
        b3.setContrata_brigada(c3);
         */
        //  FIN NUEVO CÓDIGO    //
    }

    public List<Brigada> getDatos() {
        datos = bdl.getBrigadas();
        return datos;
    }

    public void setDatos(List<Brigada> datos) {
        this.datos = datos;
    }

    public void addDatos(Brigada b) {
        this.datos.add(b);
    }

    public List<Brigada> getBrigadas() {
        return brigadas;
    }

    public void setBrigadas(List<Brigada> brigadas) {
        this.brigadas = brigadas;
    }

    public List<Operario> getOperarios() {
        operarios = bdl.getOperarios();
        return operarios;
    }

    public void setOperarios(List<Operario> operarios) {
        this.operarios = operarios;
    }

    public BaseDeDatosLocal getBdl() {
        return bdl;
    }

    public void setBdl(BaseDeDatosLocal bdl) {
        this.bdl = bdl;
    }

}
