/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.PreparedStatement;
import dao.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class Daousuario implements Operaciones{
    Dbconexion db = new Dbconexion();
    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> listar() {
       List <Usuario> datos = new ArrayList<>();
       Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblusuario"; 
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
                datos.add(new Usuario(rs.getString("usuario"), rs.getInt("idgenero"), rs.getDate("fechanacimiento"), rs.getDate("fechaingreso")));
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
       return datos;
    }

    @Override
    public List<Usuario> listarParametro(String parametro) {
               List <Usuario> datos = new ArrayList<>();
        Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblusuario Where usuario='"+parametro+"'";
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
                datos.add(new Usuario(rs.getString("usuario"), rs.getInt("idgenero"), rs.getDate("fechanacimiento"), rs.getDate("fechaingreso")));
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
