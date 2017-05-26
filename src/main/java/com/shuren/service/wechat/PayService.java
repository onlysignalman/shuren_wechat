package com.shuren.service.wechat;

import com.shuren.bean.wechat.pay.PublicPayRequestBean;
import com.shuren.bean.wechat.pay.PublicPayResponseBean;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.Map;

/**
 * Created by dbh on 2017/5/24.
 */
public interface PayService {


    /**
     * 微信公众号支付
     * @param publicPayRequestBean
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    PublicPayResponseBean getPackage(PublicPayRequestBean publicPayRequestBean) throws IOException, DocumentException;

    /**
     * 微信回调用获取签名
     * @param map
     * @return
     */
    String createSign(Map<String, String> map);
}
