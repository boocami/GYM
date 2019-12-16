<%-- 
    Document   : bajaEntrenador
    Created on : 18-11-2019, 23:05:12
    Author     : Usuario
--%>

<%@page import="modelo.Daousuario"%>
<%@page import="dao.Entrenador"%>
<%@page import="modelo.Daoentrenador"%>
<%@page import="dao.Profesion"%>
<%@page import="modelo.Daoprofesion"%>
<%@page import="modelo.Daopersona"%>
<%@page import="modelo.Daopersona"%>
<%@page import="dao.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.Persona"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
                                <% Persona persona = ( Persona )request.getSession().getAttribute("persona");
                                if(persona == null){
                                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                                }
                            %>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel = "stylesheet" type = "text/css" href = "Css/style.css" />
        <link rel="stylesheet" type="text/css" href="Css/iniciarSesion.css"/>
        <link rel="stylesheet" type="text/css" href="Css/Div.css"/>
                <script type="text/javascript" src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="js/validaciones.js"></script>
    </head>
    <body translate="no">
        <div class="dashboard-wrapper">
            <div class="dashboard-header">
                <div class="branding">
                    <a class="" href="#" title="User Menu">
                        <img class="component-image component-image--circle" src="https://placem.at/things?w=40&amp;h=40">
                        <span class="">Administrador Fitness</span>
                    </a>
                </div>
                <nav class="component-nav">
                    <ul class="component-menu component-menu--horizontal">
                        <li class="">
                            <a class="" href="#" title="User Menu">
                                                    <form action="ProcesoLogin" method="Post">
                                <button class="button btn btn-lg btn-primary btn-block" name="cerrarSesion">Cerrar Sesion</button>    
                            </form>        
                            </a>
                            <ul aria-hidden="true" class="">
                                <li class="">
                                    <a class="" href="#">
                                    Settings
                                    </a>
                                </li>
                                <li class="">
                                    <a class="" href="#">
                                    Logout
                                    </a>
                                </li>
                            </ul>   
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
                                                      <div class="wrapper 2"  id="wrapper2">
                                <form class="form-signin" method="POST" action="ProcesoUsuario">
                                  <h2 class="form-signin-heading">Dar de baja Usuario</h2>
                                  <h3>Buscar usuario por Nick</h3>
                                  <input type="text" name="Usuario" placeholder="Nick Usuario" required="" autofocus="" class="form-control" id="usuario">
                                  <button class="btn btn-lg btn-primary btn-block" type="submit" name="BuscarDatosBajaUsuario" id="buscarusuario">Buscar</button>       
                                                                      ${respuesta}
                                </form>
                                    <%
                                   Daousuario daousuario = new Daousuario();
                                   List<Usuario> datos = new ArrayList();
                                    String resp;

                                    //guardar lo que retorna el método.
                                    if(request.getAttribute("respuestaDatos") != null){
                                        //listar con parametro, respuestaDatos viene con un List.
                                     datos = (List<Usuario>) (request.getAttribute("respuestaDatos"));
                                     int dimension = datos.size();
                                       if(dimension == 0){
                                       resp = "No hay registros";
                                       out.print(resp);
                                       }
                                    }
                                    
                                    %>
                                       <% if(datos.size()!= 0){
                                    for(Usuario usuario : datos){
                                    %>
                            <form class="form-signin" method="POST" action="ProcesoUsuario" >
                                <div class="wrapper">
                                    <input type="text" name="Usuariobaja" value ="<%=  usuario.getUsuario() %>" placeholder="Nick Entrenador" required="" autofocus="" class="form-control">
<%
                                    }
                                    }                                    %>   
                                   <button class="btn btn-lg btn-primary btn-block" type="submit" name="darDeBaja">Dar de baja</button>   

                                </div>
                            </form>
                               
                                <%
                                     Daopersona daopersona = new Daopersona();
                                                                     
                                    List<Persona> datos2 = new ArrayList();
                                    String resp2;

                                    //guardar lo que retorna el método.
                                    if(request.getAttribute("respuestaDatos") != null){
                                        //listar con parametro, respuestaDatos viene con un List.
                                     datos2 = (List<Persona>) (request.getAttribute("respuestaDatos"));
                                     int dimension = datos2.size();
                                       if(dimension == 0){
                                       resp2 = "No hay registros";
                                       out.print(resp2);
                                       }
                                    }
                                %>
                            </div>
                    </div>
 
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