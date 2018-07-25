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

import ar.santaCorp.historiasClinicas.app.frontend.view.LoginView;
import ar.santaCorp.historiasClinicas.app.frontend.view.IView;



//public class LoginController extends JPanel{
public class LoginController implements IViewController , ActionListener{
	private ViewsController navigateController;
	private LoginView view;
	public static final boolean AUTH_REQUIRED = false;
	

	public LoginController(ViewsController p_navigateController)
	{
		//super(new FlowLayout(SwingConstants.LEADING, 10, 10));
		this.navigateController = p_navigateController;
		this.view =  new LoginView(this);
		this.view.init();
		
		this.init();
		
		
	}
	
	public void init()
	{
		
		System.out.println("init LoginController ");
		this.renderView();
		this.bindButtons();
	}
	
	private void bindButtons()
	{
		
		this.view.btnSubmit.addActionListener((ActionListener) this);
	}

	
	
	public void actionPerformed(ActionEvent e)
	{
		
		//this.navigateController.systemController.closeApp();
		this.submitButton();
		
	}
	 
	
	
	private void submitButton()
	{
		
		
		
		String username = this.view.userName_TextField.getText();
		String password = this.view.password_TextField.getText();
		
		if(username.equals("") || password.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Olvido ingresar el usuario o password");
		}else
		{
			this.view.warning_Label.setText("* aguarde");
			if(this.navigateController.systemController.getUserBO().tryLogUser(username, password))
			{
				this.view.warning_Label.setText(":O) el usuario se logeo correctamente");
				this.navigateController.navigateOnLoginSuccess();
			}else
			{
				this.view.warning_Label.setText("");
				JOptionPane.showMessageDialog(null, "El usuario o clave son incorrectos");
			}
		}
		
		
		
		//
	}
	
	private JPanel contentPane;
	
	public void renderView() {
		System.out.println("LoginView -> render()");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBackground(Color.darkGray);
		contentPane.setBounds(100, 100, 450, 300);
		//this.sectionContainer.add(contentPane,BorderLayout.CENTER);
		
		
		this.navigateController.systemController.myAppWindow.renderNewSection(this.view);
		
	}
	public void destroy() {
		this.view.destroy();
		this.navigateController.systemController.myAppWindow.removeSection(this.view);
	}
}


