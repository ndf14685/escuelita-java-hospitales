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

public class PatientBO {
		
		private SystemController _systemController;
		private PatientDAOImp patientDAO;
		
		public PatientBO(SystemController p_systemController)
		{
			System.out.println("systemController "+p_systemController);

			this._systemController = p_systemController;
			this.patientDAO = new PatientDAOImp();
		}
		
		// accede al listado de pacientes , intenta actualizarlos y si no puede crearlos
		public boolean processPacientesFromDataSource(String pathDataSource, HospitalVO hospitalVO)
		{
			this.patientDAO.createOrUpdatePatientsFromDataSource(pathDataSource, hospitalVO.getId());
			//patientDAO.getPatientsByHospitalId(hospitalId)
		
			return true;
		}
}
