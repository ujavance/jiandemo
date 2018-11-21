package com.uj.jian.test;

import com.uj.jian.bean.Follower;
import com.uj.jian.bean.Tag;
import com.uj.jian.utils.SingletonLogger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 使用Spring测试模块提供的测试请求功能，测试curd请求的正确性
 * Spring4测试的时候，需要servlet3.0的支持
 * @author lfy
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml",
		"file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml" })
public class MvcTest {
	// 传入Springmvc的ioc
	@Autowired
	WebApplicationContext context;
	// 虚拟mvc请求，获取到处理结果。
	MockMvc mockMvc;

	@Before
	public void initMokcMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void testPage() throws Exception {
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user/1")).andDo(MockMvcResultHandlers.print())
				.andReturn();
		//请求成功以后，请求域中会有pageInfo；我们可以取出pageInfo进行验证
		MockHttpServletRequest request = result.getRequest();
	}

    @Value("${img.url}")
    private String imgUrl;

	@Test
	public void testCheckUserInfo() throws Exception{
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/user").param("username", "hujin").param( "password", "hj123")).andDo(MockMvcResultHandlers.print())
				.andReturn();
    }
    @Test
	public void testCheckUserName() throws Exception{
	    MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/user").param("username", "hujin")).andDo(MockMvcResultHandlers.print())
				.andReturn();
    }
    /*注册判断*/
    @Test
    public void testRegisterUser() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/user").param("username", "LaoMa").param("password", "lm333")).andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /*注册判断*/
    @Test
    public void testCommentOfArticle() throws Exception{
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("//comment").param("id", "2")).andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    /*tags测试*/
	@Test
	public void testgetTags() throws Exception{
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/like").param("userId", String.valueOf(1)).param("articleId", String.valueOf(1))).andDo(MockMvcResultHandlers.print())
				.andReturn();
	}
}
