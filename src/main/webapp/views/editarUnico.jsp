<%@include file="header.jsp" %>
<div class="container-sm grow-4 ms-4">
<div class="text-center">
<h3>Editar Usuario</h3>
</div>



<div class="container">
	<form method="post" action="UsuarioController?accion=editunico">
  	
  	<div class="form-group">
  		
  		<input  type="hidden" name="id" id="id" value="${usuarios.idUsuario}">
  	</div>
  	
  	<div class="form-group">
  		
  		<input name="tipoDocUsuario" type="hidden"  id="tipoDocUsuario" value="${usuarios.tipoDocUsuario}">
  			
  	</div>
  	
  	<div class="form-group">
  		
  		<input class="form-control" type="hidden" name="noDocUsuario" placeholder="Ingrese el número de documento" id="noDocUsuario" value="${usuarios.noDocUsuario}">
  	</div>
  	<br>
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input class="form-control" type="text" name="nombreUsuario" placeholder="Ingrese el nombre del usuario" id="nombreUsuario" value="${usuarios.nombreUsuario}">
  	</div>
  	<br>
  	<div class="form-group">
  		<label for="apellido">Apellido</label>
  		<input class="form-control" type="text" name="apellidoUsuario" placeholder="Ingrese el apellido del usuario" id="apellidoUsuario" value="${usuarios.apellidoUsuario}">
  	</div>
  	
  	<div class="form-group">
  		
  		<input class="form-control" type="hidden" name="direccionUsuario" placeholder="Ingrese la dirección del usuario" id="direccionUsuario" value="${usuarios.direccionUsuario}">
  	</div>
  	
  	<div class="form-group">
  	
  		<input class="form-control" type="hidden" name="telefonoUsuario" placeholder="Ingrese el telefono del usuario" id="telefonoUsuario" value="${usuarios.telefonoUsuario}">
  	</div>
  	<br>
  	<div class="form-group">
  		<label for="correo">Correo</label>
  		<input class="form-control" type="text"  name="correoUsuario" placeholder="Ingrese el correo del usuario" onchange="verifyCorreo()" id="correoUsuario" value="${usuarios.correoUsuario}">
  	</div>
  	
  	
  	<div class="form-group">
  		
  		<input class="form-control" type="hidden" name="passwordUsuario" placeholder="Ingrese el password del usuario" id="passwordUsuario" value="${usuarios.passwordUsuario}">
  	</div>
  	
  	
  	
 
<br>
<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>
	
</div>


</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
function verifyCorreo(){
	const correo=document.getElementById("correo").value;
	$.ajax({
		url:"UsuarioController?accion=validarCorreo",
		data:{
			correo:correo
		},
		success: function(result){
		$("#validarC").html(result);	
		//alert(result)
		}
	})	
}
</script>

<%@include file="footer.jsp" %>