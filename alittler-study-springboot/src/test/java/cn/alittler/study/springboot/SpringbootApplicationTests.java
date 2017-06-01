package cn.alittler.study.springboot;

import cn.alittler.study.springboot.component.BlogProperties;
import cn.alittler.study.springboot.controller.HomeController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Test
	public void contextLoads() {
	}

	////////////////////// 模拟url请求测试 //////////////////////
	private MockMvc mvc;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
	}

	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World")));
	}

	@Test
	public void getHome() throws Exception {
		HttpHeaders headers = new HttpHeaders();  // 还是不能解决乱码问题
		headers.add("Content-Type", "application/json; charset=utf-8");
		mvc.perform(MockMvcRequestBuilders.get("/home").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World.----这是home")));
	}

	@Test
	public void getHome2() throws Exception {
		HttpHeaders headers = new HttpHeaders();  // 还是不能解决乱码问题
		headers.add("Content-Type", "application/json; charset=utf-8");
		mvc.perform(MockMvcRequestBuilders.get("/home").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().string(equalTo("Hello World.----这是home")));
	}
	////////////////////// 模拟url请求测试 //////////////////////

	////////////////////// 自定义属性测试 //////////////////////
	private static final Log log = LogFactory.getLog(SpringbootApplicationTests.class);

	@Autowired
	private BlogProperties blogProperties;

	@Test
	public void testProperties() throws Exception {
		Assert.assertEquals("程序猿DD", blogProperties.getName());
		Assert.assertEquals("Spring Boot教程", blogProperties.getTitle());
		Assert.assertEquals("程序猿DD正在努力写《Spring Boot教程》", blogProperties.getDesc());

		log.info("随机数测试输出：");
		log.info("随机字符串 : " + blogProperties.getValue());
		log.info("随机int : " + blogProperties.getNumber());
		log.info("随机long : " + blogProperties.getBignumber());
		log.info("随机10以下 : " + blogProperties.getTest1());
		log.info("随机10-20 : " + blogProperties.getTest2());
	}
	////////////////////// 自定义属性测试 //////////////////////

}
