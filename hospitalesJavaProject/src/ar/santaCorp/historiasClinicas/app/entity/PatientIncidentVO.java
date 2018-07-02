package ar.santaCorp.historiasClinicas.app.entity;

import java.time.LocalDateTime;

public class PatientIncidentVO {
	
	public static final String DIAGNOSTIC_TYPE_UNDEFINED 			= "DIAGNOSTIC_TYPE_UNDEFINED";
	public static final String DIAGNOSTIC_TYPE_VISIT 				= "DIAGNOSTIC_TYPE_VISIT";
	public static final String DIAGNOSTIC_TYPE_HEREDITARY_DISEASE 	= "DIAGNOSTIC_TYPE_HEREDITARY_DISEASE";
	public static final String DIAGNOSTIC_TYPE_ANTECEDENT 			= "DIAGNOSTIC_TYPE_ANTECEDENT";
	public static final String DIAGNOSTIC_TYPE_DOCTOR_NOTE 			= "DIAGNOSTIC_TYPE_DOCTOR_NOTE";
	
	private int hospitalId;
	private int patientId;
	private int doctorId;
	private LocalDateTime created;
	private LocalDateTime updated;
	private LocalDateTime dateVisit;
	private String doctorDiagnostic;
	private String diagnosticType;
	
	
	public void PatientIncidentVO()
	{
		
	}
	
	public int getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public LocalDateTime getCreated() {
		return created;
	}
	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	public LocalDateTime getUpdated() {
		return updated;
	}
	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}
	public LocalDateTime getDateVisit() {
		return dateVisit;
	}
	public void setDateVisit(LocalDateTime dateVisit) {
		this.dateVisit = dateVisit;
	}
	
	public String getDoctorDiagnostic() {
		return doctorDiagnostic;
	}
	public void setDoctorDiagnostic(String doctorDiagnostic) {
		this.doctorDiagnostic = doctorDiagnostic;
	}
	public String getDiagnosticType() {
		return diagnosticType;
	}
	public void setDiagnosticType(String diagnosticType) {
		this.diagnosticType = diagnosticType;
	}

}
