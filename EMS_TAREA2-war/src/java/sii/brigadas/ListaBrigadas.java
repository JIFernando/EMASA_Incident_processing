/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.brigadas;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import jpa.Brigada;

/**
 *
 * @author JenniferAdmin
 */

@Named(value = "listaBrigadas")
@RequestScoped
public class ListaBrigadas {

    public ListaBrigadas() {

    }

    public List<Brigada> getListaBrigadas() {

        List<Brigada> brigadas = new ArrayList<>();
        List<String> os1 = new ArrayList<>();
        os1.add("Ned Stark");
        os1.add("Walter Frey");

        Brigada b1 = new Brigada(1, "Contratas Málaga S.L.", "Tyrion Lannister", os1);
        Brigada b2 = new Brigada(2, "Contratas Málaga S.L.", "Jaime Lannister", null);
        Brigada b3 = new Brigada(3, "Emasa", "Cersei Lannister", null);

        brigadas.add(b1);
        brigadas.add(b2);
        brigadas.add(b3);

        return brigadas;
    }

}
