package sy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sy.dao.UserMapper;
import sy.model.User;

//通过@Service注解，将该类放到Spring上下文环境中，告诉Spring，我这个类是一个Bean，并加入到Spring环境中
//你这个userService在程序启动时，spring自动扫描时，就会自动添加到spring容器中（即，spring上下文中）
@Service("userService")
public class UserServiceImpl implements UserServiceI {

	/*
	 * 这些DAO只写了interface，不需要写实现类
	 */
	private UserMapper userMapper;//操作数据库，其实就是DAO，就是Mapper（自动生成的就是这种命名规则，它不需要实现类！）

	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		//通过@Autowired将userMapper注入到service中
		//通过Spring将Service注入到Spring容器中（上下文中）
		this.userMapper = userMapper;
	}

	@Override
	public User getUserById(String id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Override
	public List<User> getAll2() {
		return userMapper.getAll2();
	}

	@Override
	public List<User> getAll3() {
		return userMapper.getAll3();
	}

}
