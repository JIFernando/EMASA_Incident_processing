/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.controlUsuarios;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "login")
@RequestScoped
public class Login {

    private String usuario;
    private String contrasenia;
    private List<Empleado> empleados;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
    @Inject
    private ControlAutorizacion ctrl;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        empleados = new ArrayList<>();
        empleados.add(new Empleado(1, "pepe", "apellido1", "apellido2", "asdf", null, null, null, null, Empleado.Rol.NORMAL));
        empleados.add(new Empleado(2, "manolo", "apellido1", "apellido2", "qwer", null, null, null, null, Empleado.Rol.SUPERVISOR));
    }

    public String autenticar() {
        if (!usuarioCorrecto()) {
            FacesContext ctx = FacesContext.getCurrentInstance();
            ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario o contraseña incorrecto", "El usuario o contraseña incorrecto"));
            System.out.println("Usuario incorrecto");
        }

        return ctrl.home();

    }

    private boolean usuarioCorrecto() {
        boolean encontrado = false;
        int i = 0;
        while (!encontrado && i < empleados.size()) {
            if (usuario.equals(empleados.get(i).getNombre()) && comprobarContrasenia(i)) {
                encontrado = true;
                ctrl.setEmpleado(empleados.get(i));
            }
            i++;
        }
        return encontrado;
    }

    private boolean comprobarContrasenia(int i) {
        return (empleados.get(i).getPassword().equals(contrasenia));
    }

}
