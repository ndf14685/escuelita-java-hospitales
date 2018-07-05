package ar.santaCorp.historiasClinicas.app;
import java.util.Scanner;

import ar.santaCorp.historiasClinicas.app.entity.HospitalBO;
import ar.santaCorp.historiasClinicas.app.entity.PatientBO;
import ar.santaCorp.historiasClinicas.app.entity.UserBO;
import ar.santaCorp.historiasClinicas.app.frontend.controller.ViewsController;
import ar.santaCorp.historiasClinicas.app.frontend.view.MainWindowView;
import ar.santaCorp.historiasClinicas.app.frontend.view.WindowAppView;


public class SystemController {
	public ViewsController viewsController;
	//public WindowAppView myAppWindow;
	public MainWindowView myAppWindow;
	
	private UserBO userBO;
	private HospitalBO hospitalBO;
	private PatientBO patientBO;
	
	public SystemController()
	{
		
		

	}
	public void initialize()
	{
		System.out.println("inicializo main"); 
		userBO = new UserBO(this);
		hospitalBO = new HospitalBO(this);
		patientBO = new PatientBO(this);
		
		
		myAppWindow = new MainWindowView();
		myAppWindow.initialize();
		
		
		
		
		this.viewsController = new ViewsController(this);
		
		this.userBO.trySetPersistUser();
		//
		
	}
	
	public void tryUserLogOut()
	{
		this.userBO.userLogOut();
	}
	public void onUserLogged()
	{
		this.viewsController.setState(ViewsController.STATE_USER_LOGGED);	
	}
	public void onUserLoggedOut()
	{
		this.viewsController.setState(ViewsController.STATE_USER_NOT_LOGGED);	
	}
	
	public UserBO getUserBO()
	{
		return this.userBO;
	}
	
	public HospitalBO getHospitalBO()
	{
		return hospitalBO;
	}
	
	public PatientBO getPatientBO()
	{
		return this.patientBO;
	}
	public void closeApp()
	{
		//myAppWindow.dispose();
	}
}


