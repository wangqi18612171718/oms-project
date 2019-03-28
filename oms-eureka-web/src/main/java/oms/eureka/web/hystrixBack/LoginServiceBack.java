package oms.eureka.web.hystrixBack;

import oms.eureka.web.model.User;
import oms.eureka.web.service.LoginService;

public class LoginServiceBack implements LoginService {

	@Override
	public User getUser(Integer id) {
		System.out.println("用户服务出现异常，请检查原因。。。。。。。");
		return new User();
	}

}
