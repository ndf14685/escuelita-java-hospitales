package ar.santaCorp.historiasClinicas.app.entity;

import java.awt.List;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.crypto.Data;

import ar.santaCorp.historiasClinicas.app.SystemController;
import ar.santaCorp.historiasClinicas.util.FileManager;
import com.google.gson.*;

public class UserBO {
	private boolean isAuth = false;
	private SystemController systemController;
	private UserVO userVo;
	private UserDAOImp userDAO;
	
	public UserBO(SystemController p_systemController)
	{
		this.systemController = p_systemController;
		this.userDAO = new UserDAOImp();
	}
	
	
	public boolean getIsAuth()
	{
		return this.isAuth;
	}
	
	public boolean logUser(String usuario, String password)
	{
		
		return this.getIsAuth();
	}
	public boolean tryLogUser(String username, String password)
	{
		
		UserVO loggedUser = userDAO.selectByUsernamePassword(username, password);
		if(loggedUser!=null)
		{
			this.userVo = loggedUser;
			this.isAuth=true;
			System.out.println("se logeo un nuevo usuario:"+this.userVo.toString()+"::::::this.isAuth="+this.isAuth);
			this.userDAO.createUserSession(this.userVo);
			this.systemController.onUserLogged();
		}
		
		return this.getIsAuth();
	}
	
	

	public boolean trySetPersistUser()
	{
		UserVO tmpUserVo = this.userDAO.selectUserSession();
		if(tmpUserVo!=null)
		{
			this.userVo = tmpUserVo;
			this.isAuth = true;
			this.systemController.onUserLogged();	
			return true;
		}
		return false;
	}
	
	public boolean userLogOut()
	{
		this.userDAO.deleteUserSession();
		this.isAuth = false;
		this.userVo = null;
		this.systemController.onUserLoggedOut();
		return true;
	}
	
	public UserVO getLoggedUser()
	{
		return this.userVo;
	}
}
