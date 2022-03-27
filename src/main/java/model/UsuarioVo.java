package model;

public class UsuarioVo {

	private int idUsuario;
	private String tipoDocUsuario, noDocUsuario, nombreUsuario, apellidoUsuario, direccionUsuario, telefonoUsuario,
			correoUsuario, passwordUsuario;
	private boolean estadoUsuario;
	private RolVo rolUs;

	public UsuarioVo() {

	}

	public UsuarioVo(int idUsuario, String tipoDocUsuario, String noDocUsuario, String nombreUsuario,
			String apellidoUsuario, String direccionUsuario, String telefonoUsuario, String correoUsuario,
			String passwordUsuario, boolean estadoUsuario, RolVo rolUs) {
		super();
		this.idUsuario = idUsuario;
		this.tipoDocUsuario = tipoDocUsuario;
		this.noDocUsuario = noDocUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.direccionUsuario = direccionUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.correoUsuario = correoUsuario;
		this.passwordUsuario = passwordUsuario;
		this.estadoUsuario = estadoUsuario;
		this.rolUs = rolUs;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getTipoDocUsuario() {
		return tipoDocUsuario;
	}

	public void setTipoDocUsuario(String tipoDocUsuario) {
		this.tipoDocUsuario = tipoDocUsuario;
	}

	public String getNoDocUsuario() {
		return noDocUsuario;
	}

	public void setNoDocUsuario(String noDocUsuario) {
		this.noDocUsuario = noDocUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getDireccionUsuario() {
		return direccionUsuario;
	}

	public void setDireccionUsuario(String direccionUsuario) {
		this.direccionUsuario = direccionUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getPasswordUsuario() {
		return passwordUsuario;
	}

	public void setPasswordUsuario(String passwordUsuario) {
		this.passwordUsuario = passwordUsuario;
	}

	public boolean isEstadoUsuario() {
		return estadoUsuario;
	}

	public void setEstadoUsuario(boolean estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}

	public RolVo getRolUs() {
		return rolUs;
	}

	public void setRolUs(RolVo rolUs) {
		this.rolUs = rolUs;
	}

	

	public String getEstadoUsuarioRep() {
		return this.estadoUsuario ? "Activo" : "Inactivo";
	}

}
