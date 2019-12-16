<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel = "stylesheet" type ="text/css" href = "Css/style.css" />
        <link rel="stylesheet" type="text/css" href="Css/iniciarSesion.css"/>
        <link rel="stylesheet" type="text/css" href="Css/Div.css"/>
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
            </div>
            <div class="dashboard-body">
                <div aria-hidden="false" class="dashboard-sidebar">
                    <nav class="component-nav ui-full-height ui-scrollable">
                        <ul class="component-menu component-menu--vertical">
                        </ul>
                    </nav>
                </div>
                <div class="dashboard-content">
                    <div class="page" id="dashboard">
                        <div class="page-header">
                            <h1 class="page-title">Dashboard</h1>
                            <div aria-hidden="false" class="page-actions">
                            </div>
                            <div aria-hidden="false" class="page-filters">
                            </div>
                        </div>
                        <div class="page-body">
                              <div class="wrapper">
                                  <form class="form-signin" action="ProcesoLogin" method="POST">      
                                        <h2 class="form-signin-heading">
                                  Please login</h2>
                                  <input type="text" class="form-control" name="usuario" placeholder="Usuario" required="" autofocus="" />
                                  <input type="password" class="form-control" name="clave" placeholder="Password" required=""/>      

                                  <button class="btn btn-lg btn-primary btn-block" type="submit" name="login">Login</button>   
                                </form>
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