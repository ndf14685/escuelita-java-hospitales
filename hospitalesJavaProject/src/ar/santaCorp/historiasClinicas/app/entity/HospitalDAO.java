package ar.santaCorp.historiasClinicas.app.entity;

import java.util.ArrayList;

import com.google.gson.Gson;

import ar.santaCorp.historiasClinicas.util.FileManager;

public class HospitalDAO implements IHospitalDAO {
	
	
	
	@Override
	public ArrayList<HospitalVO> getHospitals() {
		ArrayList hospitalsPaths = FileManager.listDirectoryFiles("db/hospitals/hospital/");
		ArrayList<HospitalVO> hospitalsList= new ArrayList();
		
		for (int i = 0; i < hospitalsPaths.size(); i++) {
			String strJson = FileManager.getFileContent(hospitalsPaths.get(i).toString());
			//HospitalVO tmpHospitalVo = this.createHospitalVoFromJsonStr(line);
			HospitalVO tmpHospital = this.createHospitalVoFromJsonStr(strJson);
			if(tmpHospital!=null)
			{
				hospitalsList.add(tmpHospital);
				//System.out.println("******************se creo el hospital="+tmpHospital.getId());
			}else
			{
				System.out.println("******************no se pudo convertir ="+hospitalsPaths.get(i).toString());
			}
		}
		return hospitalsList;
	}

	@Override
	public HospitalVO create(HospitalVO hospitalVo) {
		int id = hospitalVo.getId();
		System.out.println("******************id="+id);
		Gson gson = new Gson();
		String jsonHospitalVo = gson.toJson(hospitalVo);
		FileManager.setFile("db/hospitals/hospital/hospital"+id+".json", jsonHospitalVo);
		
		return null;
	}

	@Override
	public HospitalVO select(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HospitalVO update(HospitalVO hospitalVo) {
		// por ahora el update lo unico que hace es volve a escribir el archivo
		this.create(hospitalVo);
		return null;
	}

	@Override
	public boolean delete(HospitalVO hospitalVo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean createOrUpdateHospitalsFromDataSource()
	{

		ArrayList fileLines = FileManager.getFileLines("db/hospitals/hospitals.json");
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::->processHospitalPath()");
		System.out.println("Listado de paths leidos:"+fileLines.size());
		
		for (int i = 0; i < fileLines.size(); i++) {
			
			
			String line = fileLines.get(i).toString();
			HospitalVO tmpHospitalVo = this.createHospitalVoFromJsonStr(line);
			
			if(tmpHospitalVo==null)
			{
				// si no pudo crear el objeto por algun error no crea el registro;
				continue;
			}
			
			String id = Integer.toString(tmpHospitalVo.getId());
			String pathFileHospital = "db/hospitals/hospital/hospital"+tmpHospitalVo.getId()+".json";
			
			// intenta crear el hospital, si ya existe hace un update
			if(FileManager.fileExist(pathFileHospital))
			{
				this.update(tmpHospitalVo);
			}else
			{
				this.create(tmpHospitalVo);
			}
		}
		return true;
	}
	
	private HospitalVO createHospitalVoFromJsonStr(String json)
	{
		Gson gson = new Gson();
		HospitalVO tmpHospitalVo = gson.fromJson(json, HospitalVO.class);
		return tmpHospitalVo;
	}

}
