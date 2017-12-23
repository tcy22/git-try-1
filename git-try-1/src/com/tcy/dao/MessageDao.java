package com.tcy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.tcy.bean.Message;
import com.tcy.db.DBUtil;

public class MessageDao {
	
	/*根据查询条件查询消息列表*/
	public List<Message> queryMessageList(String command,String description){
		DBUtil dbUtil=new DBUtil();
		List<Message> messageList=new ArrayList<Message>();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbUtil.getSqlSession();
			Message message = new Message();
			message.setDescription(description);
			message.setCommand(command);
			messageList=sqlSession.selectList("IMessage.queryMessageList",message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null) {
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
			sqlSession.delete("IMessage.deleteOne",id);
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
			sqlSession.delete("IMessage.deleteBatch",ids);
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
