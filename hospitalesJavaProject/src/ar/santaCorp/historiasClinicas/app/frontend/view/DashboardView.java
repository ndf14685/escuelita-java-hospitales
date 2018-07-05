package ar.santaCorp.historiasClinicas.app.frontend.view;

import javax.swing.BoxLayout;
import javax.swing.JApplet;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.santaCorp.historiasClinicas.app.frontend.controller.ViewsController;
import ar.santaCorp.historiasClinicas.app.frontend.controller.IViewController;

import javax.swing.JLabel;
import javax.swing.JTextPane;

public class DashboardView extends RenderView implements IView {
	
	private JPanel jpanelContainer;
	private IViewController viewController;
	public JButton btnGetHospitalsBO;
	public JLabel lblTitle;
	public JButton btnGetPacientesHospitales;
	
	public DashboardView(IViewController p_viewController) {
		
		this.viewController = p_viewController;
		setLayout(null);
		
		
		
		
		this.setBackground(Color.RED);
		
		this.lblTitle = new JLabel("DASHBOARD VIEW");
		this.lblTitle.setBounds(10, 11, 430, 14);
		add(this.lblTitle);
		
		this.btnGetHospitalsBO = new JButton("actualizar hospitales");
		this.btnGetHospitalsBO.setBounds(10, 36, 170, 23);
		add(this.btnGetHospitalsBO);
		
		JTextPane txtpnObtieneUnListado = new JTextPane();
		txtpnObtieneUnListado.setText("Obtiene un listado de hospitales de un sistema externo y los guarda en la base de datos de la aplicacion");
		txtpnObtieneUnListado.setBounds(10, 70, 170, 111);
		add(txtpnObtieneUnListado);
		
		btnGetPacientesHospitales = new JButton("Obtener Pacientes Hospitales");
		btnGetPacientesHospitales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGetPacientesHospitales.setBounds(219, 36, 201, 23);
		add(btnGetPacientesHospitales);
		
		JTextPane txtpnRecorreTodosLos = new JTextPane();
		txtpnRecorreTodosLos.setText("Recorre todos los hospitales de la base de datos y actualiza la info de sus pacientes");
		txtpnRecorreTodosLos.setBounds(219, 70, 201, 111);
		add(txtpnRecorreTodosLos);

		
		
	}
	
	public void init()
	{
		
		super.init();
		this.createViewContent();
		this.render();
		
	}
	
	private void createViewContent()
	{
		
	}
	
	public void render() {
		
		//navigateController.systemController.myAppWindow.renderNewSection(this);
		System.out.println("DashboardView -> render()");
	}

	
	public void destroy() {
		
		
		this.viewController = null; 
		this.lblTitle = null;
		this.btnGetHospitalsBO = null;
		/*
		this.removeAll();
		this.repaint();
		*/
		/*
		this.navigateController = null; 
		this.textField = null;
		this.btnSubmit = null;
		*/
	}
	
	public JPanel getContainer()
	{
		return this;
	}
}
