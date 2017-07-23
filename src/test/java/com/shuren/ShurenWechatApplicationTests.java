package com.shuren;

import com.shuren.bean.wechat.base.AccessToken;
import com.shuren.service.resume.EmailService;
import com.shuren.service.wechat.WeChatService;
import com.shuren.utils.wechat.DataShapeConvertUtils;
import org.assertj.core.util.Compatibility;
import org.dom4j.DocumentException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shuren.service.wechat.MenuService;

import java.io.IOException;
import java.util.Map;

/**
 * Created by 董帮辉 on 2017-5-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShurenWechatApplicationTests {

    @Autowired
    private WeChatService weChatService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private EmailService emailService;

    @Test
    public void createMenu() throws IOException {
        Integer errcode = menuService.createMenu();
        if(errcode==0){
            System.out.println("菜单创建成功");
        }else{
            System.out.println("菜单创建失败");
        }
    }


    @Test
    public void testgetAccessToken() throws IOException {
        AccessToken accessToken = weChatService.getAccessToken();
        System.out.println(accessToken.getAccess_token());
    }

        @Test
    public void testParseXml(){

        try {
            String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                    "     <dat>"+
                    "    <appid>wx2421b1c4370ec43b</appid>\n" +
                    "    <attach>支付测试</attach>\n" +
                    "    <body>JSAPI支付测试</body>\n" +
                    "    <mch_id>10000100</mch_id>\n" +
                    "    <detail><![CDATA[{ \"goods_detail\":[ { \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, { \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }]]></detail>\n" +
                    "    <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>\n" +
                    "    <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>\n" +
                    "    <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>\n" +
                    "    <out_trade_no>1415659990</out_trade_no>\n" +
                    "    <spbill_create_ip>14.23.150.211</spbill_create_ip>\n" +
                    "    <total_fee>1</total_fee>\n" +
                    "    <trade_type>JSAPI</trade_type>\n" +
                    "    <sign>0CB01533B8C1EF103065174F50BCA001</sign>\n" +
                    "    </dat>";
            Map<String, String> stringStringMap = DataShapeConvertUtils.xmlToMap(xml);
            System.out.println(stringStringMap);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testEmail(){
        emailService.SendAttachMail("1138756325@qq.com","D://树仁接口文档.docx");
    }


}
