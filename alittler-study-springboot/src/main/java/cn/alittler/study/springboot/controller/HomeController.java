package cn.alittler.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.alittler.study.springboot.exception.MyException;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Hello World.----这是index";
	}

	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		return "Hello World.----这是home";
	}

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}

	@RequestMapping("/thymeleaf")
	public String thymeleaf(ModelMap map) {
		map.addAttribute("name", "刘德财");
		return "thymeleaf/thymeleaf";
	}

	@RequestMapping("/freemarker")
	public String freeMarker(ModelMap map) {
		map.addAttribute("name", "刘德财");
		return "freemarker/freemarker";
	}

	@RequestMapping("/error1")
	public String error1() throws Exception {
		throw new Exception("发生错误");
	}

	@RequestMapping("/json")
	public String json() throws MyException {
		throw new MyException("发生错误2");
	}

}
