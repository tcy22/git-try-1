package com.tcy.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
/*
 * 访问数据库连接
 * */
public class DBUtil {
	
	public SqlSession getSqlSession() throws IOException {
		//通过配置文件获取数据库连接信息
		Reader reader=Resources.getResourceAsReader("com/tcy/config/Mybatis-congfig.xml");
	    //通过配置信息构建一个SqlSessionFactory
		SqlSessionFactory SqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
	    //打开数据库会话
		SqlSession sqlSession=SqlSessionFactory.openSession();
		
		return sqlSession;
	}
}
