package aa.mine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")//必须标注
public class hellocontroller {

	@RequestMapping("/hello")
	public String hello(){
		System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqq");
		return "index";
	}
}
