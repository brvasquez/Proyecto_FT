package model;

public class CalificaionVo {
	
	private int id;
	private String nombreTutoria;
	private String tutor;
	private String estudiante;
	private String calificacion;
	

	public CalificaionVo(int id, String nombreTutoria, String tutor, String estudiante, String calificacion) {
		super();
		this.id = id;
		this.nombreTutoria = nombreTutoria;
		this.tutor = tutor;
		this.estudiante = estudiante;
		this.calificacion = calificacion;
	
	}


	public CalificaionVo() {
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombreTutoria() {
		return nombreTutoria;
	}


	public void setNombreTutoria(String nombreTutoria) {
		this.nombreTutoria = nombreTutoria;
	}


	public String getTutor() {
		return tutor;
	}


	public void setTutor(String tutor) {
		this.tutor = tutor;
	}


	public String getEstudiante() {
		return estudiante;
	}


	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}


	public String getCalificacion() {
		return calificacion;
	}


	public void setCalificacion(String calificacion) {
		this.calificacion = calificacion;
	}
	
	

}
