/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.Profesion;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HP
 */
public class Daoprofesion implements Operaciones{
    Dbconexion db = new Dbconexion();
    @Override
    public String insertar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Profesion> listar() {
       List<Profesion> datos = new ArrayList<>();// variable para cargar los datos del select.
       Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblprofesion"; 
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
                datos.add(new Profesion(rs.getInt("idprofesion"),rs.getString("nombreprofesion"))); /*Editar esto*/
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
        
        return datos;       

    }

    @Override
    public List<?> listarParametro(String parametro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
