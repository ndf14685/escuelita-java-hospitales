package ar.santaCorp.historiasClinicas.app.entity;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;

import ar.santaCorp.historiasClinicas.app.SystemController;
import ar.santaCorp.historiasClinicas.util.FileManager;

public class HospitalBO {

		private SystemController systemController;
		private HospitalVO hospitalVO;
		private HospitalDAO hospitalDAO;
		
		public HospitalBO(SystemController p_systemController)
		{

			this.systemController = p_systemController;
			this.hospitalDAO = new HospitalDAO();
			
		}
		
		public void processGetPacientesHospitalesDataSource()
		{
			// tiene que recorrer todos los hospitales, abrirlos, y obtener la ruta de sus pacientes
			// luego pasa la info a pacientes BO para que cree sus pacientes y tenga su propia logica de negocio
			// esta info se la deberia pedir a un DTO ya que posiblemente cambie a futuro
			// para hacerlo primero abre el directorio:
			// db\hospitals\hospital
			// recorre uno a uno, accede a pacienteBO y le pasa la info 
			// 
			
			
			ArrayList<HospitalVO> hospitalsList = (ArrayList) this.hospitalDAO.getHospitals();
			for (int i = 0; i < hospitalsList.size(); i++) {
				HospitalVO tmpHospital = hospitalsList.get(i);
				String pathPacientes = tmpHospital.getPathPacientes();
				//System.out.println("******************pathPacientes ="+pathPacientes);
				
				if (systemController.getPatientBO()==null) System.out.println("getPatientBO null");
				this.systemController.getPatientBO().processPacientesFromDataSource(pathPacientes, tmpHospital);
				                                    

				
			}
			
			
		}
		public void processHospitalPath()
		{
			this.hospitalDAO.createOrUpdateHospitalsFromDataSource();
		}
		
		
}

