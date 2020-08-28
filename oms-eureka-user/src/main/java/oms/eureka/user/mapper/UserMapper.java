package oms.eureka.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import oms.eureka.user.model.User;

@Mapper
public interface UserMapper {
	/**
	 * 调用mybatis中的mapper获取用户信息
	 * @return
	 */
	List<User> queryAllUsers();
	
	@Select("select * from user")
	List<User> selectAllUsers();
	
	//带参数的查询
	@Select("select * from user where username like concat('%',#{name},'%')")
    List<User> getUsersByName(String name);
	
	//修改
	@Update("update user set name=#{name},code=#{code} where id=#{id}")
    Integer updateUserById(User user);
	
	//删除
	@Delete("delete from user where id=#{id}")
    Integer deleteUserById(Integer id);
}
