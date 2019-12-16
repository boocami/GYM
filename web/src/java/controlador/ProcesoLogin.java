/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "ProcesoLogin", urlPatterns = {"/ProcesoLogin"})
public class ProcesoLogin extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProcesoLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcesoLogin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
                        if(request.getParameter("login")!=null){
                String usuario = request.getParameter("usuario"); 
                String nombre = "Fernando"; 
                String apellidoPaterno = "Gutierrez";
                String apellidoMaterno = "Kantal";
                int clave = Integer.parseInt(request.getParameter("clave"));
                int idestado = 1;
                String usuarioadmin = "admin";
                int claveadmin = 123;
                if(usuarioadmin.equalsIgnoreCase(usuario)){
                    if(claveadmin == clave){
                        //instanciar clase Persona.
                        Persona persona = new Persona(usuario, nombre, apellidoPaterno, apellidoMaterno, clave, idestado);
                        //creamos una variable de sesion con un objeto persona.
                        request.getSession().setAttribute("persona", persona); 
                //enviar a la vista con RequestDispatcher y ejecutar con forward.
                request.getRequestDispatcher("/registroEntrenador.jsp").forward(request, response);
                    }else{
                        out.print("Usuario o clave incorrecata");
                    }
                }else{
                    out.print("Usuario o clave incorrecata");
                }
            }else if("cerrarSesion"!=null){
                HttpSession session = request.getSession();
                session.removeAttribute("persona");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
                
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
