package oms.eureka.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oms.eureka.user.model.User;
import oms.eureka.user.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	@RequestMapping("getUsers")
	public List<User> getUsers() {
		List<User> users = userService.getUsers();
		return users;
	}
	
	@RequestMapping("getUser/{id}")
	public User getUser(@PathVariable int id) {
		User user = userService.findById(id);
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
