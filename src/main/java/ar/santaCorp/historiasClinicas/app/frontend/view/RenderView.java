package ar.santaCorp.historiasClinicas.app.frontend.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class RenderView extends JPanel implements IView{

	
	public void init()
	{
		setBorder(new EmptyBorder(5, 5, 5, 5));
		//setContentPane(contentPane);
		setLayout(null);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(Color.WHITE);
	}
	
	public void render() {
		// add(_pannel);
	}
	
	
	public void destroy() {}
}


