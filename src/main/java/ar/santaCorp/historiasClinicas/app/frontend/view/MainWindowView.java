package ar.santaCorp.historiasClinicas.app.frontend.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

public class MainWindowView extends JFrame {
	
	public static final int  STAGE_WIDTH = 800;
	public static final int  STAGE_HEIGHT = 600;
	public static final int  TOP_HEIGHT = 100;
	public static final int  FOOTER_HEIGHT = 100;
	
	//private JFrame currentSection;
	private JPanel sectionContainer;
	private JPanel menuContainer;
	private JTextField textField;
	
	public MainWindowView() {
		/*
		this.sectionContainer = new JFrame();
		this.sectionContainer.setLayout(new BorderLayout());
		this.sectionContainer.setBounds(0, 0, 800, 600);
		this.sectionContainer.setVisible(true);
		*/
		
		this.sectionContainer = new JPanel();
		sectionContainer.setBackground(Color.RED);
		this.sectionContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.sectionContainer);
		setVisible(true);
		this.sectionContainer.setLayout(null);
		//this.sectionContainer.setVisible(true);
		
		setBounds(0, 0, MainWindowView.STAGE_WIDTH, MainWindowView.STAGE_HEIGHT);
		
		
		
		
	}

	private JPanel contentPane;

	
	public void MainWindowView()
	{
		
	}
	
	

	/**
	 * Create the frame.
	 */
	public void initialize() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		//setTitle("Escuelita Java | Historias Clinicas");
		
	} 
	

	
	public void renderTop(JPanel _panel) {
		_panel.setBounds(0, 0, MainWindowView.STAGE_WIDTH, MainWindowView.TOP_HEIGHT);
		
		System.out.println("agrego la seccion:"+_panel);
		this.sectionContainer.add(_panel,BorderLayout.CENTER);
	}
	
	public void renderNewSection(JPanel _panel) {
		
		/*
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.setBackground(Color.darkGray);
		contentPane.setBounds(100, 100, 450, 300);
		this.sectionContainer.add(contentPane,BorderLayout.CENTER);
		*/
		_panel.setBounds(0, MainWindowView.TOP_HEIGHT, MainWindowView.STAGE_WIDTH, MainWindowView.STAGE_HEIGHT-MainWindowView.TOP_HEIGHT-MainWindowView.FOOTER_HEIGHT);
		
		
		this.sectionContainer.add(_panel,BorderLayout.CENTER);
		//_panel.setVisible(true);
		this.repaint();
		//this.sectionContainer.repaint();
		
		//this.sectionContainer.getContentPane().add(_panel);
		//_panel.setLocation(150, 150);
	}
	public void removeSection(JPanel _panel) {
		this.sectionContainer.remove(_panel);
		this.repaint();
	}

}
