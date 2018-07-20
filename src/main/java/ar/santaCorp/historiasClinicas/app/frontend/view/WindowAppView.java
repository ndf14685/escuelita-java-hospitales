package ar.santaCorp.historiasClinicas.app.frontend.view;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.JApplet;

public class WindowAppView extends JFrame{
	
	//private JWindow windowApp;
	
	public void WindowAppView()
	{
		
	}
	public void initialize()
	{
		setBounds(0,0,500,500);
		setVisible(true);
		setTitle("Escuelita Java | Historias Clinicas");
		setSize(375,667);
		setLocation(200, 200);
		setResizable(false);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public void renderNewSection(JApplet _pannel) {
		 add(_pannel);
		 
	}
}
