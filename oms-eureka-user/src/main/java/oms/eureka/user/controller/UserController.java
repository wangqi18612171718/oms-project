package oms.eureka.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oms.eureka.user.model.User;
import oms.eureka.user.service.UserServiceImpl;

@RestController
@RefreshScope
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private HttpServletRequest request;
	
	@RequestMapping("getUsers")
	public List<User> getUsers() {
		List<User> users = userService.getUsers();
		return users;
	}
	
	@RequestMapping("getUser/{id}")
	public User getUser(@PathVariable int id) {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("userName");
		User user = userService.findById(id);
		System.out.println("访问端口：" + username);
		return user;
	}
	
	@RequestMapping("deleteUser/{id}")
	public String deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return "Success";
	}
	
	@RequestMapping("updateUser/{id}")
	public User updateUser(@PathVariable int id){
		User user = userService.updateUser(id);
		return user;
	}
}
