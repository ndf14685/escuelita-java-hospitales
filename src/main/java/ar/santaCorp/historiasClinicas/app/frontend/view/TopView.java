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

public class TopView extends JPanel implements IView {
	
	private JPanel jpanelContainer;
	private IViewController viewController;
	public JTextField textField;
	public JButton btnLogin;
	public JButton btnDashboard;
	public JLabel userInfoLabel;
	public JButton btnLogout;
	/**
	 * Create the applet.
	 */
	public TopView(IViewController p_viewController) {
		this.viewController = p_viewController;
		setLayout(null);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.darkGray);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(0, 0, 100, 23);
		this.add(btnLogin);
		
		btnDashboard = new JButton("Dashboard");
		btnDashboard.setBounds(150, 0, 100, 23);
		this.add(btnDashboard);
		
		userInfoLabel = new JLabel("");
		userInfoLabel.setForeground(Color.WHITE);
		userInfoLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		userInfoLabel.setBounds(274, 9, 375, 14);
		add(userInfoLabel);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnLogout.setBounds(0, 0, 100, 23);
		add(btnLogout);
		btnLogout.setVisible(false);
	}
	
	public void init()
	{
		
		
		
		
	}
	
	private void createViewContent()
	{

		
	}
	
	public void render() {
		
		//navigateController.systemController.myAppWindow.renderNewSection(this);
		//System.out.println("LoginView -> render()");
	}

	
	public void destroy() {
		
		
		this.viewController = null; 
		this.textField = null;
		this.btnLogin = null;
		/*
		this.removeAll();
		this.repaint();
		*/
		/*
		this.navigateController = null; 
		this.textField = null;
		this.btnLogin = null;
		*/
	}
	
	public JPanel getContainer()
	{
		return this;
	}
}
