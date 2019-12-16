<%-- 
    Document   : vistaResultado
    Created on : 14-10-2019, 12:43:06
    Author     : duque
--%>

<%@page import="dao.Profesion"%>
<%@page import="modelo.Daoprofesion"%>
<%@page import="java.util.ArrayList"%> 
<%@page import="java.util.List"%>
<%@page import="dao.Persona"%> <!--CLASE JAVA CON LOS ATRIBUTOS DE PERSONA(LOS DATOS DE PERSONA)-->
<%@page import="modelo.Daopersona"%> <!--METODOS QUE CONTIENEN EL OBJETO PERSONA-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel = "stylesheet" type = "text/css" href = "Css/style.css" />
        <link rel="stylesheet" type="text/css" href="Css/iniciarSesion.css"/>
        <link rel="stylesheet" type="text/css" href="Css/Div.css"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="js/validaciones.js"></script>
    </head>
    <body>
        <div class="dashboard-wrapper">
            <div class="dashboard-header">
                <div class="branding">
                    <a class="" href="#" title="User Menu">
                        <img class="component-image component-image--circle" src="https://placem.at/things?w=40&amp;h=40">
                        <span class="">Administrador</span>
                    </a>
                </div>
                <nav class="component-nav">
                    <ul class="component-menu component-menu--horizontal">
                        <li class="">
                            <form action="ProcesoLogin" method="Post">
                                <button class="button btn btn-lg btn-primary btn-block" name="cerrarSesion">Cerrar Sesion</button>    
                            </form>
                            
                        </li>
                        <li class="">
                            <a class="" href="#">
                                <i class="fa fa-fw fa-cog" title="Settings"></i>
                            </a>
                            <ul aria-hidden="true" class="">
                                <li class="">
                                    <div class="button-group">
                                        <input class="" id="sidebar-hidden">
                                        <label class="" for="sidebar-hidden"></label>
                                        <input class="" id="sidebar-mini">
                                        <label class="" for="sidebar-mini"></label>
                                        <input class="" id="sidebar-full">
                                        <label class="" for="sidebar-full"></label>
                                    </div>
                                </li>
                            </ul>
                        </li>
                    </ul>
                 </nav>
            </div>
            <div class="dashboard-body">
                <div aria-hidden="false" class="dashboard-sidebar">
                    <nav class="component-nav ui-full-height ui-scrollable">
                        <ul class="component-menu component-menu--vertical">
                            <li class="">
                                <a class="" href="registroEntrenador.jsp">
                                <img class="component-image component-image--circle cucha" src="Imagenes/entrenador.png">
                                <span class="registrar-entrenador">
                                <i class="fa fa-fw fa-file"></i>
                                </span>
                                <span class="registarEntrenadoresclick">
                                Registrar entrenadores
                                </span>
                                </a>
                            </li>
                            <li class="">
                                <a class="" href="actualizarEntrenador.jsp">
                                <img class="component-image component-image--circle cucha" src="Imagenes/actualizar.png">
                                <span class="">
                                <i class="fa fa-fw fa-folder"></i>
                                </span>
                                <span class="actualizarEntrenadoresclick">
                                Actualizar entrenadores
                                </span>
                                </a>
                            <li class="">
                                <a class="" href="bajaEntrenador.jsp">
                                <img class="component-image component-image--circle cucha" src="Imagenes/eliminar.png">
                                <span class="">
                                <i class="fa fa-fw fa-globe"></i>
                                </span>
                                <span class="dardeBajaclickEntrenador">
                                    Dar de baja entrenador
                                </span>
                                </a>
                            </li>
                            <li class="">
                                <a class="" href="listaUsuarios.jsp">
                                <img class="component-image component-image--circle cucha" src="Imagenes/usuario.png">
                                <span class="">
                                <i class="fa fa-fw fa-users"></i>
                                </span>
                                <span class="vizualizarUsuarioclick">
                                Visualizar Usuario
                                </span>
                                </a>
                            </li>
                            <li class="">
                                <a class="" href="visualizarEvaluaciones.jsp">
                                      <img class="component-image component-image--circle cucha" src="Imagenes/prueba.png">
                                <span class="">
                                <i class="fa fa-fw fa-cogs"></i>
                                </span>
                                <span class="evaluacionesUsuariosclick">
                                    Evaluaciones de los usuarios
                                </span>
                                </a>
                            </li>
                            <li class="">
                                <a class="" href="bajaUsuario.jsp">
                                <img class="component-image component-image--circle cucha" src="Imagenes/eliminar.png">    
                                <span class="">
                                <i class="fa fa-fw fa-cogs"></i>
                                </span>
                                <span class="darBajaUsuarioclick">
                                    Dar de baja usuarios
                                </span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <div class="dashboard-content">
                <div class="page" id="dashboard">
                    <div class="page-header">
                        <h1 class="page-title">Administrador Fitnnes Club</h1>
                    </div>
                    <div class="page-body">
                        <div class="wrapper">
                            <% Persona persona = ( Persona )request.getSession().getAttribute("persona");
                                if(persona == null){
                                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                                }
                            %>
                            <form method="POST" action="ProcesoEntrenador" class="form-signin">
                                <h2 class="form-signin-heading">Registrar Entrenador</h2>
                                  <br><input type="text" class="form-control espacio" name="usuario" placeholder="Usuario" required="" autofocus="" id="usuario"/>
                                  <br><input type="text" class="form-control espacio" name="nombre" required="" placeholder="Nombre" autofocus="" id="nombre">
                                  <br><input type="text"  class="form-control espacio" name="apellidoPaterno" required="" placeholder="Apellido Paterno" autofocus="" id="apellidopaterno">
                                  <br><input type="text" class="form-control espacio" name="apellidoMaterno" required="" placeholder="Apellido Materno" autofocus="" id="apellidomaterno">
                                   
                                  <%
                                Daoprofesion daoprofesion = new Daoprofesion();
                                List<Profesion> datos1 = new ArrayList();
                                    String resp1;

                                    //guardar lo que retorna el mÃ©todo.
                                    if(request.getAttribute("respuestaDatos") != null){
                                        //listar con parametro, respuestaDatos viene con un List.
                                     datos1 = (List<Profesion>) (request.getAttribute("respuestaDatos"));
                                     int dimension = datos1.size();
                                     out.print("SIZE"+dimension);
                                       if(dimension == 0){
                                       resp1 = "No hay registros";
                                       out.print(resp1);
                                       }
                                    }else{
                                        //listar todo
                                    datos1 = daoprofesion.listar();
                                    }
                                
                                %>
                                  <br><select name="profesion" id="profesion">
                                      <option value="">Seleccione profesion</option>
                                      <%  
                                for(Profesion prof : datos1){
                                      out.print("<option value="+ prof.getIdprofesion()+"> "+prof.getProfesion() +" </option>");                                 
                                  }
                                  %>
                                      </select><br><br>

                                  <input type="clave" class="form-control" name="clave" placeholder="Password" required="" id="clave"/><br>      
                                  <button class="btn btn-lg btn-primary btn-block" type="submit" name="btnInsertar" id="btninsertar">Insertar</button>
                                  <h4>RESPUESTA</h4>
                                                ${respuesta}  
                            </form>
                                        
                        </div>
                        
                            

                        <%
                        Daopersona daopersona = new Daopersona();
                        List<Persona> datos = new ArrayList();// definir la variable para 
                        String resp;

                        //guardar lo que retorna el método.
                        if(request.getAttribute("respuestaDatos") != null){
                            //listar con parametro, respuestaDatos viene con un List.
                         datos = (List<Persona>) (request.getAttribute("respuestaDatos"));
                         int dimension = datos.size();
                           if(dimension == 0){
                           resp = "No hay registros";
                           out.print(resp);
                           }
                        }
                        %>
                        </div>
                    <div class="page-footer">
                        <ul class="pagination"></ul>
                    </div>
                </div>
            </div>
            </div>
        </div>
        
         
    </body>
</html>
