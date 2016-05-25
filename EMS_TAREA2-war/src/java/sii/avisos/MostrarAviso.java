package sii.avisos;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import jpa.Aviso;
import jpa.Brigada;
import jpa.Diagnostico;
import jpa.Supervisor;
import sii.ejb.BaseDeDatosLocal;

@Named(value = "mostrarAviso")
@SessionScoped
public class MostrarAviso implements Serializable {

    @EJB
    BaseDeDatosLocal bdl;
    
    Aviso aviso;
    private String[] diagnosticos_id;
    
    public MostrarAviso() {

    }

    public Aviso getAviso() {
        return aviso;
    }

    public void setAviso(Aviso aviso) {
        this.aviso = aviso;
    }

    public String capturarYMostrar(Aviso a) {
        this.aviso = a;
        return "verAviso?faces-redirect=true";
    }

    public String capturarYEditar() {
        return "editarAviso?faces-redirect=true";
    }

    public String editarAviso() {
        Supervisor sup = bdl.obtenerSupervisor(aviso.getSupervisor().getId_empl());
        aviso.setSupervisor(sup);
        
        Brigada bri = bdl.obtenerBrigada(aviso.getBrigada().getId_brigada());
        aviso.setBrigada(bri);
        
        List<Diagnostico> diagnosticos_bd = bdl.getDiagnosticos();
        List<Diagnostico> diagnosticos_nuevos = new ArrayList<>();
        for (String d : diagnosticos_id) {
            diagnosticos_nuevos.add(diagnosticos_bd.get(Integer.parseInt(d) - 1));
        }
        aviso.setEsDeTipo(diagnosticos_nuevos);
        
        bdl.modificarAviso(aviso);
        
        return "grid_avisos.xhtml";
    }
    
    public String eliminarAviso() {
        bdl.eliminarAviso(aviso);
        
        return "grid_avisos.xhtml";
    }

    public BaseDeDatosLocal getBdl() {
        return bdl;
    }

    public void setBdl(BaseDeDatosLocal bdl) {
        this.bdl = bdl;
    }

    public String[] getDiagnosticos_id() {
        List<Diagnostico> diagnosticos_aviso = aviso.getEsDeTipo();
        diagnosticos_id = new String [diagnosticos_aviso.size()];
        int index=0;
        for (Diagnostico d : diagnosticos_aviso){
            diagnosticos_id[index] = d.getId_diag().toString();
            index++;
        }
        
        return diagnosticos_id;
    }

    public void setDiagnosticos_id(String[] diagnosticos_id) {
        this.diagnosticos_id = diagnosticos_id;
    }
    
    
}
