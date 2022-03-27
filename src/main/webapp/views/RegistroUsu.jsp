<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>


<link rel="stylesheet" href="css/registroestilos.css">


<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>





<div class="">
	<form method="post" action="UsuarioController?accion=add2">
  	
  			 <div class="wrapper">
        <div class="title">
          Registro
        </div>
        <div class="form">
            <div class="inputfield">
                <label for="tipodoc" >Tipo de documento</label>
                <div class="custom_select">
                  <select name="tipodoc" required>
                    <option value="">seleccione su tipo de docuemento</option>
                    <option value="tarjeta de identidad">Tarjeta de Identidad</option>
                    <option value="Cedula Ciudadana">Cedula Ciudadana</option>
                  </select>
                </div>
             </div>
           <div class="inputfield">
              <label  for="numdoc" >Numero de documento</label>
              <input type="number" class="input"  name="numdoc" required placeholder="Ingrese el número de documento">
           </div>  
            <div class="inputfield">
              <label for="nombre">Nombre</label>
              <input type="text" class="input" name="nombre" required placeholder="Ingrese el nombre del usuario">
           </div>
           <div class="inputfield">
            <label for="apellido">Apellido</label>
            <input type="text" class="input" name="apellido" required placeholder="Ingrese el apellido del usuario">
         </div>  
         <div class="inputfield">
            <label for="direccion">Direccion</label>
            <input type="text" class="input" name="direccion" required placeholder="Ingrese la dirección del usuario">
         </div>  
         <div class="inputfield">
            <label for="telefono">Telefono</label>
            <input type="text" class="input" name="telefono" required placeholder="Ingrese el telefono del usuario">
         </div> 
         <div class="inputfield">
            <label for="correo">Correo</label>
            <input type="text" class="input" id="correo" name="correo" required placeholder="Ingrese el correo del usuario" onchange="verifyCorreo()">
         </div> 
           <div class="inputfield">
              <label>Contraseña</label>
              <input type="password" class="input" name="password" required placeholder="Ingrese el password del usuario">
           </div>  
           <div class="inputfield">
              <label for="rolusu">Tipo de usuario</label>
              <div class="custom_select">
                <select name="rolusu" required>
                  <option value="">Seleccione su rol</option>
                  <c:forEach items="${roles}" var="r">
  					<option value="${r.idRol}">${r.descripcionRol}    </option>
  		
  				</c:forEach>
                </select>
              </div>
           </div> 
           
           <div class="form-check">
            <input class="form-check-input" type="hidden" name="chkEstado" id="chkEstado" checked>
            <label class="form-check-label" for="flexCheckChecked" type="hidden">
              
            </label>
      </div>
           
          <div class="inputfield terms">
              <label class="check">
                <input type="checkbox" required>
                <span class="checkmark"></span>
              </label>
              <p>
                 <a href="terminosycondiciones.jsp">Acepta terminos y condiciones</a> 
                </p>
           </div> 
           <a href="UsuarioController?accion=abrirLogin">Si ya tienes cuenta Inicia sesion</a>   	
          <div class="inputfield">
            <input type="submit" value="Registrar" class="btn">
           </div>
        </div>
    </div>
			 		
  		 
  </form>
	









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

