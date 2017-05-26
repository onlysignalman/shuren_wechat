package com.shuren.service.impl.wechat;

import com.shuren.bean.wechat.pay.PublicPayRequestBean;
import com.shuren.bean.wechat.pay.PublicPayResponseBean;
import com.shuren.constants.wechat.WeChatConfigProperties;
import com.shuren.service.wechat.PayService;
import com.shuren.utils.wechat.DataShapeConvertUtils;
import com.shuren.utils.wechat.UrlRequestUtils;
import com.shuren.utils.wechat.WeChatUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;
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
    public PublicPayResponseBean getPackage(PublicPayRequestBean publicPayRequestBean) throws IOException, DocumentException {

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

        //获取签名
        String sign = WeChatUtils.createSign(packageParams,weChatConfigProperties.getPartnerkey());

        //拼接xml文件
        String xml = "<xml>" +
                    "<appid>" + weChatConfigProperties.getAppId() + "</appid>" +
                    "<mch_id>"+ weChatConfigProperties.getMchId() + "</mch_id>" +
                    "<nonce_str>" + nonce_str + "</nonce_str>" +
                    "<sign>" + sign + "</sign>" +
                    "<body><![CDATA[" + body + "]]></body>" +
                    "<out_trade_no>" + orderId + "</out_trade_no>" +
                    "<attach>" + attach + "</attach>" +
                    "<total_fee>" + totalFee + "</total_fee>" +
                    "<spbill_create_ip>" + publicPayRequestBean.getSpbillCreateIp() + "</spbill_create_ip>" +
                    "<notify_url>" + notify_url + "</notify_url>" +
                    "<trade_type>" + trade_type + "</trade_type>" +
                    "<openid>" + openId + "</openid>" +
                    "</xml>";
        //调用统一下单接口
        String result = UrlRequestUtils.sendPost(weChatConfigProperties.getUnifiedorder(), xml);

        Map<String, String> map = DataShapeConvertUtils.xmlToMap(result);

        String prepay_id = null;
        //请求成功
        if(map.get("return_code").equals("SUCCESS")){
            //业务交易成功
            if(map.get("result_code").equals("SUCCESS")){
                //获取预支付id
                prepay_id = map.get("prepay_id");
            }
        }

        //获取prepay_id后。拼接请求支付所需要的package
        String timeStamp = System.currentTimeMillis()+"";
        SortedMap<String, String> finalpackage = new TreeMap<>();
        String packages = "prepay_id="+prepay_id;
        finalpackage.put("appId", weChatConfigProperties.getAppId());
        finalpackage.put("timeStamp", timeStamp);
        finalpackage.put("nonceStr", nonce_str);
        finalpackage.put("package", packages);
        finalpackage.put("signType", "MD5");
        //签名
        String finalsign = WeChatUtils.createSign(finalpackage,weChatConfigProperties.getPartnerkey());

        PublicPayResponseBean publicPayResponseBean = new PublicPayResponseBean();
        publicPayResponseBean.setAppId(weChatConfigProperties.getAppId());
        publicPayResponseBean.setNonceStr(nonce_str);
        publicPayResponseBean.setOrderId(orderId);
        publicPayResponseBean.setSignType("MD5");
        publicPayResponseBean.setPackages(packages);
        publicPayResponseBean.setTimeStamp(timeStamp);
        return publicPayResponseBean;
    }
}
