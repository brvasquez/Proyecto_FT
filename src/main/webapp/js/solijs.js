const body = document.body;
const loginBox = document.querySelector(".login-box");
const h1 = document.getElementsByTagName("h1")[0];
const inputs = document.querySelectorAll("input");
const loginButton = document.getElementById("login-button");
const h2 = document.getElementsByTagName("h2")[0];

function switchTheme() {
  loginBox.classList.toggle("dark-mode");
  body.classList.toggle("dark-mode");
  h1.classList.toggle("dark-mode");
  inputs.forEach(input => {
    input.classList.toggle("dark-mode");
  });
  loginButton.classList.toggle("dark-mode");
  h2.classList.toggle("dark-mode");
}

$("#btn2").click(function(){
    /*Swal.fire({
        //error
        type: 'error',
        title: 'Error',
        text: '¡Algo salió mal!',        
    });*/
    Swal.fire({        
        type: 'success',
        title: 'Éxito',
        text: '¡Perfecto!',        
    });
});


function btn(e,con){
	//e.preventDefault();
	
	
	console.log(con);
	
	Swal.fire({
	  title: 'Seguro deseas eliminar este registro?',
	  text: "Esta accion es definitiva y no se puede revertir!",
	  icon: 'warning',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'OK, Eliminalo!',
	  confirmCancelText:'Cancelar'
	  }).then((result) => {
	  if (result.isConfirmed) {
		
		ruta=con+"Controller?accion=add";
		window.setTimeout(function(){window.location.href=ruta},2000);
	    Swal.fire({
		  position: 'top-end',
		  icon: 'success',
		  title: 'El registro ha sido borrado',
		  showConfirmButton: false,
		  timer: 1500
		})
 	 
	}
	else{
		Swal.fire(
	      'Cancelado!',
	      'No se eliminara el registro.',
	      'error'
	    );
	}
})
}
