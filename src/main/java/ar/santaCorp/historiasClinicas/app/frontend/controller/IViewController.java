package ar.santaCorp.historiasClinicas.app.frontend.controller;

public interface IViewController {
	public static final boolean AUTH_REQUIRED = false;
	public void renderView();
	public void destroy();
}


