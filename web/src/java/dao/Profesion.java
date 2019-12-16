/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author HP
 */
public class Profesion {
    private int idprofesion;
    private String profesion;

    public Profesion() {
    }

    public Profesion(int idprofesion, String profesion) {
        this.idprofesion = idprofesion;
        this.profesion = profesion;
    }

    public int getIdprofesion() {
        return idprofesion;
    }

    public void setIdprofesion(int idprofesion) {
        this.idprofesion = idprofesion;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
}
