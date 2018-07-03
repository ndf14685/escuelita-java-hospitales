package escuelita.java.hospital;

public class PacientePeritoMorenoDTO {
	String idpaciente;
	String fechaAlta;
	String antecedentes[]=new String[3];
	String notasDelDoctor;

	public String getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(String idpaciente) {
		this.idpaciente = idpaciente;
	}
	public String getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public String[] getAntecedentes() {
		return antecedentes;
	}
	public void setAntecedentes(String[] antecedentes) {
		this.antecedentes = antecedentes;
	}
	public String getNotasDelDoctor() {
		return notasDelDoctor;
	}
	public void setNotasDelDoctor(String notasDelDoctor) {
		this.notasDelDoctor = notasDelDoctor;
	}	
	public void PacientePeritoMorenoDTO(String idpaciente, String fechaAlta, String antecedentes[], String notasDelDoctor)
	{
		 setIdpaciente(idpaciente);
		setFechaAlta(fechaAlta);
		setAntecedentes(antecedentes);
		setNotasDelDoctor(notasDelDoctor);
	}
}
