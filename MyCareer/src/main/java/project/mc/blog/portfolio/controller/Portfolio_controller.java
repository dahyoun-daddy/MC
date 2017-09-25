package project.mc.blog.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Portfolio_controller {

	@RequestMapping(value="blog/portfolio.do", method = RequestMethod.GET)
	public String portfolio_view() {
		System.out.println("비교용 출력 1111111");
		return "blog/portfolio/portfolio";
	}
	
	@RequestMapping(value="blog/portfolio_edit.do", method = RequestMethod.GET)
	public String portfolio_edit() {
		return "blog/portfolio/portfolio_edit";
	}
}
