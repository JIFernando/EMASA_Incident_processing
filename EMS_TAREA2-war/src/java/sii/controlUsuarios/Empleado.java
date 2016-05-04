/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sii.controlUsuarios;

import java.util.Date;

/**
 *
 * @author JenniferAdmin
 */
public class Empleado {

    protected Integer id_empl;
    private String nombre;
    private String apellido1, apellido2;
    private String password;
    private Date inic_cont, fin_cont;
    private String tipo_horario;
    private Long salario;

    public enum Rol {
        SUPERVISOR,
        NORMAL
    };

    private Rol rol;

    public Empleado(Integer id_empl, String nombre, String apellido1, String apellido2, String password, Date inic_cont, Date fin_cont, String tipo_horario, Long salario, Rol rol) {
        this.id_empl = id_empl;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.password = password;
        this.inic_cont = inic_cont;
        this.fin_cont = fin_cont;
        this.tipo_horario = tipo_horario;
        this.salario = salario;
        this.rol = rol;
    }

    public Integer getId_empl() {
        return id_empl;
    }

    public void setId_empl(Integer id_empl) {
        this.id_empl = id_empl;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getInic_cont() {
        return inic_cont;
    }

    public void setInic_cont(Date inic_cont) {
        this.inic_cont = inic_cont;
    }

    public Date getFin_cont() {
        return fin_cont;
    }

    public void setFin_cont(Date fin_cont) {
        this.fin_cont = fin_cont;
    }

    public String getTipo_horario() {
        return tipo_horario;
    }

    public void setTipo_horario(String tipo_horario) {
        this.tipo_horario = tipo_horario;
    }

    public Long getSalario() {
        return salario;
    }

    public void setSalario(Long salario) {
        this.salario = salario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

}
