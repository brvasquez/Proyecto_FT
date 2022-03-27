package model;

public class MaterialApoyoVO {

	private int id;
	private String nombre;
	private String descripcion;
	private String link;
	

	public MaterialApoyoVO(int id, String nombre, String descripcion, String link) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.link = link;
	
	}


	public MaterialApoyoVO() {
		// TODO Auto-generated constructor stub
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


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}
	
	
	
}
