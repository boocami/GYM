package controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import dao.Entrenador;
import dao.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Daoentrenador;
import modelo.Daopersona;

/**
 *
 * @author HP
 */
@WebServlet(urlPatterns = {"/ProcesoEntrenador"})
public class ProcesoEntrenador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher requestDispatcher;
        response.setContentType("text/html;charset=UTF-8");
        Daoentrenador daoentrenador = new Daoentrenador();
        Persona p = new Persona();
        Daopersona daopersona = new Daopersona();
        Entrenador e = new Entrenador();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcesoEntrenador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcesoEntrenador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            if(request.getParameter("BuscarEntrenador")!= null ){
                String parametro2 = request.getParameter("UsuarioEntrenador");
                List<Entrenador> datos3 = new ArrayList();
                datos3 = daoentrenador.listarParametro(parametro2);
                out.print(datos3.size());
                request.setAttribute("respuestaDatos", datos3);
                //scope peticion contexto(this), session 
                requestDispatcher = request.getRequestDispatcher("/actualizarEntrenador.jsp");
                requestDispatcher.forward(request, response);
            }else if(request.getParameter("btnActualizar")!=null){
                String usuario, respuesta, respuesta2;
                int id, clave;
                usuario = request.getParameter("UsuarioEntrenador");
                id = Integer.parseInt(request.getParameter("profesion"));
                clave = Integer.parseInt(request.getParameter("clave"));
                out.println(usuario);
                out.println(id);
                out.println(clave);
                p.setUsuario(usuario);
                p.setClave(clave);
                e.setUsuario(usuario);
                e.setIdProfesion(id);
                respuesta = daopersona.actualizar(p);
                out.print(respuesta);
request.setAttribute("respuesta", respuesta); 
                requestDispatcher = request.getRequestDispatcher("/actualizarEntrenador.jsp");
                requestDispatcher.forward(request, response);
                

            }else if(request.getParameter("btnInsertar")!= null ){
                String usuario;
                int clave;
                String nombre, apellidoPaterno, apellidoMaterno, respuesta, respuesta1, parametro, respuesta3;

                parametro = request.getParameter("usuario");
                List<Persona> datos = daopersona.listarParametro(parametro);

                int nfilas = datos.size();
                if(nfilas == 0){
                    List<Entrenador> datos2 = daoentrenador.listarParametro(parametro);
                    int nfilas2 = datos2.size();
                    if(nfilas2 == 0){
                        int idProfesion;
                        int idestado = 1;
                        usuario = request.getParameter("usuario");
                        clave = Integer.parseInt(request.getParameter("clave"));
                        nombre =request.getParameter("nombre");
                        apellidoPaterno = request.getParameter("apellidoPaterno");
                        apellidoMaterno = request.getParameter("apellidoMaterno");
                        idProfesion = Integer.parseInt(request.getParameter("profesion"));
                        p.setUsuario(usuario);
                        p.setNombre(nombre);
                        p.setApellidoPaterno(apellidoPaterno);
                        p.setApellidoMaterno(apellidoMaterno);
                        p.setClave(clave);
                        p.setIdestado(idestado);
                        e.setUsuario(usuario);
                        e.setIdProfesion(idProfesion);

                            //  enti, entity, objeto.
                         respuesta = daopersona.insertar(p);
                         request.setAttribute("respuesta", respuesta);
                         respuesta1 = daoentrenador.insertar(e);
                         request.setAttribute("respuesta", respuesta1);
                         //scope peticion contexto(this), session 
                         requestDispatcher = request.getRequestDispatcher("registroEntrenador.jsp");
                         requestDispatcher.forward(request, response);  
                    }
                          
                    }else{
                    respuesta = "Existe entrenador";
                        request.setAttribute("respuesta", respuesta);
                        //scope peticion contexto(this), session 
                        requestDispatcher = request.getRequestDispatcher("registroEntrenador.jsp");
                        requestDispatcher.forward(request, response);
                }
            }else if(request.getParameter("BuscarEntrenadorBaja")!= null ){
                String parametro2 = request.getParameter("UsuarioEntrenador");
                List<Entrenador> datos3 = new ArrayList();
                datos3 = daoentrenador.listarParametro(parametro2);
                request.setAttribute("respuestaDatos", datos3);
                //scope peticion contexto(this), session 
                requestDispatcher = request.getRequestDispatcher("/bajaEntrenador.jsp");
                requestDispatcher.forward(request, response);
            }else if(request.getParameter("darDeBaja")!=null){
                int id;
                String nombre, respuesta;
                id =  2;
                nombre = request.getParameter("UsuarioEntrenadorbaja");
                //
                p.setUsuario(nombre);
                p.setIdestado(id);

                respuesta = daopersona.darBaja(p);
                request.setAttribute("respuesta", respuesta);
                requestDispatcher = request.getRequestDispatcher("/bajaEntrenador.jsp");
                requestDispatcher.forward(request, response);

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
