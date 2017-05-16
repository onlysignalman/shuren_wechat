package com.shuren;

import com.shuren.wechat.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * Created by 董帮辉 on 2017-5-14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShurenWechatApplicationTests {

    @Autowired
    private MenuService menuService;

    @Test
    public void createMenu() throws IOException {
        Integer errcode = menuService.createMenu();
        if(errcode==0){
            System.out.println("菜单创建成功");
        }else{
            System.out.println("菜单创建失败");
        }
    }
}
