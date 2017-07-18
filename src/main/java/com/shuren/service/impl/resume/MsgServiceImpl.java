package com.shuren.service.impl.resume;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.mapper.resume.MsgMapper;
import com.shuren.pojo.resume.MessageLog;
import com.shuren.service.resume.MsgService;
import com.shuren.utils.wechat.StingUtils;
import com.shuren.utils.wechat.UrlRequest;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("MsgServiceImpl")
public class MsgServiceImpl implements MsgService {

	@Value("${msg.apikey}")
	private String apikey;
	@Value("${msg.text}")
	private String text;
	
	@Autowired
	private MsgMapper msgMapper;
	
	@Override
	public ModelReturns<Map<String, Object>> getMsg(String mobile) {
		// TODO Auto-generated method stub
		ModelReturns<Map<String, Object>> returns = new ModelReturns<>();
		//1.第三方获取短信
	    String param = "apikey="+apikey+"&text="+text.replace("#code#", StingUtils.getCode())+"&mobile="+mobile;
	    String results = UrlRequest.sendPost("https://sms.yunpian.com/v2/sms/single_send.json", param);
		//2.短信发送成功入日志库
	    MessageLog msg = new MessageLog();
	    msg.setMobile(mobile);
	    msg.setResults(results);
	    msg.setTimeStamp(System.currentTimeMillis());
	    msgMapper.add(msg);
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> map;
		try {
			map = mapper.readValue(results, Map.class);
			returns.setModel(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return returns;
	}

	@Override
	public ModelReturns<MessageLog> getLastMsg(String mobile) {
		// TODO Auto-generated method stub
		ModelReturns<MessageLog> returns = new ModelReturns<>();
		MessageLog msg = msgMapper.getLastMsg(mobile);
		returns.setModel(msg);
		return returns;
	}
}
