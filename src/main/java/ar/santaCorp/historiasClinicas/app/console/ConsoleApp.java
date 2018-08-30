package ar.santaCorp.historiasClinicas.app.console;

import java.util.Scanner;

import ar.santaCorp.*;
import ar.santaCorp.historiasClinicas.app.SystemController;
import ar.santaCorp.historiasClinicas.app.entity.HospitalBO;
import ar.santaCorp.historiasClinicas.app.entity.PatientBO;
import ar.santaCorp.historiasClinicas.app.entity.UserBO;
import ar.santaCorp.historiasClinicas.app.frontend.controller.ViewsController;

/**
 * Version consola de hospitales
 * Objetivo, reusar al maximo el codigo existente de hospitales
 * Para desacoplar las clases, armo un nuevo SystemController (ConsoleApp extends SystemController)
 * y un nuevo ViewsControllerForConsole.
 * 
 * Como los atributos de SystemController son privados, piso los getters en esta clase.
 *
 */

public class ConsoleApp extends SystemController {
	UserBO     userBO;
	HospitalBO hospitalBO;
	PatientBO  patientBO;

	// Piso los getters porque la clase padre tiene atributos privados
	// sino obtenia null pointer exception
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
		return patientBO;
	}
	
	public static void main(String[] args) {
		ConsoleApp consoleApp = new ConsoleApp();
		consoleApp.start();
	}
	
	public void start()
	{
		userBO     = new UserBO(this);
		hospitalBO = new HospitalBO(this);
		patientBO  = new PatientBO(this);
	
		viewsController = new ViewsControllerForConsole(this); // un nuevo ViewController solo para consola

		outln("Bienvenido al sistema de hospitales\n\n");
	
		do
		{
			out("Usuario:  ");
			String usuario = in();
			outln();
			
			out("Password: ");
			String password = in();
			outln("\n\n");
	
			userBO.tryLogUser(usuario, password);
		} while (!userBO.getIsAuth());
		
		out("Bienvenido...");
		
		String op;
		do
		{
			outln("\n\n");
			out("Menu ppal:");
			outln("\n\n");
			outln("0 Salir");
			outln("1 Actualizar hospitales      ( obtiene hospitales de sistema externo -> guarda en base de datos de aplicacion)");
			outln("2 Obtener pacientes hospital ( recorre todos los hospitales de la Base de datos y actualiza la info de sus pacientes)");

			out("\nOpcion:  ");
			op = in();
						
			if (op.equals("1")) 			hospitalBO.processHospitalPath();
			if (op.equals("2")) 			hospitalBO.processGetPacientesHospitalesDataSource();
			
		} while (!op.equals("0"));		
	}
	
	public void out(String x)   { System.out.print(x);    }
	public void outln()         { System.out.println(""); }
	public void outln(String x) { System.out.println(x);  }
	public String in()          { Scanner scan = new Scanner (System.in); return scan.nextLine(); }
}
