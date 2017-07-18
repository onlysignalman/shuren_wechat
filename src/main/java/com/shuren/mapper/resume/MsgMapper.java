package com.shuren.mapper.resume;

import java.util.List;
import java.util.Map;

import com.shuren.pojo.resume.MessageLog;

/**
 * Created by 董帮辉 on 2017-5-21.
 */
public interface MsgMapper {
	
	Long add(MessageLog msg);

	Long getMsgCount(Map<String, String> map);

	List<MessageLog> getMsgs(Map<String, String> map);

	MessageLog getLastMsg(String mobile);
	
}
