//Dao persona contendrá el crud para la tabla persona.
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import dao.Persona;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duque
 */
public class Daopersona implements Operaciones{
    Dbconexion db = new Dbconexion();
    @Override
    public String insertar(Object obj) {
        //variable de retorno.
        String respuesta = "";
        Persona persona = (Persona) obj;
        //creamos el acceso a la base de datos, usamos la libreria del driver.
        Connection con;
        PreparedStatement pst;
        String query = "INSERT INTO tblpersona VALUES (?,?,?,?,?,?)";
        
        //luego de crear las variables, accedemos a la base de datos.
        //como hay manejo de la base de datos, debemos try catch.
        try {
            Class.forName(db.getDriver()); //recupero el Driver.
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            //luego de tener todo preparado, cargamos con los valores.
             pst.setString(1,persona.getUsuario());
             pst.setString(2, persona.getNombre());
             pst.setString(3, persona.getApellidoPaterno());
             pst.setString(4, persona.getApellidoMaterno());
             pst.setInt(5, persona.getClave());
             pst.setInt(6,persona.getIdestado());
             
             
             int nfilas = pst.executeUpdate();
            
            con.close();
            
            if(nfilas > 0){
            respuesta = "SE HA INSERTADO PERSONA CON EXITO";
            }else{
            respuesta = "Error al insertar";
            }
            
            
        } catch ( ClassNotFoundException | SQLException e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    }    

    @Override
    public List<Persona> listar() {       
    List<Persona> datos = new ArrayList<>();// variable para cargar los datos del select.
       Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblpersona"; 
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
                datos.add(new Persona(rs.getString("usuario"),rs.getString("nombre"), rs.getString("apellidopaterno"), rs.getString("apellidomaterno"),rs.getInt("clave"), rs.getInt("idestado"))); /*Editar esto*/
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
        
        return datos;       

    }

    @Override
    public List<Persona> listarParametro(String parametro) {

       List<Persona> datos = new ArrayList<>();// variable para cargar los datos del select.
       Connection con;
       PreparedStatement pst;
       ResultSet rs;// Result Set permite recorrer el arreglo.
       String query = "SELECT * FROM tblpersona WHERE usuario='"+parametro+"'";//id='"+parametro+"'"; para cadena
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
                datos.add(new Persona(rs.getString("usuario"), rs.getString("nombre"), rs.getString("apellidopaterno"), rs.getString("apellidomaterno"),rs.getInt("clave"), rs.getInt("idestado")));
            }
        } catch (ClassNotFoundException | SQLException e) {
           String error =  e.getMessage();
        }
        
        return datos;  
    }

    @Override
    public String actualizar(Object obj) {

       String respuesta = "";
       Persona p = (Persona) obj;
       
        Connection con;
        PreparedStatement pst;
        String query = "UPDATE tblpersona SET clave = ?  WHERE usuario = ?";
       
        try {
            Class.forName(db.getDriver()); //recupero el Driver.
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            //luego de tener todo preparado, cargamos con los valores.
            pst.setInt(1, p.getClave());
            pst.setString(2, p.getUsuario());
            int nfilas = pst.executeUpdate();
            con.close();
            
            if(nfilas > 0){
            respuesta = "Registro actualizado con exito";
            }else{
            respuesta = "Error al actualizar";
            }
            
            
        } catch ( ClassNotFoundException | SQLException e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    }

    @Override
    public String borrar(Object obj) {
Persona p = (Persona) obj;
        String respuesta = "";
        Connection con;
        PreparedStatement pst;
        String query = "delete from tblpersona where usuario = ?";
       
        try {
            Class.forName(db.getDriver()); //recupero el Driver.
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            //luego de tener todo preparado, cargamos con los valores.
            pst.setString(1, p.getUsuario());
            int nfilas = pst.executeUpdate();
            con.close();
            
            if(nfilas > 0){
            respuesta = "Registro eliminado con exito";
            }else{
            respuesta = "Error al eliminar";
            }
            
            
        } catch ( ClassNotFoundException | SQLException e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    }

    @Override
    public String darBaja(Object obj) {
       String respuesta = "";
       Persona p = (Persona) obj;
       
        Connection con;
        PreparedStatement pst;
        String query = "UPDATE tblpersona SET idestado = ? WHERE usuario = ?";
       
        try {
            Class.forName(db.getDriver()); //recupero el Driver.
            con = (Connection) DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getClave());
            pst = (PreparedStatement) con.prepareStatement(query);
            //luego de tener todo preparado, cargamos con los valores.
            pst.setInt(1, p.getIdestado());
            pst.setString(2, p.getUsuario());
            int nfilas = pst.executeUpdate();
            con.close();
            
            if(nfilas > 0){
            respuesta = "Registro actualizado con exito";
            }else{
            respuesta = "Error al actualizar";
            }
            
            
        } catch ( ClassNotFoundException | SQLException e) {
            respuesta = e.getMessage();
        }
        return respuesta;
    
    }
}


