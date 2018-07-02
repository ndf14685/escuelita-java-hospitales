package ar.santaCorp.historiasClinicas.app.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import ar.santaCorp.historiasClinicas.util.FileManager;

public class UserDAOImp implements IUserDAO{
	public void UserDAO()
	{
		
	}
	
	public ArrayList<UserVO> getUsers()
	{
		ArrayList fileLines = FileManager.getFileLines("db/sysUsers/sysadminList.json");

		ArrayList<UserVO> usersVO = new ArrayList();
		
		
		System.out.println("Listado de usuarios leido:"+fileLines.size());
		for (int i = 0; i < fileLines.size(); i++) {
			
			Gson gson = new Gson();
			String line = fileLines.get(i).toString();
			UserVO tmpUserVo = gson.fromJson(line, UserVO.class);

			usersVO.add(tmpUserVo);
			
		}
		//return this.getIsAuth();
		return usersVO;
	}
	
	public UserVO selectByUsernamePassword(String username, String password)
	{
		
		ArrayList<UserVO> sysUsers = (ArrayList) this.getUsers();
		
		for (int i = 0; i < sysUsers.size(); i++) {

			
			if(sysUsers.get(i).getUsername().equals(username) && sysUsers.get(i).getPassword().equals(password))
			{
				return sysUsers.get(i);
			}
		}
		return null;
	}
	
	public UserVO selectUserSession()
	{
		UserVO userVo;
		ArrayList fileLines = FileManager.getFileLines("db/session/loggedUser/logedUser.json");
		if(fileLines==null)
		{
			return null;
		}else
		{
			Gson gson = new Gson();
			String line = fileLines.get(0).toString();
			userVo = gson.fromJson(line, UserVO.class);
			return userVo;
		}
	}
	
	public boolean createUserSession(UserVO userVo)
	{
		Gson gson = new Gson();
		String jsonUserVo = gson.toJson(userVo);
		
		FileManager.setFile("db/session/loggedUser/logedUser.json", jsonUserVo);
		System.out.println("--------------------------------");
		System.out.println(jsonUserVo);
		System.out.println("--------------------------------");
		
		return true;
	}
	
	public UserVO create(UserVO userVO)
	{
		return null;
	}
	public UserVO select(int id)
	{
		return null;
	}
	public UserVO update(UserVO userVO)
	{
		return null;
	}
	public boolean delete(UserVO userVO)
	{
		return false;
	}
	
	public boolean deleteUserSession()
	{
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		System.out.println("==========================");
		FileManager.deleteFile("db/session/loggedUser/logedUser.json");
		return true;
	}
}
