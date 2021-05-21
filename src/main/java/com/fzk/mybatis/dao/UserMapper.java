package com.fzk.mybatis.dao;

import com.fzk.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/5/18 16:58
 */
public interface UserMapper {
	/**
	 * 登录（直接使用注解指定传入参数名称）
	 * @param userName
	 * @param password
	 * @return
	 */
	public User login(@Param("userName")String userName,@Param("password") String password);

	/**
	 * 根据表名查询用户信息（直接使用注解指定传入参数名称）
	 * @param tableName
	 * @return
	 */
	public List<User> queryUserByTableName(@Param("tableName") String tableName);
	public List<User> queryUserByTableName1(@Param("tableName1") String tableName);

	/**
	 * 根据Id 查询用户信息
	 * @param id
	 * @return
	 */
	public User queryUserById(Long id);

	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<User> queryUserAll();

	/**
	 * 新增用户
	 * @param user
	 */
	public void insertUser(User user);

	/**
	 * 根据id 更新用户信息
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 *  根据id 删除用户信息
	 * @param id
	 */
	public void deleteUserById(Long id);

	/**
	 * 场景：查询男性用户，如果输入了姓名，则按姓名查询
	 * @param name
	 * @return
	 */
	List<User> queryUserList(@Param("name") String name);
	//场景：查询男性用户，如果输入了姓名则按照姓名模糊查找，否则如果输入了年龄则按照年龄查找，否则查找姓名为“鹏程”的用户。
	List<User> queryUserListByNameOrAge(@Param("name") String name,@Param("age") Integer age);
	//场景一：查询所有用户，如果输入了姓名按照姓名进行模糊查询，如果输入年龄，按照年龄进行查询，如果两者都输入，两个条件都要成立。
	List<User> queryUserListByNameAndAge(@Param("name") String name,@Param("age") Integer age);
	//按照多个id查询用户信息
	List<User> queryUserListByIds(@Param("ids") String[] ids);


























}
