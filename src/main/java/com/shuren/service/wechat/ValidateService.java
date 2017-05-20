package com.shuren.service.wechat;


import com.shuren.bean.wechat.base.WeChat;

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
