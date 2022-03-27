<%@include file="MenuTutor.jsp" %>

<div class="flex-fill flex-grow-1 ms-3">



<h1>Enviar Solicitud</h1>
<br>

<form method="post" action="SolicitudEnviadaController?accion=add2">
  	
  	<div class="form-group">
  		<input type="hidden" readonly class="form-control" name="id" id="id" placeholder="" value="${solicitudes.id}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion"><h2>Nombre tutoria solcitada</h2></label>
  		<input type="text" readonly class="form-control" name="nombre" id="nombre" placeholder="Ingrese nombre" value="${solicitudes.nombre}"/>
  	</div>
  	<br>
  	<div class="form-group">
  		<label for="descripcion"><h2>Descripcion de la tutoria solcitada</h2></label>
  		<input type="text" readonly class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción" value="${solicitudes.descripcion}"/>
  	</div>
  	<br>
  	<div class="form-group">
  		<label for="descripcion"><h2>Tutor solicitado</h2></label>
  		<input type="text" readonly class="form-control" name="usuario" id="usuario" placeholder="Ingrese usuario" value="${solicitudes.usuario}"/>
  	</div>
  	<br>
  	<div class="form-group">
  		<label for="descripcion"><h2>Estudiante Solicitante</h2></label>
  		<input type="text" readonly class="form-control" name="estudianteSolicitante" id="estudianteSolicitante" placeholder="Ingrese usuario" value="${solicitudes.estudianteSolicitante}"/>
  	</div>
  	<br>
  	<div class="form-group">
  		<label for="descripcion"><h2>Correo del estudiante</h2></label>
  		<input type="text" readonly class="form-control" name="correo" id="correo" placeholder="Ingrese usuario" value="${solicitudes.correo}"/>
  	</div>
  	<br>
  	 <div class="form-group">
  		<label for="descripcionSolicitud"><h2>Descripcion Solicitud a enviar</h2></label>
  		<textarea  class="form-control" type="text" name="descripcionSolicitud" placeholder="Ingrese Meet y hora de la reunion" rows="5" cols="80"></textarea>
  	</div>
  	
  	
 
  	
  	<div class="form-check">
	  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
	  <c:out value="${solicitudes.estado==false ? 'unchecked':'checked'}"/> >
	  <label class="form-check-label" for="flexCheckChecked">
	    ${solicitudes.estado==false ? 'Marca para Activar':'Desmarca para desactivar '}
	  </label>
	  
	</div>

<br>
<div>
<button type="submit" class="btn btn-primary">Enviar Solicitud</button>
</div>
  
  </form>

</div>

<style>
textarea.form-control {
     padding: 6px 12px;
    background-color: #ffffff03;
    color: rgb(75 127 179);
}
.form-control:disabled, .form-control[readonly] {
    padding: 6px 12px;
    background-color: #ffffff03;
    color: rgb(75 127 179);
   
}
</style>

<%@include file="footer.jsp" %>