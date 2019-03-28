package oms.eureka.web.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import oms.eureka.web.hystrixBack.LoginServiceBack;
import oms.eureka.web.model.User;

@FeignClient(name="oms-user",fallback = LoginServiceBack.class)
public interface LoginService {
	
	@RequestMapping(method = RequestMethod.GET,value = "/getUser/{id}")
	public User getUser(@PathVariable("id") Integer id);
	
	@RequestMapping(method = RequestMethod.GET,value = "/getUsers")
	public List<User> getUsers();
	
}
