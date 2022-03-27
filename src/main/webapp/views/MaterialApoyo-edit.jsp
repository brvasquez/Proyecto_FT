<%@include file="MenuTutor.jsp" %>

<div class="flex-fill flex-grow-1 ms-3">



<h1>Actualizar Material</h1>

<form method="post" action="MaterialApoyoController?accion=edit">
  	
  	<div class="form-group">
  		<input type="text" readonly class="form-control" name="id" id="id" placeholder="" value="${materiales.id}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Nombre</label>
  		<input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese nombre" value="${materiales.nombre}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Descripcion</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción" value="${materiales.descripcion}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">link</label>
  		<input type="text" class="form-control" name="link" id="link"  placeholder="Ingrese link" value="${materiales.link}"/>
  	</div>
  	
 


<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>