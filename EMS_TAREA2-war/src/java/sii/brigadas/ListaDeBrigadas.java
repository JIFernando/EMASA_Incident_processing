/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.brigadas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import jpa.Brigada;

@Named(value = "listaDeBrigadas")
@SessionScoped
public class ListaDeBrigadas implements Serializable {

    List<Brigada> datos;

    public ListaDeBrigadas() {
        datos = new ArrayList<>();
        List<String> os1 = new ArrayList<>();
        os1.add("Ned Stark");
        os1.add("Walter Frey");

        Brigada b1 = new Brigada(1, "Contratas Málaga S.L.", "Tyrion Lannister", os1);
        Brigada b2 = new Brigada(2, "Contratas Málaga S.L.", "Jaime Lannister", null);
        Brigada b3 = new Brigada(3, "Emasa", "Cersei Lannister", null);

        datos.add(b1);
        datos.add(b2);
        datos.add(b3);
    }

    public List<Brigada> getDatos() {
        return datos;
    }

    public void setDatos(List<Brigada> datos) {
        this.datos = datos;
    }

    public void addDatos(Brigada b) {
        this.datos.add(b);
    }

}
