package com.fzk.mybatis.impl;

import com.fzk.mybatis.dao.UserDao;
import com.fzk.mybatis.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/5/17 16:48
 */
public class UserDaoImpl implements UserDao {

	public SqlSession sqlSession;

	public UserDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public User queryUserById(Long id) {
		return this.sqlSession.selectOne("UserDao.queryUserById",id);
	}

	public List<User> queryUserAll() {
		return this.sqlSession.selectList("UserDao.queryUserAll");
	}

	public void insertUser(User user) {
         this.sqlSession.insert("UserDao.insertUser",user);
	}

	public void updateUser(User user) {
         this.sqlSession.update("UserDao.updateUser",user);
	}

	public void deleteUser(Long id){
		this.sqlSession.delete("UserDao.deleteUser",id);
	}

}
