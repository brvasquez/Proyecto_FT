<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilos.css">
<link rel="stylesheet" href="css/estilos.css">

</head>
<body>
    <div class="container">
        <div class="screen">
            <div class="screen__content">
                <form method="post" action="UsuarioController?accion=login" class="login">
                
                <h4>Incio de Sesion</h4>
                    <div class="login__field">
                        <i class="login__icon fas fa-user"></i>
                        <input type="email" class="login__input"  id="correo" name="correo" placeholder="Correo">
                    </div>
                    <div class="login__field">
                        <i class="login__icon fas fa-lock"></i>
                        <input type="password" class="login__input"  id="password" name="password" placeholder="Contraseña">
                    </div>
                    <button class="button login__submit">
                        <span class="button__text">Iniciar Sesion</span>
                        
                        <i class="button__icon fas fa-chevron-right"></i>
                    </button>
                </form>
                <div class="social-login">
                <br>
                    <h3>Friendly Tutor</h3>
                    <a href="UsuarioController?accion=abrirFormRegistro" data-after="Home">Si no tienes cuenta Registrarse</a>
                    <br>

                     <p class="text-center">
	  		<%
	  			if(request.getParameter("msn")!=null){
	  				out.println(request.getParameter("msn"));
	  			}
	  		%>
	  	</p>
                    <div class="social-icons">
                        <a href="#" class="social-login__icon fab fa-instagram"></a>
                        <a href="#" class="social-login__icon fab fa-facebook"></a>
                        <a href="#" class="social-login__icon fab fa-twitter"></a>
                    </div>
                </div>
            </div>
           
            <div class="screen__background">
                <span class="screen__background__shape screen__background__shape4"></span>
                <span class="screen__background__shape screen__background__shape3"></span>
                <span class="screen__background__shape screen__background__shape2"></span>
                <span class="screen__background__shape screen__background__shape1"></span>
            </div>
        </div>
    </div>
</body>


<style>
h4{
    position: center;
    
    width: 160px;
    text-align: center;
    bottom: 0px;
    right: 0px;
    color: #7e7e85;

}
a{
    position: absolute;
    
   
    text-align: center;
    bottom: 0px;
    right: 0px;
    color: #fff;
}
}

</style>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>

</body>
</html>