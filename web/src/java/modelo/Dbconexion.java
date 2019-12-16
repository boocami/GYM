/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author duque
 */
public class Dbconexion {
    //credencial de conexion a MySQL.
    private String driver;
    private String url;
    private String usuario;
    private String clave;

    public Dbconexion() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/bdgym";
        this.usuario = "root";
        this.clave = "";
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
    
    
    
    
    
    
    
}
