package ar.santaCorp.historiasClinicas.app.entity;

public class HospitalVO {
	private int id;
	private String nombre;
	private String domicilio;
	private int doctorsCount;
	private String pathPacientes;
	
	public HospitalVO(	 int id,
						 String nombre,
						 String domicilio,
						 int doctorsCount,
						 String pathPacientes)
	{
		this.id=id;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.doctorsCount=doctorsCount;
		this.pathPacientes = pathPacientes;
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



	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getDoctorsCount() {
		return doctorsCount;
	}

	public void setDoctorsCount(int doctorsCount) {
		this.doctorsCount = doctorsCount;
	}

	public String getPathPacientes() {
		return pathPacientes;
	}

	public void setPathPacientes(String pathPacientes) {
		this.pathPacientes = pathPacientes;
	}
	
}
