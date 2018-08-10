package ar.santaCorp.historiasClinicas.app.frontend.controller;


import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import ar.santaCorp.historiasClinicas.app.SystemController;
import ar.santaCorp.historiasClinicas.app.frontend.view.LoginView;
import ar.santaCorp.historiasClinicas.app.frontend.view.RenderView;
import ar.santaCorp.historiasClinicas.util.CustomScanner;;

public class ViewsController {
	public static final String  DASHBOARD_VIEW = "DASHBOARD_VIEW";
	public static final String  LOGIN_VIEW = "LOGIN_VIEW";
	
	public static final String STATE_USER_LOGGED = "STATE_USER_LOGGED";
	public static final String STATE_USER_NOT_LOGGED = "STATE_USER_NOT_LOGGED";
	
	public SystemController systemController;
	private IViewController currentViewController;
	public TopController topController;
	
	private ArrayList navigitateHistory;
	
	// guarda todas exceptuando la del login, sirve para ir a la inerface anterior cuando el usuario se termina de logear
	private String prevLoginViewId;
	
	public ViewsController(SystemController p_systemController)
	{
		
		this.systemController = p_systemController;
		this.navigitateHistory = new ArrayList();
		
		this.topController = new TopController(this);
		//_customScanner = new CustomScanner();
	}
	
	
	public void navigateOnLoginSuccess()
	{
		if(this.prevLoginViewId!=null)
		{
			this.navigateTo(prevLoginViewId);
		}else if(currentViewController!=null)
		{
			currentViewController.destroy();
			
		}
	}
	
	private void addNavHistory(String navFinal)
	{
		this.navigitateHistory.add(navFinal);
	}
	
	
	public boolean navigateTo(String navigateId) {
		
		System.out.println("LLEGA UN PEDIDO DE NAV A:"+navigateId);
		
		
		
		if(this.currentViewController != null)
		{
			System.out.println("::::::::::::::destroid:"+this.currentViewController);
			this.currentViewController.destroy();
		}
			
		//_customScanner.methodToCallBack(this.onScanerLine);
		switch(navigateId)
		{
			case ViewsController.DASHBOARD_VIEW:
				//_currentView = new DashboardController();
				
				if(DashboardController.AUTH_REQUIRED && !systemController.getUserBO().getIsAuth())
				{
					this.prevLoginViewId = navigateId;
					this.navigateTo(ViewsController.LOGIN_VIEW);
					break;
				}
				
				this.addNavHistory(navigateId);
				currentViewController = new DashboardController(this);
			break;
			case ViewsController.LOGIN_VIEW:
				// nunca agregar el login al historial de navegacion
				currentViewController = new LoginController(this);
				
				//currentViewController.init();
				
			break;	
		}
		return true;
		
	}
	public void setState(String p_state)
	{
		System.out.println("ViewsController.setState:"+p_state);
		
		switch(p_state)
		{
			case ViewsController.STATE_USER_NOT_LOGGED:
				//
				this.topController.onUserLogOut();
				if(this.currentViewController!=null)
				{
					this.currentViewController.destroy();
				}
			break;
			case ViewsController.STATE_USER_LOGGED:
				
				this.topController.onUserLogIn(this.systemController.getUserBO().getLoggedUser());	
			break;
		}
	}
	public void test()
	{
		
	}
}
