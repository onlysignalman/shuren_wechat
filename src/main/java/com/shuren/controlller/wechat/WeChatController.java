package com.shuren.controlller.wechat;

import com.shuren.bean.wechat.base.WeChat;
import com.shuren.service.wechat.ValidateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 董帮辉 on 2017-5-14.
 */
@RestController
@RequestMapping("/wechat")
public class WeChatController {

    //注入微信校验的service
    @Autowired
    private ValidateService validateService;



    /**
     * 校验微信服务器信息
     * @param weChat
     * @return
     */
    @RequestMapping(value = "/checkSignature",method = RequestMethod.GET,produces = "text/plain;charset=UTF-8")
    public String checkSignature(WeChat weChat){
        //对微信的信息进行校验
        String result = this.validateService.checkSignature(weChat);
        return result;
    }


}
