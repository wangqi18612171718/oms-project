package oms.eureka.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import oms.eureka.web.model.User;
import oms.eureka.web.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public User getHello(@PathVariable Integer id) {
		User user = loginService.getUser(id);
		System.out.println("测试访问");
		return user;
	}
}
