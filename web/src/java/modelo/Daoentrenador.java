/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.PreparedStatement;
import dao.Entrenador;
import dao.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Daoentrenador implements Operaciones {
    Dbconexion db = new Dbconexion();

    @Override
    public String insertar(Object obj) {
        String respuesta = "";
        Entrenador entrenador = (Entrenador) obj;
        Connection con;
        PreparedStatement pst;
        String query = "INSERT INTO tblentrenador VALUES (?,?)";
        try {
            Class.forName(db.getDriver()); //recupero el Driver.
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            //luego de tener todo preparado, cargamos con los valores.
             pst.setString(1,entrenador.getUsuario());
             pst.setInt(2, entrenador.getIdProfesion());
            
             
             int nfilas = pst.executeUpdate();
            
            con.close();
            
            if(nfilas > 0){
            respuesta = "SE HA INSERTADO ENTRENADOR CON EXITO";
            }else{
            respuesta = "Error al insertar";
            }
            
            
        } catch ( ClassNotFoundException | SQLException e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    }

    @Override
    public List<Entrenador> listar() {
        List<Entrenador> datos = new ArrayList<>();
       Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblentrenador"; 
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
                datos.add(new Entrenador(rs.getString("usuario"), rs.getInt("idprofesion")));
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
        
        return datos;
    }

    @Override
    public List<Entrenador> listarParametro(String parametro) {
       List<Entrenador> datos = new ArrayList<>();// variable para cargar los datos del select.
       Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblentrenador WHERE usuario='"+parametro+"'";//id='"+parametro+"'"; para cadena
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
                datos.add(new Entrenador(rs.getString("usuario"), rs.getInt("idprofesion")));
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
        
        return datos;  
    }

    @Override
    public String actualizar(Object obj) {
       String respuesta = "";
       Entrenador entrenador = (Entrenador) obj;
       
        Connection con;
        PreparedStatement pst;
        String query = "UPDATE tblentrenador SET idprofesion = ? WHERE  usuario = ? ";
       
        try {
            Class.forName(db.getDriver()); //recupero el Driver.
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            //luego de tener todo preparado, cargamos con los valores.
            pst.setInt(1, entrenador.getIdProfesion());
            pst.setString(2, entrenador.getUsuario());
            int nfilas = pst.executeUpdate();
            con.close();
            
            if(nfilas > 0){
            respuesta = "Se ha actualizado con exito";
            }else{
            respuesta = "Error al actualizar";
            }
            
            
        }catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
        return respuesta;       
        }

    @Override
    public String borrar(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String darBaja(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
