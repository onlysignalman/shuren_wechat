package com.shuren.wechat.service;


import com.shuren.wechat.bean.base.WeChat;

/**
 * 董帮辉 2017-3-5.
 */
public interface ValidateService {
    /**
     * 对微信信息进行校验
     * @param weChat
     * @return
     */
    String checkSignature(WeChat weChat);
}
