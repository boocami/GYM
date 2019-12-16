package modelo;

import java.util.List;

public interface Operaciones {
//listado de operaciones que se puede hacer con una tabla.
    public String insertar(Object obj);
    public List<?> listar();
    public List<?> listarParametro(String parametro);
    public String actualizar(Object obj);
    public String darBaja(Object obj);
    public String borrar(Object obj);
 
}
