package sii.avisos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import jpa.Aviso;
import jpa.Aviso.Estado;
import jpa.Aviso.Prioridad;
import jpa.Brigada;
import jpa.Ciudadano;
import jpa.Diagnostico;
import jpa.Empleado;
import jpa.Supervisor;
import sii.ejb.BaseDeDatosLocal;

/**
 *
 * @author JenniferAdmin
 */
@Named("nuevoAviso")
@RequestScoped
public class NuevoAviso {

    private Estado estado;
    private Prioridad prioridad;

    private List<Ciudadano> ciudadanos;
    private List<Empleado> empleados;

    private Integer id_brigada;
    private Integer id_ciudadano;
    private Integer id_empleado;

    private String[] diagnosticos;

    @Inject
    ListaDeAvisos lda;
    private Aviso aviso;

    @EJB
    BaseDeDatosLocal bdl;

    public NuevoAviso() {
        aviso = new Aviso();
    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public String guardarAviso() {
        List<Supervisor> supervisores = bdl.getSupervisores();
        int num = supervisores.size();

        Random rnd = new Random();
        int aleatorio = rnd.nextInt(num);

        Supervisor sup = supervisores.get(aleatorio);
        aviso.setSupervisor(sup);

        aviso.setFecha_creacion(new Date());

        if (id_brigada != null) {
            Brigada bri = bdl.obtenerBrigada(id_brigada);
            aviso.setBrigada(bri);
        }

        if (id_ciudadano != null) {
            Ciudadano ciu = bdl.obtenerCiudadano(id_ciudadano);
            aviso.setCiudadano(ciu);
        }

        if (id_empleado != null) {
            Empleado emp = bdl.obtenerEmpleado(id_empleado);
            aviso.setEmpleado(emp);
        }

        aviso.setPrioridad(prioridad);
        aviso.setEstado(estado);

        aviso.setPrioridad(prioridad);
        aviso.setEstado(estado);

        aviso.setId_aviso(tomarMaximoId() + 1);

        List<Diagnostico> diagnosticos_bd = lda.getDiagnosticos();
        List<Diagnostico> diagnosticos_nuevos = new ArrayList<>();
        for (String d : diagnosticos) {
            diagnosticos_nuevos.add(diagnosticos_bd.get(Integer.parseInt(d) - 1));
        }
        aviso.setEsDeTipo(diagnosticos_nuevos);
        bdl.insertarAviso(aviso);

        return "grid_avisos.xhtml";
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public ListaDeAvisos getLda() {
        return lda;
    }

    public void setLda(ListaDeAvisos lda) {
        this.lda = lda;
    }

    public List<Ciudadano> getCiudadanos() {
        ciudadanos = bdl.getCiudadanos();
        return ciudadanos;
    }

    public void setCiudadanos(List<Ciudadano> ciudadanos) {
        this.ciudadanos = ciudadanos;
    }

    public List<Empleado> getEmpleados() {
        empleados = bdl.getEmpleados();
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Integer getId_brigada() {
        return id_brigada;
    }

    public void setId_brigada(Integer id_brigada) {
        this.id_brigada = id_brigada;
    }

    public Integer getId_ciudadano() {
        return id_ciudadano;
    }

    public void setId_ciudadano(Integer id_ciudadano) {
        this.id_ciudadano = id_ciudadano;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public BaseDeDatosLocal getBdl() {
        return bdl;
    }

    public void setBdl(BaseDeDatosLocal bdl) {
        this.bdl = bdl;
    }

    public String[] getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(String[] diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public Integer tomarMaximoId() {
        List<Aviso> avisos = lda.getDatos();
        int maximo = Integer.MIN_VALUE;
        for (Aviso a : avisos) {
            if (maximo < a.getId_aviso()) {
                maximo = a.getId_aviso();
            }
        }
        System.out.println("Nuevo id: " + (maximo + 1));
        return maximo;
    }

    public Integer tomarSiguienteId() {
        return tomarMaximoId() + 1;
    }
}
