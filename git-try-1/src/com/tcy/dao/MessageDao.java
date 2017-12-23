package com.tcy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.tcy.bean.Message;
import com.tcy.db.DBUtil;

public class MessageDao {
	
	/**
	 * 根据查询条件查询消息列表的条数
	 */
	public int count(Message message) {
		DBUtil dbUtil=new DBUtil();
		SqlSession sqlSession = null;
		int result = 0;
		try {
			sqlSession = dbUtil.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			result = imessage.count(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return result;
	}
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter) {
		DBUtil dbUtil=new DBUtil();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbUtil.getSqlSession();
			// 通过sqlSession执行SQL语句
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			messageList = imessage.queryMessageListByPage(parameter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
	}
	
	/*单条删除*/
	public void deleteOne(int id) {
		DBUtil dbUtil=new DBUtil();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbUtil.getSqlSession();
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			imessage.deleteOne(id);
			/*sqlSession.delete("IMessage.deleteOne",id);*/
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}		
	}
	
	public void deleteBatch(List<Integer> ids) {
		DBUtil dbUtil=new DBUtil();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbUtil.getSqlSession();
			IMessage imessage = sqlSession.getMapper(IMessage.class);
			imessage.deleteBatch(ids);
			//sqlSession.delete("IMessage.deleteBatch",ids);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
				sqlSession.close();
			}
		}			
	}
}
