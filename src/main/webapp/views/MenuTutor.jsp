<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-control", "no-cache,no-store,must-revalidate");
response.setDateHeader("Expires",0);

if(session.getAttribute("us")!=null){

%>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

<script src="https://kit.fontawesome.com/4a02ae2b25.js" crossorigin="anonymous"></script>
      
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.min.css">

<script type="text/javascript" src="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.min.js"></script>
<link rel="stylesheet" href="assets/css/my-task.style.min.css">


<link rel="stylesheet" href="css/style.css" >
<link rel="stylesheet" href="style.css" >

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">

    <!--Estilo Iconos MATERIAL ICONS-->
 <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
</head>
<body>
<div class="container2">
        <aside>
            <div class="top">
                <div class="logo">
                    <img src="img/logo3.png" alt="">
                    <h2>Frienly <span class="primary"> Tutor</span> </h2>
                    
                </div>
                <div class="close" id="close-btn">
                    <span class="material-icons-sharp"> close</span>
                </div>
            </div>

            <div class="sidebar">
                <a href="#">
                    <span class="material-icons-sharp">dashboard</span>
                    <h3>Menu Tutor</h3>
                </a>
              <a href="UsuarioController?accion=editunicoTutor">
                    <span class="material-icons-sharp">receipt_long</span>
                    <h3>Ver Peril</h3>
                </a>
                <a href="UsuarioController?accion=openPassTutor">
                    <span class="material-icons-sharp">insights</span>
                    <h3>Cambio de contraseña</h3>
                </a>
               
                <a href="TutoriaController?accion=listarTutorias">
                    <span class="material-icons-sharp">inventory</span>
                    <h3>Tutorias</h3>
                </a>
               
                <a href="SolicitudController?accion=listarSolicitudes">
                    <span class="material-icons-sharp">inventory</span>
                    <h3>Solicitud</h3>
                </a>
                 <a href="SolicitudEnviadaController?accion=listarSolicitudesTutorCorreo">
                    <span class="material-icons-sharp">inventory</span>
                    <h3>Solicitudes Enviadas</h3>
                </a>
                 <a href="TutoriaController?accion=listarMenu">
                    <span class="material-icons-sharp">inventory</span>
                    <h3>Ver tutorias publicadas</h3>
                </a>
                <a href="MaterialApoyoController?accion=listarMaterial">
                    <span class="material-icons-sharp">inventory</span>
                    <h3>Material de Apoyo</h3>
                </a>
                
                <a href="MaterialApoyoController?accion=listarMaterialPublicado">
                    <span class="material-icons-sharp">inventory</span>
                    <h3>Material de Apoyo Publicado</h3>
                </a>
                
                <a href="UsuarioController?accion=logout">
                    <span class="material-icons-sharp">logout</span>
                    <h3>Cerrar Sesion</h3>
                </a>
            </div>
        </aside>
        
        <div class="right">
            <div class="top">
                <button id="menu-btn">
                    <span class="material-icons-sharp"> menu</span>
                </button>
                <div class="theme-toggler">
                    <span class="material-icons-sharp active">light_mode</span>
                    <span class="material-icons-sharp">dark_mode</span>
                </div>
                <div class="profile">
                    <div class="info">
                        <p>Hola, <b>${us.nombreUsuario} ${us.apellidoUsuario} </b></p>
                        <small class="text-muted"><b>${us.rolUs.descripcionRol}</b></small>
                    </div>
                    <div class="profile-photo">
                        <img src="img/xd.jpg">
                    </div>
                </div>
            </div>



<% 
}else{

request.getRequestDispatcher("").forward(request,response);
}%>