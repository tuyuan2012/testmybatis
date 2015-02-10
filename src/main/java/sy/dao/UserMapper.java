package sy.dao;

import java.util.List;

import sy.model.User;

public interface UserMapper {
	/*
	 * 默认只生成增、删、改、查，而且查只是返回一个默认的对象
	 */
	int deleteByPrimaryKey(String id);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(String id);//这个查还只是返回一个对象

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	List<User> getAll();

	List<User> getAll2();

	List<User> getAll3();
	
	//让用户这个对象直接拥有角色的这个列表（用户和角色，是多对的关系）
	List<User> getAll4();
}