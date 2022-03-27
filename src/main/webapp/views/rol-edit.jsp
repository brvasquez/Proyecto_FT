<%@include file="header.jsp" %>
<div class="flex-fill flex-grow-1 ms-3">



<h1>Actualizar Rol</h1>

<form method="post" action="RolController?accion=edit">
  	
  	<div class="form-group">
  		<input type="text" readonly class="form-control" name="id" id="id" placeholder="" value="${roles.idRol}"/>
  	</div>
  	
  	<div class="form-group">
  		<label for="descripcion">Descripción</label>
  		<input type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Ingrese la descripción" value="${roles.descripcionRol}"/>
  	</div>
  	
  	<div class="form-check">
	  <input class="form-check-input" type="checkbox" name="chkEstado" id="chkEstado" 
	  <c:out value="${roles.estadoRol==false ? 'unchecked':'checked'}"/> >
	  <label class="form-check-label" for="flexCheckChecked">
	    ${roles.estadoRol==false ? 'Marca para Activar Rol':'Desmarca para desactivar Rol'}
	  </label>
	  
	</div>


<div>
<button type="submit" class="btn btn-primary">Guardar</button>
</div>
  
  </form>

</div>


<%@include file="footer.jsp" %>