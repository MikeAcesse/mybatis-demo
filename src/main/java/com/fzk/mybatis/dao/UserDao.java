package com.fzk.mybatis.dao;

import com.fzk.mybatis.pojo.User;

import java.util.List;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/5/17 16:43
 */
public interface UserDao {
	/**
	 * 根据id查询用户信息
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
	 * 插入用户信息
	 * @param user
	 */
	public void insertUser(User user);

	/**
	 *  更新用户信息
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 根据id删除用户信息
	 * @param id
	 */
	public void deleteUser(Long id);


}
