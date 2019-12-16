/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.PreparedStatement;
import dao.Medicion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Daomedicion implements Operaciones{
     Dbconexion db = new Dbconexion();
    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicion> listar() {
       List <Medicion> datos = new ArrayList<>();
       Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblmedicion"; 
       // armar la conexion.
        try {
            Class.forName(db.getDriver());
            // string de conexion.
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            //recorrer el resultSet.
            while(rs.next()){
            // vamos a tener una "fila" del arreglo.
                datos.add(new Medicion(rs.getInt("idMedicion"),rs.getDate("fecha"),rs.getInt("estatura"),rs.getInt("peso"),rs.getInt("medidaCintura"),rs.getInt("PorcentajeGrasaFormula"),
                rs.getInt("imc"),rs.getInt("indiceGrasaInstrumento"), rs.getString("foto"),rs.getString("personausuario"),rs.getString("personaentrenador")));
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
       return datos;
    }

    @Override
    public List<Medicion> listarParametro(String parametro) {
        List <Medicion> datos = new ArrayList<>();
       Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblmedicion where personausuario = '"+parametro+"'"; 
       // armar la conexion.
        try {
            Class.forName(db.getDriver());
            // string de conexion.
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            //recorrer el resultSet.
            while(rs.next()){
            // vamos a tener una "fila" del arreglo.
                datos.add(new Medicion(rs.getInt("idMedicion"),rs.getDate("fecha"),rs.getInt("estatura"),rs.getInt("peso"),rs.getInt("medidaCintura"),rs.getInt("PorcentajeGrasaFormula"),
                rs.getInt("imc"),rs.getInt("indiceGrasaInstrumento"), rs.getString("foto"),rs.getString("personausuario"),rs.getString("personaentrenador")));
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
       return datos;
    }

    @Override
    public String actualizar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String darBaja(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String borrar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
