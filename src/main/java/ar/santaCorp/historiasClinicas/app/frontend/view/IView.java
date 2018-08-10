package ar.santaCorp.historiasClinicas.app.frontend.view;

import javax.swing.JPanel;

public interface IView {
    
    // this (object calling isLargerThan)
    // and other must be instances of 
    // the same class returns 1, 0, -1 
    // if this is greater than, 
    // equal to, or less than other
	public void render();
	public void destroy();
}