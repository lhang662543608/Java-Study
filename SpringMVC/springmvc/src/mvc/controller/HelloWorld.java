package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/say")
public class HelloWorld {

	public static final String SUCCESS = "success";

	@RequestMapping(value = "/helloworld", method = RequestMethod.GET)
	public String helloWorld() {
		System.out.println("success!");
		return SUCCESS;
	}
}
