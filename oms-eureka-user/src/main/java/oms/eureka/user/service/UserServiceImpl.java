package oms.eureka.user.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import oms.eureka.user.mapper.UserMapper;
import oms.eureka.user.model.User;
import oms.eureka.user.repository.UserRepository;
/**
 * 一般的保存修改我们可以使用JPA来操作 userRepository
 *  复杂的查询使用mybatis来操作
 * @author wangqi
 *
 */
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Cacheable(value = "getUsers",keyGenerator = "wiselyKeyGenerator")
	public List<User> getUsers() {
//		List<User> users = userRepository.findAll();
		List<User> users = userMapper.queryAllUsers();
		return users;
	}
	
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
