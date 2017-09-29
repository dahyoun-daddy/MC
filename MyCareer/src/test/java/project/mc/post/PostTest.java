package project.mc.post;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
	
//	int post_id        ; //포스트 id
//	int blog_id        ; //소속 블로그 id
//	int sup_post_id    ; //상위 게시글 id
//	String post_title  ; //제목
//	String post_content; //내용
//	String reg_id      ; //작성자 id
//	String reg_dt      ; //작성일자
//	String mod_id      ; //수정자 id
//	String mod_dt      ; //수정일자
//	int del_flag       ; //삭제 플래그
	
	
	
	@Test
	@Ignore
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
	
	
	@Test
	public void do_Save() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/post_doSave.do")
				.param("blog_id", "3")
				.param("post_title", "포스트 제목1")
				.param("post_content", "포스트 내용1")
				.param("reg_id", "등록자")
				.param("workDiv", "do_save")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	
//	int post_id        ; //포스트 id
//	int blog_id        ; //소속 블로그 id
//	int sup_post_id    ; //상위 게시글 id
//	String post_title  ; //제목
//	String post_content; //내용
//	String reg_id      ; //작성자 id
//	String reg_dt      ; //작성일자
//	String mod_id      ; //수정자 id
//	String mod_dt      ; //수정일자
//	int del_flag       ; //삭제 플래그
	
	@Test
	@Ignore
	public void do_Update() throws Exception{
		MockHttpServletRequestBuilder createMessage = post("/blog/post/post_do_Update.do")
				.param("post_id", "99")
				.param("blog_id", "111")
				.param("post_title", "수정된 제목111")
				.param("post_content", "수정된 내용111")
				.param("mod_id", "수정자")
				;

		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
	}
	
	@Test
	@Ignore
	public void do_search() throws Exception{
		MockHttpServletRequestBuilder createMessage = get("/blog/post/post_doSearch.do")
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
	

	
	
	@Test
	@Ignore
	public void do_selectOne() throws Exception {
		//param
		MockHttpServletRequestBuilder createMessage = post("/blog/post/post_doSelectOne.do")
				.param("post_id", "99")
				;
		mockMvc.perform(createMessage)
				.andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andDo(print()
				);
				
	}
	
	
	
}
