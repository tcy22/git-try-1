package com.tcy.service;

import java.util.List;
import com.tcy.bean.Message;
import com.tcy.dao.MessageDao;

public class ListService {
		public List<Message> queryMessageList(String command,String description) {
			MessageDao messageDao = new MessageDao();
			// 查询并返回结果
			return messageDao.queryMessageList(command,description);
		}
}