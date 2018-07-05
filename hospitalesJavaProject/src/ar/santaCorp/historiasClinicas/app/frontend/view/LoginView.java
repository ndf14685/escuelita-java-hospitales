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

public class LoginView extends RenderView implements IView {
	
	private JPanel jpanelContainer;
	private IViewController viewController;
	public JTextField userName_TextField;
	public JButton btnSubmit;
	public JTextField password_TextField;
	public JLabel warning_Label;
	/**
	 * Create the applet.
	 */
	public LoginView(IViewController p_viewController) {
		
		this.viewController = p_viewController;
		setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(45, 46, 46, 14);
		add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(45, 85, 46, 14);
		add(lblPassword);
		
		password_TextField = new JTextField();
		password_TextField.setText("admin");
		password_TextField.setBounds(124, 82, 86, 20);
		add(password_TextField);
		password_TextField.setColumns(10);
		
		
		userName_TextField = new JTextField();
		userName_TextField.setText("admin");
		userName_TextField.setToolTipText("usuario");
		userName_TextField.setBounds(124, 43, 86, 20);
		this.add(userName_TextField);
		userName_TextField.setColumns(10);
		
		btnSubmit = new JButton("Enviar");
		btnSubmit.setBounds(124, 148, 65, 23);
		this.add(btnSubmit);
		
		warning_Label = new JLabel("");
		warning_Label.setForeground(Color.RED);
		warning_Label.setBounds(45, 122, 406, 14);
		add(warning_Label);
		
		
		

		
		
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
		System.out.println("LoginView -> render()");
	}

	
	public void destroy() {
		
		
		this.viewController = null; 
		this.userName_TextField = null;
		this.btnSubmit = null;
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
