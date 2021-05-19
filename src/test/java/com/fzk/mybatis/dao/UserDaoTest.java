package com.fzk.mybatis.dao;

import com.fzk.mybatis.impl.UserDaoImpl;
import com.fzk.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sun.java2d.pipe.SpanIterator;

import javax.swing.text.StyledEditorKit;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/5/17 18:39
 */
public class UserDaoTest {
	public UserDao userDao;
	public SqlSession sqlSession;

	@Before
	public void setUp() throws Exception {
		String resource = "mybatis-config.xml";
		//读取配置文件
		InputStream is = Resources.getResourceAsStream(resource);
		//构建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		//获取sqlSession
		sqlSession = sqlSessionFactory.openSession();
		this.userDao = new UserDaoImpl(sqlSession);
	}

	@Test
	public void queryUserById() {
		System.out.println(userDao.queryUserById(new Long(1)));
	}

	@Test
	public void queryUserAll() {
		List<User> userList = userDao.queryUserAll();
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	public void insertUser() {
		User user = new User();
		user.setAge(16);
		user.setBirthday(new Date("2022/05/18"));
		user.setName("马钢");
		user.setPassword("Kodak1234");
		user.setSex(1);
		user.setUserName("evan");
		userDao.insertUser(user);
		sqlSession.commit();

	}

	@Test
	public void updateUser() {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("鲸鱼");
		user.setPassword("654321");
		user.setSex(2);
		user.setUserName("evanjin");
		user.setId(new Long(2));
		userDao.updateUser(user);
		sqlSession.commit();
	}

	@Test
	public void deleteUser() {
		userDao.deleteUser(new Long(5));
		sqlSession.commit();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown is called.");
	}

	@Test
	public void insertUserr() {
		User user = new User();
		user.setAge(20);
		user.setBirthday(new Date("2022/05/20"));
		user.setName("mama");
		user.setPassword("123456789");
		user.setSex(1);
		user.setUserName("evan");
		userDao.insertUser(user);
		sqlSession.commit();

	}
}