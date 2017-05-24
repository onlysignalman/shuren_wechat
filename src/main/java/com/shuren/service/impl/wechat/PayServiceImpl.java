package com.shuren.service.impl.wechat;

import com.shuren.bean.wechat.pay.PublicPayRequestBean;
import com.shuren.bean.wechat.pay.PublicPayResponseBean;
import com.shuren.constants.wechat.WeChatConfigProperties;
import com.shuren.service.wechat.PayService;
import com.shuren.utils.wechat.WeChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by dbh on 2017/5/24.
 */
@Service("payService")
public class PayServiceImpl implements PayService {

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Override
    public PublicPayResponseBean getPackage(PublicPayRequestBean publicPayRequestBean) {

        String openId = publicPayRequestBean.getOpenId();
        //订单号
        String orderId = publicPayRequestBean.getOrderId();
        // 附加数据 原样返回
        String attach = "积分购买";
        // 总金额以分为单位，不带小数点
        String totalFee = WeChatUtils.getMoney(publicPayRequestBean.getTotalFee());
        //订单生成的机器 IP
        String spbillCreateIp = publicPayRequestBean.getSpbillCreateIp();
        //这里notify_url是 支付完成后微信发给该链接信息，可以判断会员是否支付成功，改变订单状态等。
        String notify_url = "";
        //支付类型
        String trade_type = "JSAPI";


        //---必须参数
        //商户号
        String mchId = weChatConfigProperties.getMchId();
        //随机字符串
        String nonce_str = WeChatUtils.getNoncestr();
        //商品描述根据情况修改
        String body = publicPayRequestBean.getBody();

        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("appid", weChatConfigProperties.getAppId());
        packageParams.put("mch_id", weChatConfigProperties.getMchId());
        packageParams.put("nonce_str", nonce_str);
        packageParams.put("body", body);
        packageParams.put("attach", attach);
        packageParams.put("out_trade_no", orderId);
        packageParams.put("total_fee", totalFee);
        packageParams.put("spbill_create_ip", spbillCreateIp);
        packageParams.put("notify_url", notify_url);
        packageParams.put("trade_type", trade_type);
        packageParams.put("openid", openId);




        return null;
    }
}