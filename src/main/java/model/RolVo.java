package model;

public class RolVo {
	
	//Atributos encapsulados
	
	private int idRol;
	private String descripcionRol;
	private boolean estadoRol;
	
	//Constructores vacío, recibir datos
	public RolVo() {
		
	}

	public RolVo(int idRol, String descripcionRol, boolean estadoRol) {
		super();
		this.idRol = idRol;
		this.descripcionRol = descripcionRol;
		this.estadoRol = estadoRol;
	}
	
	
	//Getters y Setters
	
	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public boolean isEstadoRol() {
		return estadoRol;
	}

	public void setEstadoRol(boolean estadoRol) {
		this.estadoRol = estadoRol;
	}
		
	
	
	

}
