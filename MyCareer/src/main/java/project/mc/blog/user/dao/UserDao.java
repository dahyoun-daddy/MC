package project.mc.blog.user.dao;

import org.springframework.dao.DataAccessException;

import project.mc.commons.DTO;
import project.mc.commons.WorkDiv;

public interface UserDao extends WorkDiv {
	
	public int id_check(DTO dto) throws DataAccessException;
}
