package project.mc.post;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostTest {
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
	@Ignore
	public void test() {
		
	}
	

	
	
	
	//@Test
	public void do_Delete() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("blog/post/post_do_Delete.do")
				.param("post_id", "59")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	
	//@Test
	public void doSave() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/post/post_doSave.do")
				.param("post_id", "111")
				.param("blog_id", "3")
				.param("post_title", "제목1")
				.param("post_content", "내용1")
				.param("reg_id", "등록자")			
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	//@Test
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
	public void do_search() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("blog/post/post_doSearch.do")
				.param("page_size", "10")
				.param("page_num", "1")
				.param("searchDiv", "")
				.param("searchWord", "");

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	

	
	
	//@Test
	public void do_selectOne() throws Exception {
		//param
				MockHttpServletRequestBuilder createMessage = post("blog/post/post_doSelectOne.do")
						.param("post_id", "11")
						.param("blog_id", "333")
						.param("sup_post_id", "22")
						.param("post_title", "제목2")
						.param("post_content", "내용2")
						.param("reg_id", "bbbb")
						.param("reg_dt", "2017-09-29")
						.param("mod_id", "")
						.param("mod_dt", "")
						.param("del_flag", "1")
						;
				mockMvc.perform(createMessage)
						.andExpect(status().isOk())
						.andExpect(status().is2xxSuccessful())
						.andDo(print()
						);
				
	}
	
	
	
}
