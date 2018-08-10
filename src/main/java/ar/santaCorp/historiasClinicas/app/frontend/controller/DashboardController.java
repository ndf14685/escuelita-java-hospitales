package ar.santaCorp.historiasClinicas.app.frontend.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.santaCorp.historiasClinicas.app.frontend.view.DashboardView;
import ar.santaCorp.historiasClinicas.app.frontend.view.IView;



//public class DashboardController extends JPanel{
public class DashboardController implements IViewController , ActionListener{
	private ViewsController viewsController;
	private DashboardView view;
	public static final boolean AUTH_REQUIRED = true;  
	

	public DashboardController(ViewsController p_viewsController)
	{
		//super(new FlowLayout(SwingConstants.LEADING, 10, 10));
		this.viewsController = p_viewsController;
		this.view =  new DashboardView(this);
		this.view.init();
		
		this.init();
	}
	
	public void init()
	{
		
		System.out.println("init DashboardController ");
		this.renderView();
		this.bindButtons();
	}
	
	private void bindButtons()
	{
		
		this.view.btnGetHospitalsBO.addActionListener((ActionListener) this);
		this.view.btnGetPacientesHospitales.addActionListener((ActionListener) this);
		
	}

	
	
	public void actionPerformed(ActionEvent e)
	{
		
		
	
			if(e.getSource()==this.view.btnGetHospitalsBO)
			{
				this.getHospitalsDataSource();
			}else if(e.getSource()==this.view.btnGetPacientesHospitales)
			{
				this.getPacientesHospitalsDataSource();
				
			}
			
		//this.navigateController.systemController.closeApp();
		
		
	}
	 
	
	
	private void getHospitalsDataSource()
	{
		this.viewsController.systemController.getHospitalBO().processHospitalPath();
	}
	
	private void getPacientesHospitalsDataSource()
	{
		// tiene que recorrer todos los hospitales, abrirlos, y obtener la ruta de sus pacientes
		this.viewsController.systemController.getHospitalBO().processGetPacientesHospitalesDataSource();
		// luego pasa la info a pacientes BO para que cree sus pacientes y tenga su propia logica de negocio
		
	}
	private JPanel contentPane;
	
	public void renderView() {
		System.out.println("DashboardView -> render()");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBackground(Color.darkGray);
		contentPane.setBounds(100, 100, 450, 300);
		//this.sectionContainer.add(contentPane,BorderLayout.CENTER);
		
		
		this.viewsController.systemController.myAppWindow.renderNewSection(this.view);
		
	}
	public void destroy() {
		this.view.destroy();
		this.viewsController.systemController.myAppWindow.removeSection(this.view);
	}
}


