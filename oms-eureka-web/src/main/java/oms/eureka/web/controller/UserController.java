package oms.eureka.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/getindex")
	public String getindex(HttpServletRequest request){
		return "users";
	}
}
