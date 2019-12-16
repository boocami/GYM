/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Usuario {
	
    private String usuario;
    private int idgenero;
    private Date fechanacimiento, fechaingreso;

    public Usuario() {
    }

    public Usuario(String usuario, int idgenero, Date fechanacimiento, Date fechaingreso) {
        this.usuario = usuario;
        this.idgenero = idgenero;
        this.fechanacimiento = fechanacimiento;
        this.fechaingreso = fechaingreso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }
    
}
