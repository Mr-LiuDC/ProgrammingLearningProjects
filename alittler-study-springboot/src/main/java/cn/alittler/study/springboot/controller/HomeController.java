package cn.alittler.study.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "Hello World.----这是index";
	}

	@RequestMapping("/home")
	public String home() {
		return "Hello World.----这是home";
	}

}
