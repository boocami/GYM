/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Entrenador;
import dao.Medicion;
import dao.Persona;
import dao.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Daoentrenador;
import modelo.Daomedicion;
import modelo.Daopersona;
import modelo.Daousuario;

/**
 *
 * @author HP
 */
@WebServlet(name = "ProcesoUsuario", urlPatterns = {"/ProcesoUsuario"})
public class ProcesoUsuario extends HttpServlet {

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
        Daousuario daousuario = new Daousuario();
        Daomedicion daomedicion = new Daomedicion();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcesoUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcesoUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
           if(request.getParameter("BuscarDatosBajaUsuario")!=null){
               String usuario = request.getParameter("Usuario");
                List<Usuario> datos3 = new ArrayList();
                datos3 = daousuario.listarParametro(usuario);
                request.setAttribute("respuestaDatos", datos3);
                //scope peticion contexto(this), session 
                requestDispatcher = request.getRequestDispatcher("/bajaUsuario.jsp");
                requestDispatcher.forward(request, response);
           }else if(request.getParameter("darDeBaja")!=null){
                               int id;
                String nombre, respuesta;
                id =  2;
                nombre = request.getParameter("Usuariobaja");
                //
                p.setUsuario(nombre);
                p.setIdestado(id);

                respuesta = daopersona.darBaja(p);
                request.setAttribute("respuesta", respuesta);
                requestDispatcher = request.getRequestDispatcher("/bajaUsuario.jsp");
                requestDispatcher.forward(request, response);
           }else if(request.getParameter("buscarUsuario")!=null){
               String usuario =  request.getParameter("Usuario");
               List<Medicion> datos3 = new ArrayList();
               datos3 = daomedicion.listarParametro(usuario);
               out.print(datos3);
                 request.setAttribute("respuestaDatos", datos3);
               requestDispatcher = request.getRequestDispatcher("/visualizarEvaluaciones.jsp");
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
