

import java.util.Scanner;

import ar.santaCorp.historiasClinicas.app.SystemController;
import ar.santaCorp.historiasClinicas.app.frontend.controller.ViewsController;
import ar.santaCorp.historiasClinicas.events.EventManager;
import ar.santaCorp.historiasClinicas.util.UtilClass;

public class Main {
	public static void main(String [ ] args)
	{
		SystemController systemController = new SystemController();
		systemController.initialize();		
	}
}