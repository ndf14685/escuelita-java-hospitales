package ar.santaCorp.historiasClinicas.app.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class PatientVO {
	private int registerType;
	private int id;
	private LocalDateTime created;
	private LocalDateTime updated;
	private ArrayList<PatientIncidentVO> patientIncidentsVO;
	// fecha de creacion del paciente en el sistema del hospital
	private LocalDateTime patientHospitalCreated;
	
	
	public LocalDateTime getCreated() {
		return created;
	}


	public void setCreated(LocalDateTime created) {
		this.created = created;
	}


	public LocalDateTime getPatientHospitalCreated() {
		return patientHospitalCreated;
	}


	public void setPatientHospitalCreated(LocalDateTime patientHospitalCreated) {
		this.patientHospitalCreated = patientHospitalCreated;
	}


	public void PacienteVO()
	{
		
	}
	
	
	public int getRegisterType() {
		return registerType;
	}


	public void setRegisterType(int registerType) {
		this.registerType = registerType;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public LocalDateTime getUpdated() {
		return updated;
	}


	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}


	public ArrayList<PatientIncidentVO> getPatientIncidents() {
		return patientIncidentsVO;
	}


	public void setPatientIncidents(ArrayList<PatientIncidentVO> patientIncidentsVO) {
		this.patientIncidentsVO = patientIncidentsVO;
	}




	
}
