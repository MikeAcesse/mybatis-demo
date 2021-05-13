package com.fzk.utils;

import java.sql.*;

/**
 * @author fanzk
 * @version 1.8
 * @date 2021/5/13 10:50
 */
public class JDBCTest {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement =null;
		ResultSet rs = null;

		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");   //缺点：1.每次加载连接，2，驱动名称硬编码
			//获取连接
			String url = "jdbc:mysql://127.0.0.1:3308/ssmdemo";
			String user = "root";
			String password="123456"; // 缺点：1.每次都要获取连接 2. 连接信息硬编码
			connection = DriverManager.getConnection(url,user,password);

			//获取statement,preparedStatement
			String sql = "select * from tb_user where id=?";
			preparedStatement = connection.prepareStatement(sql);   //缺点：sql 和java 代码耦合
			//设置参数
			preparedStatement.setLong(1,1L); //缺点： 1.参数类型需要手动判断，2 需要判断下标，3。手动设置参数
			//执行查询
			rs = preparedStatement.executeQuery();
			//处理结果集
			while(rs.next()){
				StringBuilder sb = new StringBuilder();    //缺点： 1.结果集中的数据类型需要手动判断 2. 下标或列名需要手动判断
				sb.append("record: [ ");
				sb.append(rs.getString("user_name"));
				sb.append('-');
				sb.append(rs.getString("name"));
				sb.append('-');
				sb.append(rs.getInt("age"));
				sb.append('-');
				sb.append(rs.getDate("birthday"));
				sb.append(" ]");
				System.out.println(sb.toString());
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			//关闭连接，释放资源
			if(rs !=null){  //缺点： 每次都要打开或关闭连接，浪费资源
				rs.close();
			}
			if(preparedStatement !=null){
				preparedStatement.close();
			}
			if(connection !=null){
				connection.close();
			}
		}

	}
}
