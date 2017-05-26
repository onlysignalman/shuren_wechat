package com.shuren.controlller.wechat;

import com.shuren.bean.wechat.pay.PublicPayRequestBean;
import com.shuren.bean.wechat.pay.PublicPayResponseBean;
import com.shuren.service.wechat.PayService;
import com.shuren.utils.wechat.WeChatUtils;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by dbh on 2017/5/24.
 */
@Controller
@RequestMapping("pay")
public class PayController {

    @Autowired
    private PayService payService;

    //微信公众号支付
    @RequestMapping(value = "publicPay", method = RequestMethod.GET)
    public ResponseEntity<PublicPayResponseBean> publicPay(HttpServletRequest request, @RequestParam("openId") String openId, @RequestParam("money") String money){

        try {
            PublicPayRequestBean publicPayRequestBean = new PublicPayRequestBean();
            publicPayRequestBean.setOpenId(openId);
            publicPayRequestBean.setBody("积分");
            publicPayRequestBean.setOrderId(WeChatUtils.getNoncestr());
            publicPayRequestBean.setSpbillCreateIp(request.getRemoteAddr());
            publicPayRequestBean.setTotalFee(money);
            PublicPayResponseBean publicPayResponseBean = null;
            publicPayResponseBean = this.payService.getPackage(publicPayRequestBean);
            return ResponseEntity.ok(publicPayResponseBean);
        } catch (Exception e) {
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
