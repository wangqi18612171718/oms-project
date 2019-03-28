package oms.eureka.web.hystrixBack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import oms.eureka.web.model.User;
import oms.eureka.web.service.LoginService;

@Component
public class LoginServiceBack implements LoginService {

	@Override
	public User getUser(Integer id) {
		System.out.println("用户服务出现异常，请检查原因。。。。。。。");
		return new User();
	}

	@Override
	public List<User> getUsers() {
		System.out.println("查询所有用户用户服务出现异常，请检查原因。。。。。。。");
		return new ArrayList<User>();
	}

}
