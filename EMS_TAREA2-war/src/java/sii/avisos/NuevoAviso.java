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
        
        System.out.println("Comprobando avisos duplicados");
        comprobarAvisosDuplicados();

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
     
     public void comprobarAvisosDuplicados () {
         
        List<Aviso> avisos;
        avisos = bdl.getAvisos();
        String c = aviso.getCoordenada();
        String [] cs = c.split(",");
        double Lat1 = Double.parseDouble(cs[0]);
        double Lon1 = Double.parseDouble(cs[1]);
        System.out.println(c);
        
        for (Aviso a : avisos) {
            
            if (a.getCoordenada() != null) { 
                String coordenada = a.getCoordenada();
                System.out.println(" Aviso " + a.getId_aviso() + " :coordenada");
                String [] coordenadas  = coordenada.split(",");
                double Lat2 = Double.parseDouble(coordenadas[0]);
                double Lon2 = Double.parseDouble(coordenadas[1]);
            
            
                double PI = 3.14159265358979323846;
                Lat1 = Lat1 * PI / 180;
                Lon1 = Lon1 * PI / 180;
                Lat2 = Lat2 * PI / 180;
                Lon2 = Lon2 * PI / 180;
                
                double distancia;
                
                distancia = 6378.137 * Math.acos(Math.cos(Lat1) * Math.cos(Lat2) * Math.cos(Lon2 - Lon1) + Math.sin(Lat1) * Math.sin(Lat2));
                System.out.println("Distancia: " + distancia);
                
                if (distancia < 200) {
                    List<Aviso> ae = new ArrayList<>();
                    ae.add(a);
                    aviso.setAvisoEnlazado(ae);
                    
                    List ae2 = aviso.getAvisoEnlazado2();
                    ae2.add(a);
                    aviso.setAvisoEnlazado2(ae2);
                    
            } else {
                System.out.println("Aviso " + a.getId_aviso() + " sin coordenadas");
            }
        }
    }
}

}