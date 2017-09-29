package project.mc.blog.user.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import project.mc.commons.DTO;
import project.mc.commons.WorkDiv;

public interface UserDao extends WorkDiv {
	
	public int do_idCheck(DTO dto) throws DataAccessException;
	
	public int do_login(DTO dto) throws DataAccessException;
}
