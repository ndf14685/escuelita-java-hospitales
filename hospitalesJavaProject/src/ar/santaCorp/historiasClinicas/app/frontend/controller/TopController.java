package ar.santaCorp.historiasClinicas.app.frontend.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ar.santaCorp.historiasClinicas.app.frontend.view.LoginView;
import ar.santaCorp.historiasClinicas.app.frontend.view.TopView;
import ar.santaCorp.historiasClinicas.app.entity.UserVO;
import ar.santaCorp.historiasClinicas.app.frontend.view.IView;



//public class TopController extends JPanel{
public class TopController implements IViewController , ActionListener{
	private ViewsController viewsController;
	private TopView view;
	
	

	public TopController(ViewsController p_viewsController)
	{
		//super(new FlowLayout(SwingConstants.LEADING, 10, 10));
		this.viewsController = p_viewsController;
		this.view =  new TopView(this);
		this.view.init();
		
		this.init();
		/*
		this._submitButton = new JButton("Entrar >");
		this._label = new JLabel();
		this._label.setBounds(50,00,100,100);
		this._label.setText("Login Pannel");
		
		
		this._username = new JTextField("",20);
		this._username.setBounds(100,300,500,40);
		
		this._password = new JTextField("",20);
		this._password.setBounds(100,400,200,40);
		*/
		/*
		add(this._label);
		add(this._submitButton);
		add(this._username);
		add(this._password);
		*/
		
	}
	
	public void init()
	{
		
		System.out.println("init TopController ");
		this.renderView();
		this.bindButtons();
	}
	
	private void bindButtons()
	{
		
		this.view.btnLogin.addActionListener((ActionListener) this);
		this.view.btnLogout.addActionListener((ActionListener) this);
		this.view.btnDashboard.addActionListener((ActionListener) this);
		
	}

	

	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==this.view.btnLogin)
		{
			System.out.println("Aprete el boton del login");
			this.viewsController.navigateTo(ViewsController.LOGIN_VIEW);
		}else if(e.getSource()==this.view.btnLogout)
		{
			System.out.println("Aprete el boton del logout");
			this.viewsController.systemController.tryUserLogOut();
			//this.viewsController.navigateTo(ViewsController.LOGIN_VIEW);
			
		}else if(e.getSource()==this.view.btnDashboard)
		{
			System.out.println("Aprete el boton del dashboard");
			this.viewsController.navigateTo(ViewsController.DASHBOARD_VIEW);
		}
		
		
		//this.destroy();
		//this.navigateController.systemController.closeApp();
		
	}
	
	public void onUserLogIn(UserVO p_userVo)
	{
		this.view.userInfoLabel.setText("Bienvenido"+p_userVo.getNombre()+" "+p_userVo.getApellido());
		this.view.btnLogout.setVisible(true);
		this.view.btnLogin.setVisible(false);
	}
	
	public void onUserLogOut()
	{
		this.view.userInfoLabel.setText("");
		this.view.btnLogout.setVisible(false);
		this.view.btnLogin.setVisible(true);
	}
	
	public void renderView() {
		System.out.println("TopView -> render()");

		//this.sectionContainer.add(contentPane,BorderLayout.CENTER);
		
		
		this.viewsController.systemController.myAppWindow.renderTop(this.view);
		
	}
	public void destroy() {
		//this.view.destroy();
		//this.navigateController.systemController.myAppWindow.removeSection(this.view);
	}
}


