package oms.eureka.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Integer id) {
		HttpSession session = request.getSession();
//		String sessionStr ="";
		String username = (String) session.getAttribute("userName");
		if(username==null){
			session.setAttribute("userName", "sessionwq"+id);
		}
//		{
//			sessionStr = session.getAttribute("userName").toString();
//		}
//		System.out.println("session======"+sessionStr);
		User user = loginService.getUser(id);
		return user;
	}
	
	@RequestMapping(value = "/getUsers", method = RequestMethod.GET)
	public List<User> getUsers() {
		List<User> users = loginService.getUsers();
		return users;
	}
}
