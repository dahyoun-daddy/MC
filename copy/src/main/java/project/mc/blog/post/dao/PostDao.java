package project.mc.blog.post.dao;

import java.util.List;

import project.mc.blog.post.domain.DTO;
import project.mc.blog.post.domain.PostDTO;
import project.mc.blog.post.domain.WorkDiv;

public interface PostDao extends WorkDiv {

	public DTO do_searchOne(DTO dto);

}
