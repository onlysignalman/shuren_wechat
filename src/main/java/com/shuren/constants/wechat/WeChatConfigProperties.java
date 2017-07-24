package com.shuren.constants.wechat;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 董帮辉 on 2017-5-14.
 */
@Component
@ConfigurationProperties(prefix = "wechat")
@Data
public class WeChatConfigProperties {

    private String appId;

    private String appSecret;

    private String mchId;

    private String partnerkey;

    private String accessTokenUrl;

    private String uploadURL;

    private String createMenuUrl;

    private String queryMenuUrl;

    private String deleteMenuUrl;

    private String serverIp;

    private String serverUrl;

    private String clickToUrl;

    private String pageAccessTokenUrl;

    private String userGet;

    private String userInfoUrl;

    private String jsapiTicketUrl;

    private String micropay;

    private String orderquery;

    private String reverse;

    private String unifiedorder;

    private String refund;

    private String refundquery;

    private String downloadbill;

}
