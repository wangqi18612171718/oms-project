package oms.eureka.user.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import oms.eureka.user.model.User;
import oms.eureka.user.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	 /**
     * 1 在 Service 层的实现类中的方法@缓存
     * 2 指定缓存的 key，为 wiselyKeyGenerator 的 bean
     * 
     */
	@Override
	@Cacheable(value = "findById",keyGenerator = "wiselyKeyGenerator")
	public User findById(Integer id) {
		User user = userRepository.findOne(id);
		return user;
	}

	@Override
	@Transactional
	@Modifying
	@CacheEvict(value = "findById",keyGenerator = "wiselyKeyGenerator")
	public void deleteUser(Integer id) {
		userRepository.delete(id);
	}

	@Override
	@Modifying
	@Transactional
	@CachePut(value = "findById",keyGenerator = "wiselyKeyGenerator")
	public User updateUser(Integer id) {
		User user = userRepository.findOne(id);
		user.setName("wangfang");
		user = userRepository.save(user);
		return user;
	}

	
}
