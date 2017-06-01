package cn.alittler.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
