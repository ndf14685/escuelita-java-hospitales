package ar.santaCorp.historiasClinicas.app.console;

import java.util.ArrayList;

import ar.santaCorp.historiasClinicas.app.SystemController;
import ar.santaCorp.historiasClinicas.app.frontend.controller.DashboardController;
import ar.santaCorp.historiasClinicas.app.frontend.controller.IViewController;
import ar.santaCorp.historiasClinicas.app.frontend.controller.LoginController;
import ar.santaCorp.historiasClinicas.app.frontend.controller.TopController;
import ar.santaCorp.historiasClinicas.app.frontend.controller.ViewsController;

/*
 *  Esta clase es para que reemplace al ViewsController original
 *  y es usada por ConsoleApp para reemplazar al ViewsController
 *  y mata la funcionalidad del ViewsController porque sino sigo teniendo dependencias
 */

public class ViewsControllerForConsole extends ViewsController {
	
		public static final String  DASHBOARD_VIEW = "DASHBOARD_VIEW";
		public static final String  LOGIN_VIEW = "LOGIN_VIEW";
		
		public static final String STATE_USER_LOGGED = "STATE_USER_LOGGED";
		public static final String STATE_USER_NOT_LOGGED = "STATE_USER_NOT_LOGGED";
		
		public SystemController systemController;
		private IViewController currentViewController;
		public TopController topController;
		
		private ArrayList navigitateHistory;

		public ViewsControllerForConsole(SystemController p_systemController)
		{
		}

		public void navigateOnLoginSuccess()
		{
		}
		private void addNavHistory(String navFinal)
		{
		}
		public boolean navigateTo(String navigateId) {
			return true;
		}		
		public void setState(String p_state)
		{
		}
}
