package project.mc.user;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.http.HttpServletRequest;

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

import project.mc.blog.user.domain.UserVO;
import project.mc.blog.user.service.UserSvc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserTest {
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
	
	
	@Test
	@Ignore
	public void login_page() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/user/login_page.do");

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	@Ignore
	public void user_register() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/user/user_register.do");

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	@Ignore
	public void do_save() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/user/do_save.do")
		.param("user_no", "1")		
		.param("user_id", "강남구")
		.param("user_password", "비번임")
		.param("user_div", "1")
		.param("user_name", "이름임")
		.param("gender", "1")
		.param("age", "14")
		.param("email", "sdkfe@naver.com")
		.param("address", "주소")
		.param("phone", "010-2155-6546")
		.param("withdraw_flag", "1")
		;
		
		mockMvc.perform(createMessage)
				.andExpect(status().is3xxRedirection())
				.andDo(print()
				);
	}
	


	@Test
	@Ignore
	public void do_delete() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/user/do_delete.do")
		.param("user_id", "나는강북구당")
		.param("withdraw_flag", "0")
		;
		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
		
	}
	
	@Test
	
	public void to_login() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/user/user_login.do")
						
				.param("user_id", "aaa")
				.param("user_password", "123")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
		
	}
	
	@Test
	@Ignore
	public void to_modify() throws Exception {
		MockHttpServletRequestBuilder createMessage = post("/user/user_modify.do")
		.param("user_password", "1234")
		.param("user_name", "깡남")
		.param("age", "11")
		.param("email", "sdkf@naver.com")
		.param("address", "강북구삼")
		.param("phone", "010-215-4515")
		.param("user_id", "나는강북구당")
		;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
		
	}
	
	
	
	
}
