package com.shuren.bean.wechat.pay;

import lombok.Data;

/**
 * Created by dbh on 2017/5/24.
 */
@Data
public class PublicPayResponseBean {

    private String appId;

    private String timeStamp;

    private String nonceStr;

    private String packages;

    private String signType;

    private String paySign;

    private String orderId;

}
