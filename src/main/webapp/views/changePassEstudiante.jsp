<%@include file="MenuEstudiante.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">



<h1>Cambiar Constraseña </h1>

<form method="post" action="UsuarioController?accion=changePassEstudiante">
  	
  	<br>
  	<div class="form-group">
  		<input class="form-control" type="hidden" name="id" id="id" value="${us.idUsuario}">
  		<input class="form-control" type="hidden" name="passu" id="passu" value="${us.passwordUsuario}">
  	</div>
  		<br>
  	<div class="form-group">
  		<label for="nombre">Contraseña Actual</label>
  		<input class="form-control" onchange="verifyPass()" type="password" name="passant" id="passant" placeholder="Ingrese el password actcual">
  	</div>
  		<br>
  	
  	<div class="form-group">
  		<label for="nombre">Contraseña nuevo</label>
  		<input class="form-control" type="password" name="passnew" id="passnew" placeholder="Ingrese el password nuevo">
  	</div>
  		<br>
  	
	<div class="form-group">
	<button type="submit" class="btn btn-primary">Guardar</button>
	</div>
  	<br>
  </form>

</div>

<style>
.form-control {
   padding: 6px 12px;
    background-color: #ffffff03;
    color: rgb(75 127 179);
}

</style>

<script>

function verifyPass(){
	console.log("Aquí estoy");
	const passus=document.getElementById("passu");
	const passant=document.getElementById("passant");
	
	
	if(passus.value==passant.value){
		alert("La contraseña actual se ha confirmado")
	}
	else{
		alert("La contraseñas no coinciden con la base de datos")
		passant.focus();
		passant.value="";
	}
}


</script>

<%@include file="footer.jsp" %>