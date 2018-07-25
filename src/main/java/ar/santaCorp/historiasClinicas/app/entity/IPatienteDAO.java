package ar.santaCorp.historiasClinicas.app.entity;
import java.util.ArrayList;
import java.util.List;

public interface IPatienteDAO {
	//declaración de métodos para acceder a la base de datos
		public ArrayList<PatientVO> getPatientsByHospitalId(int hospitalId);
		public PatientVO create(PatientVO patientVO);
		public PatientVO select(int id);
		public PatientVO update(PatientVO patientVO);
		public boolean delete(PatientVO patientVO);
		public boolean createOrUpdatePatientsFromDataSource(String p_pathDataSoruce, int hospitalID);
		
}


