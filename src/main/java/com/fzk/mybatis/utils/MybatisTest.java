package com.fzk.mybatis.utils;

import com.fzk.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import org.apache.log4j.Logger;
/**
 * @author fanzk
 * @version 1.8
 * @date 2021/5/13 11:57
 * MyBatis使用步骤总结
 * 1)配置mybatis-config.xml 全局的配置文件 (1、数据源，2、外部的mapper)
 * 2)创建SqlSessionFactory
 * 3)通过SqlSessionFactory创建SqlSession对象
 * 4)通过SqlSession操作数据库 CRUD
 * 5)调用session.commit()提交事务
 * 6)调用session.close()关闭会话
 *
 */
public class MybatisTest {
	static Logger logger =Logger.getLogger(MybatisTest.class);
	public static void main(String[] args) throws IOException {
		//指定全局配置文件
		String resource = "mybatis-config.xml";
		//读取配置文件
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//构造sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 操作CRUD,第一个参数：指定statement, 规则是：命名空间+"."+statementID
		 * 第二个参数：指定传入sql的参数，这里是用户id
		 */
		User user;
		try {
			user = sqlSession.selectOne("MyMapper.selectUser",2);
			System.out.println(user);
			logger.debug(user);
		} finally {
			sqlSession.close();
		}
	}
}
