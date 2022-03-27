<%@include file="MenuTutor.jsp" %>
<div class="container">
	
<div class="flex-fill flex-grow-1 ms-3">



<h1>Cambiar Contraseña</h1>
<br>

<form method="post" action="UsuarioController?accion=changePass">
  	
  	
  	<div class="form-group">
  		<input class="form-control" type="hidden" name="id" id="id" value="${us.idUsuario}">
  		<input class="form-control" type="hidden" name="passu" id="passu" value="${us.passwordUsuario}">
  	</div>
  	
  	<div class="form-group">
  		<h3 for="nombre">Contraseña Actual</h3>
  		<input class="form-control" onchange="verifyPass()" type="password" name="passant" id="passant" placeholder="Ingrese el password actcual">
  	</div>
  	<br>
  	
  	<div class="form-group">
  		<h3 for="nombre">Contraseña nuevo</h3>
  		<input class="form-control" type="password" name="passnew" id="passnew" placeholder="Ingrese el password nuevo">
  	</div>
  	<br>
  	
	<div class="form-group">
	<button type="submit" class="btn btn-primary">Guardar</button>
	</div>
  
  </form>

</div>
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