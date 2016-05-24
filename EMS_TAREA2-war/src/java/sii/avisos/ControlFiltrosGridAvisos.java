package sii.avisos;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import jpa.Aviso;
import jpa.Aviso.Estado;
import jpa.Aviso.Prioridad;

@Named(value = "controlFiltrosGridAvisos")
@SessionScoped
public class ControlFiltrosGridAvisos implements Serializable {
    private Prioridad prioridad;
    private Estado estado;
    private Date fecha_inicio;
    private Date fecha_fin;
    private Integer id_aviso;

    @Inject
    ListaDeAvisos la;

    /**
     * Creates a new instance of ControlAutorizacion
     */
    public ControlFiltrosGridAvisos() {
        prioridad = Prioridad.TODOS;
        estado = Estado.TODOS;
        fecha_inicio = null;
        fecha_fin = null;
        id_aviso = null;
    }

    public List<Aviso> getListaAvisosFiltrados() {
        List<Aviso> datos = la.getDatos();
        List<Aviso> resultado = new ArrayList<>();
        for (Aviso a : datos) {
            if (cumpleFiltroPrioridad(a) && cumpleFiltroEstado(a)
                    && cumpleFiltroFechaInicio(a) && cumpleFiltroFechaFin(a)
                    && cumpleFiltroId(a)) {
                resultado.add(a);
            }
        }
        return resultado;
    }

    public void resetear() {
        prioridad = Prioridad.TODOS;
        estado = Estado.TODOS;
        fecha_inicio = null;
        fecha_fin = null;
        id_aviso = null;
    }

    private boolean cumpleFiltroPrioridad(Aviso a) {
        return a.getPrioridad().equals(prioridad) || prioridad.equals(Prioridad.TODOS);
    }

    private boolean cumpleFiltroEstado(Aviso a) {
        return a.getEstado().equals(estado) || estado.equals(Estado.TODOS);
    }

    private boolean cumpleFiltroFechaInicio(Aviso a) {
        return (fecha_inicio == null) || a.getFecha_creacion().after(fecha_inicio) || a.getFecha_creacion().equals(fecha_inicio);
    }

    private boolean cumpleFiltroFechaFin(Aviso a) {
        return (fecha_fin == null) || a.getFecha_creacion().before(fecha_fin) || a.getFecha_creacion().equals(fecha_fin);
    }

    private boolean cumpleFiltroId(Aviso a) {
        return id_aviso == null || a.getId_aviso().equals(id_aviso);
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public Integer getId_aviso() {
        return id_aviso;
    }

    public void setId_aviso(Integer id_aviso) {
        this.id_aviso = id_aviso;
    }

    public ListaDeAvisos getLa() {
        return la;
    }

    public void setLa(ListaDeAvisos la) {
        this.la = la;
    }

}
