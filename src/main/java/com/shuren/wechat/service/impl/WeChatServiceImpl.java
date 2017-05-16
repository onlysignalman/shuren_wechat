package com.shuren.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuren.wechat.bean.base.AccessToken;
import com.shuren.wechat.constants.WeChatConfigProperties;
import com.shuren.wechat.mapper.AccessTokenMapper;
import com.shuren.wechat.service.WeChatService;
import com.shuren.wechat.utils.UrlRequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Date;

/**
 * 董帮辉 2017-3-8.
 */
@Service("weChatService")
public class WeChatServiceImpl implements WeChatService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Autowired
    private AccessTokenMapper accessTokenMapper;

    @Override
    public AccessToken getAccessToken() throws IOException {
        //从数据库获取access_token
        AccessToken accessToken = this.accessTokenMapper.find();
        if(!StringUtils.isEmpty(accessToken)){
            //获取当前时间
            Date date = new Date();
            //获取数据库中数据
            Date create_time = accessToken.getCreate_time();
            long difference = (date.getTime() - create_time.getTime())/1000;
            if(difference<7000){
                return accessToken;
            }else{
                //调用微信接口，获取access_token
                String accessTokenUrl = weChatConfigProperties.getAccessTokenUrl();
                String appId = weChatConfigProperties.getAppId();
                String appSecret = weChatConfigProperties.getAppSecret();
                String url = accessTokenUrl.replace("APPID",appId).replace("APPSECRET",appSecret);
                String result = UrlRequestUtils.sendGet(url);
                AccessToken token = null;
                if(!StringUtils.isEmpty(result)){
                    token = MAPPER.readValue(result, AccessToken.class);
                    //将accessToken存到数据库中
                    token.setCreate_time(new Date());
                    accessTokenMapper.update(token);
                }
                return token;
            }
        }else{
            //调用微信接口，获取access_token
            String accessTokenUrl = weChatConfigProperties.getAccessTokenUrl();
            String appId = weChatConfigProperties.getAppId();
            String appSecret = weChatConfigProperties.getAppSecret();
            String url = accessTokenUrl.replace("APPID",appId).replace("APPSECRET",appSecret);
            String result = UrlRequestUtils.sendGet(url);
            AccessToken token = null;
            if(!StringUtils.isEmpty(result)){
                token = MAPPER.readValue(result, AccessToken.class);
                //将accessToken存到数据库中
                token.setCreate_time(new Date());
                accessTokenMapper.insert(token);
            }
            return token;
        }
    }

}
