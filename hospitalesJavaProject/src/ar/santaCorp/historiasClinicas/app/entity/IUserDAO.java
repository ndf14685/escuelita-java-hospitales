package ar.santaCorp.historiasClinicas.app.entity;
import java.util.List;

public interface IUserDAO {
	//declaración de métodos para acceder a la base de datos
	public List<UserVO> getUsers();
	public UserVO create(UserVO userVO);
	public UserVO select(int id);
	public UserVO update(UserVO userVO);
	public boolean delete(UserVO userVO);
}

//create, read, update, delete