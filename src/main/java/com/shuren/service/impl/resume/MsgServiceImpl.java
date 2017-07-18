package com.shuren.service.impl.resume;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuren.bean.resume.ErrorInfos;
import com.shuren.bean.resume.ModelReturns;
import com.shuren.mapper.resume.MsgMapper;
import com.shuren.pojo.resume.MessageLog;
import com.shuren.service.resume.MsgService;
import com.shuren.utils.wechat.StingUtils;
import com.shuren.utils.wechat.UrlRequest;
import com.yunpian.sdk.YunpianClient;
import com.yunpian.sdk.model.Result;
import com.yunpian.sdk.model.SmsSingleSend;

/**
 * Created by 董帮辉 on 2017-5-18.
 */
@Service("MsgServiceImpl")
public class MsgServiceImpl implements MsgService {

	private Logger LOGGER = LoggerFactory.getLogger(MsgService.class);
	
	@Value("${msg.apikey}")
	private String apikey;
	@Value("${msg.text}")
	private String text;
	
	@Value("${email.subject}")
	private String subject;
	@Value("${email.content}")
	private String content;
	
	@Autowired
	private MsgMapper msgMapper;
	
	@Override
	public ModelReturns<Map<String, Object>> getMsg(String mobile) {
		// TODO Auto-generated method stub
		LOGGER.info("subject:{}", subject);
		LOGGER.info("content:{}", content);
		LOGGER.info("apikey:{}", apikey);
		LOGGER.info("text:{}", text);
		ModelReturns<Map<String, Object>> returns = new ModelReturns<>();
		//1.第三方获取短信
//	    String param = "apikey="+apikey+"&text="+text.replace("#code#", StingUtils.getCode())+"&mobile="+mobile;
//	    LOGGER.info("text:{}", text);
//	    String results = UrlRequest.sendPost("https://sms.yunpian.com/v2/sms/single_send.json", param);
//	    if(results == null || results.length() <= 0){
//	    	returns.setError(ErrorInfos.YANZHENGMAHUOQUSHIBAI.getError());
//	    	returns.setStatus(ErrorInfos.YANZHENGMAHUOQUSHIBAI.getStatus());
//	    	return returns;
//	    }
		//初始化client,apikey作为所有请求的默认值(可以为空)
		YunpianClient clnt = new YunpianClient(apikey).init();

		//修改账户信息API
		Map<String, String> param = clnt.newParam(2);
		param.put(YunpianClient.MOBILE, mobile);
		param.put(YunpianClient.TEXT, text.replace("#code#", StingUtils.getCode()));
		Result<SmsSingleSend> results = clnt.sms().single_send(param);
		clnt.close();
		//2.短信发送成功入日志库
	    MessageLog msg = new MessageLog();
	    msg.setMobile(mobile);
	    msg.setResults(results.toString());
	    msg.setTimeStamp(System.currentTimeMillis());
	    msgMapper.add(msg);
	    ObjectMapper mapper = new ObjectMapper();
	    Map<String, Object> map;
		try {
			map = mapper.readValue(results.toString(), Map.class);
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
