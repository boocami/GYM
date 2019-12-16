/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Usuario
 */
public class Entrenador {
    private String usuario;
    private int idProfesion;

    public Entrenador(String usuario, int idProfesion) {
        this.usuario = usuario;
        this.idProfesion = idProfesion;
    }

    public Entrenador() {
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getIdProfesion() {
        return idProfesion;
    }

    public void setIdProfesion(int idProfesion) {
        this.idProfesion = idProfesion;
    }
    
}
