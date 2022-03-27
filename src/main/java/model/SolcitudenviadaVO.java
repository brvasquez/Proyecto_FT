package model;

public class SolcitudenviadaVO {
	

	private int id;
	private String nombre;
	private String descripcion;
	private String usuario;
	private boolean estado;
	private String estudianteSolicitante;
	private String correo;
	private String descripcionSolicitud;
	private String rolEstudiante;
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDescripcionSolicitud() {
		return descripcionSolicitud;
	}

	public void setDescripcionSolicitud(String descripcionSolicitud) {
		this.descripcionSolicitud = descripcionSolicitud;
	}

	public SolcitudenviadaVO() {
		
	}
	
	public String getEstudianteSolicitante() {
		return estudianteSolicitante;
	}

	public void setEstudianteSolicitante(String estudianteSolicitante) {
		this.estudianteSolicitante = estudianteSolicitante;
	}

	public String getRolEstudiante() {
		return rolEstudiante;
	}

	public void setRolEstudiante(String rolEstudiante) {
		this.rolEstudiante = rolEstudiante;
	}

	public SolcitudenviadaVO(int id, String nombre, String descripcion, String usuario, boolean estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
