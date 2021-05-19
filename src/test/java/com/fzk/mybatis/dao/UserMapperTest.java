package com.fzk.mybatis.dao;

import com.fzk.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/5/18 17:15
 * 7.4 动态代理总结
 * 使用mapper接口不用写接口实现类即可完成数据库操作，使用非常简单，也是官方所推荐的使用方法
 *使用mapper接口的必须具备以下几个条件：
 * 1） Mapper的namesapce必须和mapper接口的全路径一致
 * 2）Mapper接口的方法名必须和sql定义的id一致
 * 3）Mapper接口中方法的输入参数类型必须和sql定义的parameterType一致（不一定）
 * 4） Mapper接口中方法的输出参数类型必须和sql定义的resultType一致。
 *
 */
public class UserMapperTest {
	public UserMapper userMapper;

	@Before
	public void setUp() throws Exception {
		//指定配置文件
		String resource = "mybatis-config.xml";
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//构建sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		/**
		 * 1.  映射文件的命名空间（namespace)必须是mapper接口的全路径
		 * 2.映射文件的statement的id 必须和mapper接口的方法名保持一致
		 * 3. Statement的resultType必须和mapper接口方法的返回类型一致
		 * 4.statement的parameterType必须和mapper接口方法的参数类型一致（不一定）
		 *
		 */
		userMapper = sqlSession.getMapper(UserMapper.class);
	}

	@Test
	public void login() {
		System.out.println(userMapper.login("hj","123456"));
	}

	@Test
	public void queryUserByTableName() {
		List<User> userList = userMapper.queryUserByTableName("tb_user");
		for (User user: userList
		     ) {
			System.out.println(user);
		}
	}

	@Test
	public void queryUserById() {
		System.out.println(userMapper.queryUserById(new Long(1)));
	}

	@Test
	public void queryUserAll() {
		List<User> userList = this.userMapper.queryUserAll();
		for (User user : userList) {
			System.out.println(user);
		}
	}

	@Test
	public void insertUser() {
		User user = new User();
		user.setAge(20);
		user.setBirthday(new Date());
		user.setName("大神");
		user.setPassword("123456");
		user.setSex(2);
		user.setUserName("bigGod222");
		this.userMapper.insertUser(user);
		System.out.println(user.getId());
	}

	@Test
	public void updateUser() {
		User user = new User();
		user.setBirthday(new Date());
		user.setName("静静");
		user.setPassword("123456");
		user.setSex(0);
		user.setUserName("Jinjin");
		user.setId(new Long(1));
		this.userMapper.updateUser(user);
	}

	@Test
	public void deleteUserById() {
		userMapper.deleteUserById(new Long(1));
	}
}