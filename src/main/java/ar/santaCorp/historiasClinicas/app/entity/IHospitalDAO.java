package ar.santaCorp.historiasClinicas.app.entity;
import java.util.ArrayList;
import java.util.List;

public interface IHospitalDAO {
	//declaración de métodos para acceder a la base de datos
		public ArrayList<HospitalVO> getHospitals();
		public HospitalVO create(HospitalVO hospitalVo);
		public HospitalVO select(int id);
		public HospitalVO update(HospitalVO hospitalVo);
		public boolean delete(HospitalVO hospitalVo);
		public boolean createOrUpdateHospitalsFromDataSource();
}


