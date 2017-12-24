package com.tcy.dao;

import java.util.List;
import java.util.Map;

import com.tcy.bean.Message;


/**
 * 与Message配置文件相对应的接口
 */
public interface IMessage {
	
	/**
	 * 拦截器实现分页查询消息列表
	 */
	public List<Message> queryMessageListByIntercept(Map<String,Object> parameter);
	
	//查询总条数目
	public int count(Message message);
	
	/**
	 * 根据查询条件分页查询消息列表
	 */
	public List<Message> queryMessageListByPage(Map<String,Object> parameter);
	
	//单条删除
	public void deleteOne(int id);
	
	//多条删除
	public void deleteBatch(List<Integer> ids);	
	
	
}
