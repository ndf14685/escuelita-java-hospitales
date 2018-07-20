package ar.santaCorp.historiasClinicas.app.entity;

import java.awt.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.google.gson.Gson;

import ar.santaCorp.historiasClinicas.util.FileManager;

public class PatientDAOImp implements IPatienteDAO {

	public void PatientDAOImp()
	{
		
	}
	@Override
	public ArrayList<PatientVO> getPatientsByHospitalId(int hospitalId) {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public PatientVO create(PatientVO patientVO) {
		
		LocalDateTime created = LocalDateTime.now();
		patientVO.setCreated(created);
		int id = patientVO.getId();

		Gson gson = new Gson();
		String jsonPatientVo = gson.toJson(patientVO);
		FileManager.setFile("src/main/resources/db/patient/patient"+id+".json", jsonPatientVo);
		
		return null;
	}

	@Override
	public PatientVO select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientVO update(PatientVO patientVO) {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// aca falta parte del codigo, debe seleccionar primero el objeto a actualizar y solo sobreescribir las propiedades actualizables
		// por ejemplo no se deben actualizar id y created
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		LocalDateTime updated = LocalDateTime.now();
		patientVO.setUpdated(updated);
		int id = patientVO.getId();
		
		Gson gson = new Gson();
		String jsonPatientVo = gson.toJson(patientVO);
		FileManager.setFile("src/main/resources/db/patient/patient"+id+".json", jsonPatientVo);
		return null;
	}

	@Override
	public boolean delete(PatientVO patientVO) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createOrUpdatePatientsFromDataSource(String p_pathDataSoruce, int hospitalID) {
		// TODO Auto-generated method stub
		// primero pido el contenido del file dividido en lineas
		ArrayList fileLines = FileManager.getFileLines(p_pathDataSoruce);
		
		
		System.out.println("Listado de pacientes leido:"+fileLines.size()+"    p_pathDataSoruce="+p_pathDataSoruce);
		System.out.println("          ");
		for (int i = 0; i < fileLines.size(); i++) {
			
			
			String line = fileLines.get(i).toString();
			this.createPatientVO(line,hospitalID);
			
			
			//PatientVO tmpPatientVo = gson.fromJson(line, PatientVO.class);

			//usersVO.add(tmpUserVo);
			
		}
		System.out.println("          ");
		//return this.getIsAuth();
		
		
		
		// creo el objeto json del paciente con el pacienteVO
		
		// guardo la info y si hace falta creo al paciente
		// hay que actualizar las fechas
		
		return false;
	}
	
	private PatientVO createPatientVO(String patientData, int hospitalID)
	{
		//System.out.println("****************-------------------------------->hospitalID:"+hospitalID);
		
		//
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		String patientHospitalCreatedNotFormated = "18/07/2018";
		
		String day = "";
		String month = "";
		String year = "";
		
		int registerType = 0;
		int id = 0;
		ArrayList<PatientIncidentVO> patientIncidents = new ArrayList();
		LocalDateTime patientHospitalCreated = null;

		String strIncidents = "";
		// debo acceder a cada tipo de string y cargar los datos del paciente;
		// ademas debo crear un registro en la tabla de relaciones entre pacientes y hospitales si es que todavia no existe;
		
		switch(hospitalID)
		{
			case 1:
				registerType=Integer.parseInt(patientData.substring(0,1));
				id=Integer.parseInt(patientData.substring(1,9));
				
				//System.out.println("registerType:"+registerType);
				
 				day 	= patientData.substring(9,11);
				month 	= patientData.substring(12,14);
				year 	= patientData.substring(15,19);
				
				try
				{
					strIncidents = patientData.substring(19,178);
				}catch(Exception ex)
				{
					System.out.println("Falta informacion en paciente, no se guardara la informacion correspondiente a los incidentes:"+id);
				}
				
			break;
			case 2:
				String[] parts = patientData.split(";",-1);
				registerType=Integer.parseInt(parts[0]);
				id=Integer.parseInt(parts[1]);
				
				patientHospitalCreatedNotFormated = parts[2];
				String[] dateSplitted = patientHospitalCreatedNotFormated.split("/");
 				day 	= dateSplitted[0];
				month 	= dateSplitted[1];
				year 	= dateSplitted[2];
				
				strIncidents = parts[3]+";"+parts[4];
				
				
			break;
		}
		
		//System.out.println("dateStr:"+ year+"-"+month+"-"+day+" 00:00");
		
		
		String dateFormatedStr = year+"-"+month+"-"+day+" 00:00";
		patientHospitalCreated = LocalDateTime.parse(dateFormatedStr, formatter);
		
		/*
		System.out.println("registerType:"+registerType);
		System.out.println("id:"+id);
		System.out.println("patientHospitalCreated:"+patientHospitalCreated);
		*/
		PatientVO tmpPatientVO = new PatientVO();
		tmpPatientVO.setId(id);
		tmpPatientVO.setRegisterType(registerType);
		tmpPatientVO.setPatientHospitalCreated(patientHospitalCreated);
		tmpPatientVO.setPatientIncidents(this.getPatientIncident(hospitalID,id,strIncidents));
		
		String pathFilePatient = "src/main/resources/db/patient/patient"+id+".json";
		
		// intenta crear el hospital, si ya existe hace un update
		if(FileManager.fileExist(pathFilePatient))
		{
			this.update(tmpPatientVO);
		}else
		{
			this.create(tmpPatientVO);
		}
		return null;
	}
	
	private ArrayList<PatientIncidentVO> getPatientIncident(int hospitalId, int patientId, String strIncidents)
	{
		if(strIncidents.equals(""))
		{
			return null;
		}
		ArrayList<PatientIncidentVO> tmpPatientIncidentListVO = new ArrayList();
		
		ArrayList<String> partsAntecedents = new ArrayList();
		ArrayList<String> partsHereditary = new ArrayList();
		String doctorNotes = "";
		//new PatientIncidentVO();
		switch(hospitalId)
		{
			case 1:
				try
				{
				//partsAntecedents[0]="";
				partsAntecedents.add(strIncidents.substring(0, 20));
				partsAntecedents.add(strIncidents.substring(20, 40));
				partsAntecedents.add(strIncidents.substring(40, 60));
				doctorNotes = strIncidents.substring(60, 99);
				}catch(Exception ex)
				{
					System.out.println("Error al parsear incidentes->"+strIncidents);
				}
			break;
			case 2:
				System.out.println("strIncidents->"+strIncidents);
				
				String[] parts = strIncidents.split(";",-1);
				//DIAGNOSTIC_TYPE_ANTECEDENT
				//TIPO_DIAGNOSTICO_HEREDITARY_DISEASE
				
				Collections.addAll(partsAntecedents, parts[0].split(","));
				Collections.addAll(partsHereditary, parts[1].split(","));
				
			break;
		}
		
		// si existen notas del doctor crea uno para tal motivo
		if(!doctorNotes.equals(""))
		{
			PatientIncidentVO tmpPatientIncidentVO = new PatientIncidentVO();
			tmpPatientIncidentVO.setDiagnosticType(PatientIncidentVO.DIAGNOSTIC_TYPE_DOCTOR_NOTE);
			tmpPatientIncidentVO.setDoctorDiagnostic(doctorNotes);
			tmpPatientIncidentVO.setHospitalId(hospitalId);
			tmpPatientIncidentVO.setPatientId(patientId);
			tmpPatientIncidentListVO.add(tmpPatientIncidentVO);
		}
		// RECORRE TODOS LOS TIPOS DE INCIDENTES Y CREA LOS OBJETOS
		// primero para el tipo partsAntecedents DIAGNOSTIC_TYPE_ANTECEDENT
		for (int i = 0; i < partsAntecedents.size(); i++) {
			PatientIncidentVO tmpPatientIncidentVO = new PatientIncidentVO();
			tmpPatientIncidentVO.setDiagnosticType(PatientIncidentVO.DIAGNOSTIC_TYPE_ANTECEDENT);
			tmpPatientIncidentVO.setDoctorDiagnostic(partsAntecedents.get(i));
			tmpPatientIncidentVO.setHospitalId(hospitalId);
			tmpPatientIncidentVO.setPatientId(patientId);
			tmpPatientIncidentListVO.add(tmpPatientIncidentVO);
		}
		
		// RECORRE LOS TIPOS DE INCIDENTES PARA ENFERMEDADES HEREDITARIAS
		for (int i = 0; i < partsHereditary.size(); i++) {
			PatientIncidentVO tmpPatientIncidentVO = new PatientIncidentVO();
			tmpPatientIncidentVO.setDiagnosticType(PatientIncidentVO.DIAGNOSTIC_TYPE_HEREDITARY_DISEASE);
			tmpPatientIncidentVO.setDoctorDiagnostic(partsHereditary.get(i));
			tmpPatientIncidentVO.setHospitalId(hospitalId);
			tmpPatientIncidentVO.setPatientId(patientId);
			tmpPatientIncidentListVO.add(tmpPatientIncidentVO);
			
		}
		
		return tmpPatientIncidentListVO;
	}

}
