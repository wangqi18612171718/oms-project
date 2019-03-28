package oms.eureka.user.service;

import java.util.List;

import oms.eureka.user.model.User;

public interface IUserService {

	public User findById(Integer id);
	
	public void deleteUser(Integer id);
	
	public User updateUser(Integer id);

	List<User> getUsers();
}
