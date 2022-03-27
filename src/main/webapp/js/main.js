function borrar(e,id,con){
	//e.preventDefault();
	
	console.log(id);
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
		
		ruta=con+"Controller?accion=delete&id="+id;
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