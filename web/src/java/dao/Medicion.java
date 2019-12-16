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
public class Medicion {
    private int idMedicion;
    private Date fecha;
    private int estatura, peso, medidaCintura, PorcentajeGrasaFormula, imc, indiceGrasaInstrumento;
    private String foto, personausuario, personaentrenador;

    public Medicion() {
    }

    public Medicion(int idMedicion, Date fecha, int estatura, int peso, int medidaCintura, int PorcentajeGrasaFormula, int imc, int indiceGrasaInstrumento, String foto, String personausuario, String personaentrenador) {
        this.idMedicion = idMedicion;
        this.fecha = fecha;
        this.estatura = estatura;
        this.peso = peso;
        this.medidaCintura = medidaCintura;
        this.PorcentajeGrasaFormula = PorcentajeGrasaFormula;
        this.imc = imc;
        this.indiceGrasaInstrumento = indiceGrasaInstrumento;
        this.foto = foto;
        this.personausuario = personausuario;
        this.personaentrenador = personaentrenador;
    }

    public int getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getMedidaCintura() {
        return medidaCintura;
    }

    public void setMedidaCintura(int medidaCintura) {
        this.medidaCintura = medidaCintura;
    }

    public int getPorcentajeGrasaFormula() {
        return PorcentajeGrasaFormula;
    }

    public void setPorcentajeGrasaFormula(int PorcentajeGrasaFormula) {
        this.PorcentajeGrasaFormula = PorcentajeGrasaFormula;
    }

    public int getImc() {
        return imc;
    }

    public void setImc(int imc) {
        this.imc = imc;
    }

    public int getIndiceGrasaInstrumento() {
        return indiceGrasaInstrumento;
    }

    public void setIndiceGrasaInstrumento(int indiceGrasaInstrumento) {
        this.indiceGrasaInstrumento = indiceGrasaInstrumento;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getPersonausuario() {
        return personausuario;
    }

    public void setPersonausuario(String personausuario) {
        this.personausuario = personausuario;
    }

    public String getPersonaentrenador() {
        return personaentrenador;
    }

    public void setPersonaentrenador(String personaentrenador) {
        this.personaentrenador = personaentrenador;
    }
    
}
