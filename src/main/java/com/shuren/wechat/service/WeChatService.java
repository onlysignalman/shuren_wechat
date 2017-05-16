package com.shuren.wechat.service;


import com.shuren.wechat.bean.base.AccessToken;

import java.io.IOException;

/**
 * 董帮辉 2017-3-8.
 */
public interface WeChatService {
    /**
     * 获取accessToken
     * @return
     * @throws IOException
     */
    AccessToken getAccessToken() throws IOException;

}
