<%@include file="MenuTutor.jsp" %>

<div class="flex-fill flex-grow-1 ms-3">



<h1>Registrar Tutoria</h1>

<form method="post" action="TutoriaController?accion=add">
  	
  	<div class="form-group">
  		<label for="nombre">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese el nombre" onchange="verifyNombre()"/>
  	</div >
  	
  	<div id="validarN" class="text-danger"></div>
  	
  	<div class="form-group">
  		<label for="descripcion">Descripción</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="usuario">Tutor</label>
  		<input type="text" class="form-control" name="usuario" id="usuario" readonly placeholder="Ingrese la descripción" value="${us.nombreUsuario} ${us.apellidoUsuario}"/>
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

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
  function verifyNombre(){
	const nombre=document.getElementById("nombre").value;
	$.ajax({
		url:"TutoriaController?accion=validarNombre",
		data:{
			nombre:nombre
		},
		success: function(result){
			
		alert(result)
		}
	})	
}
</script>

<%@include file="footer.jsp" %>