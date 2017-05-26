package com.shuren.service.wechat;

import com.shuren.bean.wechat.pay.PublicPayRequestBean;
import com.shuren.bean.wechat.pay.PublicPayResponseBean;
import org.dom4j.DocumentException;

import java.io.IOException;

/**
 * Created by dbh on 2017/5/24.
 */
public interface PayService {


    PublicPayResponseBean getPackage(PublicPayRequestBean publicPayRequestBean) throws IOException, DocumentException;
}
