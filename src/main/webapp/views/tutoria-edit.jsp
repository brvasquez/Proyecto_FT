<%@include file="MenuTutor.jsp" %>

<div class="flex-fill flex-grow-1 ms-3">



<h1>Actualizar Tutoria</h1>

<form method="post" action="TutoriaController?accion=edit">
  	
  	<div class="form-group">
  		<input type="text" readonly class="form-control" name="id" id="id" placeholder="" value="${tutorias.idTutoria}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese nombre" value="${tutorias.nombre}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Descripcion</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción" value="${tutorias.descripcion}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Tutor</label>
  		<input type="text" class="form-control" name="usuario" id="usuario" readonly placeholder="Ingrese usuario" value="${tutorias.usuario}"/>
  	</div>
  	
  	<div class="form-check">
	  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
	  <c:out value="${tutorias.estado==false ? 'unchecked':'checked'}"/> >
	  <label class="form-check-label" for="flexCheckChecked">
	    ${tutorias.estado==false ? 'Marca para Activar':'Desmarca para desactivar '}
	  </label>
	  
	</div>


<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>