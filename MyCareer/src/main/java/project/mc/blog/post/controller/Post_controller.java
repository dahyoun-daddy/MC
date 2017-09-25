package project.mc.blog.post.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Post_controller {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping(value="blog/post.do", method=RequestMethod.GET)
	public String postStart() {
		log.debug("blog start");
		
		
		
		
		return "blog/post/post";
	}
	
	
}
