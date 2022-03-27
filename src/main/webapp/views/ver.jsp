

<link rel="stylesheet" href="css/soli.css" >
<link rel="stylesheet" href="soli.css" >

	<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.min.css">

	<script type="text/javascript" src="https://cdn.jsdelivr.net/gh/mobius1/vanilla-Datatables@latest/vanilla-dataTables.min.js"></script>


<body>

 <div class="theme-toggle">
	    <h2></h2>
	    <label class="switch">
	      <input type="checkbox" onclick="switchTheme()" >
	      <span class="slider"></span>
	    </label>
  </div>
  
  <div class="login-box">
    <h2>Hola, ${us.nombreUsuario} ${us.apellidoUsuario} ${us.correoUsuario}</h2>
    	<br>
    	<p>Escogiste la tutoria  ${tutorias.nombre}, con el Tutor ${tutorias.usuario}, con la descripción que dice : ${tutorias.descripcion},
    	si desea confirmar la solicitud haga click en el boton Confirmar Solicitud</p>
    	
    	
    	
    <form method="post" action="SolicitudController?accion=add">
      <input type="hidden" readonly class="" name="id" id="id" placeholder="" value="${tutorias.idTutoria}"/>
       
      <input type="hidden" readonly class="" name="nombre" id="nombre" placeholder="Nombre Tutoria" value="${tutorias.nombre}"/>
        
      <input type="hidden" readonly class="" name="descripcion" id="descripcion" placeholder="Ingrese la descripción" value="${tutorias.descripcion}"/>
        
      <input type="hidden" readonly class="" name="usuario" id="usuario" placeholder="Ingrese usuario" value="${tutorias.usuario}"/>
      <input type="hidden" readonly class="" name="estudianteSolicitante" id="usuario" placeholder="Ingrese usuario" value="${us.nombreUsuario} ${us.apellidoUsuario} "/>
      <input type="hidden" readonly class="" name="correo" id="correo" placeholder="correo" value="${us.correoUsuario}"/>
      <input type="hidden" readonly class="" name="descripcionSolicitud" id="descripcionSolicitud" placeholder="correo" value=""/>
      <input type="hidden" readonly class="" name="rolEstudiante" id="rolEstudiante" placeholder="Ingrese usuario" value=" ${us.rolUs.descripcionRol}"/>
     
      
      <div class="">
		  <input class="" type="hidden"    name="chkEstado" id="chkEstado" >
		  
		  <label class=""  for="flexCheckChecked">
		    ${tutorias.estado==true ? '':''}
		  </label>
	  
	 </div>
	 
	 <br>
	 <br>
      
      <button type="submit" role="button" id="">Confirmar Solicitud</button>
    </form>
  </div>

<script>
</script>
<style>
body {
  font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif; 
 
}

element.style {
    background: url() left top no-repeat rgba(0 61 123 / 40%);
    overflow-y: auto;
}
}
</style>
<script>
Swal.fire({
	  title: 'Lee y confirma tu solicitud.',
	  width: 600,
	  padding: '3em',
	  color: '#63c4ff',
	  background: '#fff url(https://img.freepik.com/foto-gratis/textura-papel-tapiz-color-blanco-gris-fondo_74190-12612.jpg?size=626&ext=jpg)',
	  backdrop: `
	    rgba(0 61 123 / 40%)
	    url("")
	    left top
	    no-repeat
	  `
	})
	
</script>





<script src="js/solijs.js"></script>
<script src="solijs.js"></script>
