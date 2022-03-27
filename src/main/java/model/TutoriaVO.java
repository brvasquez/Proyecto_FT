package model;

public class TutoriaVO {

	private int idTutoria;
	private String nombre;
	private String descripcion;
	private String usuario;
	private boolean estado;
	
	public TutoriaVO() {
		
	}

	public TutoriaVO(int idTutoria, String nombre, String descripcion, String usuario, boolean estado) {
		super();
		this.idTutoria = idTutoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.estado = estado;
	}

	public int getIdTutoria() {
		return idTutoria;
	}

	public void setIdTutoria(int idTutoria) {
		this.idTutoria = idTutoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
