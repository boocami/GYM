$(document).ready(function(){
    console.log("Se cargo la pagina");
    $("#botonbuscar").click(function(){
        console.log("Entre al click")
        var nickEntrenador=$('#nombreusuario').val(); 
        console.log(nickEntrenador);
        if(nickEntrenador == null || nickEntrenador == "" || nickEntrenador == 0){
            alert ("DEBE  INGRESAR Nick del Entrenador....");
            console.log("Estamos aqui");
            return false;
        }
    });
    $('#btnactualizar').click(function(){
        var idprofesion = $('#idprofesion').val();
        var clave = $('#clave').val();
        if(idprofesion == 0){
            alert ("DEBE SELECIONAR UNA PROFESION");
            console.log("Estamos aqui");
            return false;
        }else if(clave == null || clave == ""|| clave == 0){
            alert ("DEBE INGRESAR CLAVE");
            console.log("Estamos aqui");
            return false;
        }  
    });
    $('#btninsertar').click(function(){
        var usuario = $('#usuario').val();
        var nombre = $('#nombre').val();
        var apellidop = $('#apellidopaterno').val();
        var apellidom = $('#apellidomaterno').val();
        var clave = $('#clave').val();
        if(usuario == null || usuario == "" || usuario == 0){
             alert ("DEBE  INGRESAR Nick del Entrenador....");
            console.log("Estamos aqui");
            return false;
        }else if(nombre == null || nombre == "" || nombre == 0){
             alert ("DEBE  INGRESAR nombre del Entrenador....");
            console.log("Estamos aqui");
            return false;
        }else if(apellidop == null || apellidop == "" || apellidop == 0){
             alert ("DEBE  INGRESAR apellido paterno del Entrenador....");
            console.log("Estamos aqui");
            return false;
        }else if(apellidom == null || apellidom == "" || apellidom == 0){
             alert ("DEBE  INGRESAR apellido materno del Entrenador....");
            console.log("Estamos aqui");
            return false;
        }else if(clave == null || clave == "" || clave == 0){
             alert ("DEBE  INGRESAR clave del Entrenador....");
            console.log("Estamos aqui");
            return false;
        }
    });
    
    $('#btnbuscarregistro').click(function(){
       var usuario = $('#usuarioregistro').val();
       if(usuario == null || usuario == "" || usuario == 0){
             alert ("DEBE  INGRESAR Nick del Entrenador....");
            console.log("Estamos aqui");
            return false;
       }    
            
    });
    
    $('#buscarusuario').click(function(){
        var usuario = $('#usuario').val();
               if(usuario == null || usuario == "" || usuario == 0){
             alert ("DEBE  INGRESAR DEL USUARIO....");
            console.log("Estamos aqui");
            return false;
       }
    });
});