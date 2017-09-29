package project.mc.blog.post.dao;

import java.util.List;

import project.mc.blog.post.common.DTO;
import project.mc.blog.post.common.PostDTO;
import project.mc.blog.post.common.WorkDiv;

public interface PostDao extends WorkDiv {

	public DTO do_searchOne(DTO dto);

}
