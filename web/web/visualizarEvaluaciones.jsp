<%-- 
    Document   : administracion
    Created on : 27-11-2019, 12:03:21
    Author     : HP
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="dao.Medicion"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Daomedicion"%>
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
        <script type="text/javascript" src="showDiv.js"></script>
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
                 <nav class="component-nav">
                    <ul class="component-menu component-menu--horizontal">
                        <li class="">
                            <button class="button" onclick="location.href='iniciarSesion.html'">Iniciar Sesión</button>
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
                                  <h2 class="form-signin-heading">Visualizar Evaluaciones</h2>
                                  <h3>Buscar usuario por Nick</h3>
                                  <input type="text" name="Usuario" placeholder="Nick Usuario" required="" autofocus="" class="form-control" id="usuario"/>
                                  <button class="btn btn-lg btn-primary btn-block" type="submit" id="buscarusuario">Buscar</button>        
                                </form>
                                ${respuesta}    
    <h2 style="color: #fff">Listado de Mediciones</h2>
    
    <%
    Daomedicion daomedicion = new Daomedicion();
    List<Medicion> datos = new ArrayList();// definir la variable para 
    String resp;
   
    //guardar lo que retorna el mÃ©todo.
    if(request.getAttribute("respuestaDatos") != null){
        //listar con parametro, respuestaDatos viene con un List.
     datos = (List<Medicion>) (request.getAttribute("respuestaDatos"));
     int dimension = datos.size();
       if(dimension == 0){
       resp = "No hay registros";
       out.print(resp);
       }
    }else{
        //listar todo
    datos = daomedicion.listar();

    }
        %>
       
                             <div class="wrapper 4" id="wrapper4" style="background-color: #fff">
                                    <div class="divTable" style="border: 2px solid #000;" >
                                        <div class="divTableBody">
                                            <div class="divTableRow">
                                                <div class="divTableCell">Id Medicion</div>
                                                <div class="divTableCell">Usuario</div>
                                                <div class="divTableCell">Entrenador</div>
                                                <div class="divTableCell">Estatura</div>
                                                <div class="divTableCell">Peso</div>
                                                <div class="divTableCell">Medida cintura</div>
                                                <div class="divTableCell">Porcentaje grasa formula</div>
                                                <div class="divTableCell">Imc</div>
                                                <div class="divTableCell">Indice grasa instrumento;</div>
                                                <div class="divTableCell">Foto</div>
                                                <div class="divTableCell">Fecha</div>
                                            </div>
                                            <%
        for(Medicion m : datos){
        %>

                                            <div class="divTableRow">
                                                <div class="divTableCell"><%=  m.getIdMedicion()%></div>
                                                <div class="divTableCell"><%=m.getPersonausuario()%></div>
                                                <div class="divTableCell"><%=m.getPersonaentrenador()%></div>
                                                <div class="divTableCell"><%=m.getEstatura()%></div>
                                                <div class="divTableCell"><%=m.getPeso()%></div>
                                                <div class="divTableCell"><%=m.getMedidaCintura()%></div>
                                                <div class="divTableCell"> <%=m.getPorcentajeGrasaFormula()%></div>
                                                <div class="divTableCell"><%=m.getImc()%></div>
                                                <div class="divTableCell"><%=m.getIndiceGrasaInstrumento()%></div>
                                                <div class="divTableCell"> <%=m.getFoto()%></div>
                                                <div class="divTableCell"> <%=m.getFecha()%></div>
                                            </div>
                                                    <%
        }

        %>
        
                                        </div>
                                    </div>
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