<%@include file="header.jsp" %>
<div class="container-sm grow-4 ms-4">
<div class="text-center">
<h3>Registrar Usuario</h3>
</div>



<div class="container">
	<form method="post" action="UsuarioController?accion=add">
  	
  	<div class="form-group">
  		<label for="tipodoc">Tipo Documento</label>
  		<select name="tipodoc" class="form-select">
  			<option selected>Seleccione un Tipo de Documento</option>
  			<option value="Tarjeta de Identidad">Tarjeta de Identidad</option>
  			<option value="Cédula de Ciudadanía">Cédula de Ciudadanía</option>
  		</select>
  	</div>
  	
  	<div class="form-group">
  		<label for="numdoc">Número de Documento</label>
  		<input class="form-control" type="number" name="numdoc" placeholder="Ingrese el número de documento">
  	</div>
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input class="form-control" type="text" name="nombre" placeholder="Ingrese el nombre del usuario">
  	</div>
  	
  	<div class="form-group">
  		<label for="apellido">Apellido</label>
  		<input class="form-control" type="text" name="apellido" placeholder="Ingrese el apellido del usuario">
  	</div>
  	
  	<div class="form-group">
  		<label for="direccion">Dirección</label>
  		<input class="form-control" type="text" name="direccion" placeholder="Ingrese la dirección del usuario">
  	</div>
  	
  	<div class="form-group">
  		<label for="telefono">Teléfono</label>
  		<input class="form-control" type="text" name="telefono" placeholder="Ingrese el telefono del usuario">
  	</div>
  	
  	<div class="form-group">
  		<label for="correo">Correo</label>
  		<input class="form-control" type="text" id="correo" name="correo" placeholder="Ingrese el correo del usuario" onchange="verifyCorreo()">
  	</div>
  	<div id="validarC" class="text-danger"></div>
  	
  	<div class="form-group">
  		<label for="password">Password</label>
  		<input class="form-control" type="password" name="password" placeholder="Ingrese el password del usuario">
  	</div>
  	
  	
  	<div class="form-group">
  		<label for="rolusu">Rol Usuario</label>
  		<select class="form-select" name="rolusu">
  		<option>Seleccione el rol de usuario</option>
  		<c:forEach items="${roles}" var="r">
  			<option value="${r.idRol}">${r.descripcionRol}    </option>
  		
  		</c:forEach>
  		</select>
  	</div>
  	
  	<div class="form-check">
  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" checked>
  <label class="form-check-label" for="flexCheckChecked">
    Activo
  </label>
</div>


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