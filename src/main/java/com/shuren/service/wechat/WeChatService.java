package com.shuren.service.wechat;


import java.io.IOException;

import com.shuren.bean.wechat.base.AccessToken;

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
