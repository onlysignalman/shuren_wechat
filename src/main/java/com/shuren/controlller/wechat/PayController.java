package com.shuren.controlller.wechat;

import com.shuren.bean.wechat.pay.PublicPayRequestBean;
import com.shuren.bean.wechat.pay.PublicPayResponseBean;
import com.shuren.constants.wechat.WeChatConfigProperties;
import com.shuren.pojo.wechat.Order;
import com.shuren.service.wechat.OrderService;
import com.shuren.service.wechat.PayService;
import com.shuren.utils.wechat.DataShapeConvertUtils;
import com.shuren.utils.wechat.WeChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by dbh on 2017/5/24.
 */
@Controller
@RequestMapping("pay")
public class PayController {

    @Autowired
    private PayService payService;

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Autowired
    private OrderService orderService;

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

    //微信回调
    @RequestMapping(value = "notify", method = RequestMethod.POST,produces = "application/xml;charset=UTF-8")
    @ResponseBody
    public String notify(HttpServletRequest request, HttpServletResponse response) {
        try {
            String inputLine;
            String notityXml = "";
            String resXml = "";
            while ((inputLine = request.getReader().readLine()) != null) {
                notityXml += inputLine;
            }
            Map<String, String> m = DataShapeConvertUtils.xmlToMap(notityXml);

            String sign = payService.createSign(m);

            //校验成功
            if(sign.equals(m.get("sign"))){
                Order order = new Order();
                order.setMoney(Integer.valueOf(m.get("total_fee")));
                order.setOpenId(m.get("openid"));
                order.setOrderId(m.get("out_trade_no"));
                order.setPaymentTime(Long.valueOf(m.get("time_end")));
                order.setPaymentType(m.get("trade_type"));
                //业务结果
                String resultCode = m.get("result_code");
                if ("SUCCESS".equals(resultCode)){//支付成功
                    //根据orderId查询订单表是否改存在改记录
                    Integer i = this.orderService.queryCountByOderId(order.getOrderId());
                    //如果不存在就插入订单信息
                    resXml = "<xml>" + "<return_code><![CDATA[SUCCESS]]></return_code>"
                            + "<return_msg><![CDATA[OK]]></return_msg>" + "</xml> ";
                    if(i==0){
                        this.orderService.save(order);
                        //更新业务 TODO
                    }else{
                        return resXml;
                    }
                    // 支付成功
                    return  resXml;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


}
