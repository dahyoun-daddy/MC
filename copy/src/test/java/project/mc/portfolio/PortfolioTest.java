package project.mc.portfolio;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import project.mc.blog.portfolio.domain.PortfolioVO;
import project.mc.blog.portfolio.service.PortFolioSvcImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PortfolioTest {
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		log.debug("=====================");
		log.debug("ctx: "+ctx.toString());
		log.debug("=====================");
		
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.debug("=====================");
		log.debug("mockMvc: "+mockMvc.toString());
		log.debug("=====================");
	}
	
	@Test
	public void test() {
		//접속중인 유저의 user_id
		//String login_id = (String)session.getAttribute("login_id");
		
		//해당 블로그 주인의 user_id
		System.out.print("list.size:");
		String user_id = "111";
		
		PortfolioVO inVO = new PortfolioVO();
		PortFolioSvcImpl pfSvc = new PortFolioSvcImpl();
		
		inVO.setUser_id(user_id);
		System.out.print("list.size:");
		
		List<PortfolioVO> list = (List<PortfolioVO>)pfSvc.do_searchByUser_id(inVO);
		
		System.out.print("list.size:" +list.size());
		for(PortfolioVO outVO : list){
			System.out.print("outVO: "+outVO.getPf_id());
		}
		
		
	}
	
	@Test
	@Ignore
	public void portfolio_01_deleteAll() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/portfolio_deleteAll.do");

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	public void portfolio_01_delete() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/portfolio_delete.do")
				.param("pf_id", "59")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	public void portfolio_02_save() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/portfolio_save.do")
				.param("user_id", "111")
				.param("tmp_no", "3")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	public void portfolio_03_update() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/portfolio_update.do")
				.param("pf_id", "59")
				.param("user_id", "111")
				.param("tmp_no", "5")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	public void portfolio_04_search() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/portfolio_do_search.do");

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	public void portfolio_05_do_searchByPf_id() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/portfolio_do_searchByPf_id.do")
				.param("pf_id", "59")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	public void portfolio_06_do_searchByUser_id() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/portfolio_do_searchByUser_id.do")
				.param("user_id", "111")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	
//	@Test
//	public void do_selectOne() throws Exception {
//		//param
//				MockHttpServletRequestBuilder createMessage = post("/user/userForm.do")
//						.param("id", "SpMockMvc8")
//						;
//				mockMvc.perform(createMessage)
//						.andDo(print())
//						.andExpect(status().isOk())
//						.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
//						.andExpect(jsonPath("$.login", is(18)))
//						.andExpect(jsonPath("$.id", is("SpMockMvc8"))
//						);
//				
//	}
	
	
	
}
