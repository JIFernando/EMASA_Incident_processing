package sii.avisos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Brigada;
import jpa.Capataz;
import jpa.Diagnostico;
import jpa.Empleado;
import jpa.Empleado.Rol;
import jpa.Operario;
import jpa.Supervisor;
import sii.controlUsuarios.ControlAutorizacion;
import sii.ejb.BaseDeDatosLocal;

/**
 * Esta clase contendrá todos los avisos de la base de datos
 */
@Named(value = "listaDeAvisos")
@RequestScoped
public class ListaDeAvisos implements Serializable {

    List<Aviso> datos;

    @EJB
    BaseDeDatosLocal bdl;

    /*AÑADIDO*/
    @Inject
    ControlAutorizacion ca;

    public ListaDeAvisos() {
    }

    public List<Aviso> getDatos() {
        /*AÑADIDO*/
        datos = new ArrayList<>();
        List<Aviso> resultado = bdl.getAvisos();
        Empleado e = ca.getEmpleado();
        Rol rol = e.getRol();
        System.out.println(rol);
        for (Aviso a : resultado) {
            switch (rol) {
                case SUPERVISOR:
                    if (a.getSupervisor().getId_empl().equals(e.getId_empl())) {
                        datos.add(a);
                    }
                    break;
                case OPERARIO:
                    if (a.getBrigada() != null) {
                        Operario o = averiguarOperario(e);
                        Brigada b = o.getBrigada_operario();
                        Integer id_brigada = b.getId_brigada();
                        if (a.getBrigada().getId_brigada().equals(id_brigada)) {
                            datos.add(a);
                        }
                    }
                    break;
                default:
                    if (a.getBrigada() != null) {
                        Capataz c = averiguarCapataz(e);
                        List<Brigada> brigadas_capataz = c.getBrigadas();
                        for (Brigada br : brigadas_capataz) {
                            if (a.getBrigada().getId_brigada().equals(br.getId_brigada())) {
                                datos.add(a);
                            }
                        }
                    }
                    break;
            }
        }

        return datos;
    }
//    public List<Aviso> getAvisosVinculados(Aviso avs) {
//        //List<Aviso> avisos = bdl.getAvisos();
//        return avs.getAvisoEnlazado();
//    }

    public void setDatos(List<Aviso> datos) {
        this.datos = datos;
    }

    public void addDatos(Aviso a) {
        this.datos.add(a);
    }

    public String crearAvisoVinculado(int id, Date fechaInicio, Date fechaFinal, String ubicacion, String coordenadas, String observaciones, Aviso.Prioridad prioridad, Aviso.Estado estado, Aviso vin) {
        Date fecha_creacion = new Date();

        Aviso a = new Aviso();
        a.setId_aviso(id);
        a.setFecha_creacion(fecha_creacion);
        a.setInic_Averia(fechaInicio);
        a.setFin_averia(fechaFinal);
        a.setUbicacion(ubicacion);
        a.setCoordenada(coordenadas);
        a.setObservaciones(observaciones);
        a.setPrioridad(prioridad);
        a.setEstado(estado);

        List<Supervisor> supervisores = bdl.getSupervisores();
        int num = supervisores.size();

        Random rnd = new Random();
        int aleatorio = rnd.nextInt(num);

        Supervisor sup = supervisores.get(aleatorio);
        a.setSupervisor(sup);

        if (vin.getAvisoEnlazado() == null) {
            List<Aviso> avisosVincu2 = new ArrayList<>();
            avisosVincu2.add(a);
            vin.setAvisoEnlazado(avisosVincu2);
        } else {
            List<Aviso> avi = vin.getAvisoEnlazado();
            avi.add(a);
            vin.setAvisoEnlazado(avi);
        }

        List<Aviso> avisosVincu = new ArrayList<>();
        avisosVincu.add(vin);
        a.setAvisoEnlazado(avisosVincu);

        // a.setSupervisor(null);
        bdl.insertarAviso(a);
        bdl.modificarAviso(vin);
        //datos.add(a);

        return "grid_avisos.xhtml";
    }

    public List<Diagnostico> getDiagnosticos() {
        return bdl.getDiagnosticos();
    }

    private Operario averiguarOperario(Empleado e) {
        List<Operario> operarios = bdl.getOperarios();
        for (Operario o : operarios) {
            if (o.getId_empl().equals(e.getId_empl())) {
                return o;
            }
        }
        return null;
    }

    private Capataz averiguarCapataz(Empleado e) {
        List<Capataz> capataces = bdl.getCapataces();
        for (Capataz c : capataces) {
            if (c.getId_empl().equals(e.getId_empl())) {
                return c;
            }
        }
        return null;
    }
}
