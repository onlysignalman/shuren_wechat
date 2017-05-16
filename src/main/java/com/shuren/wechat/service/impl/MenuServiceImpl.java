package com.shuren.wechat.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuren.wechat.bean.menu.Button;
import com.shuren.wechat.bean.menu.Menu;
import com.shuren.wechat.bean.menu.ViewButton;
import com.shuren.wechat.constants.WeChatConfigProperties;
import com.shuren.wechat.service.MenuService;
import com.shuren.wechat.service.WeChatService;
import com.shuren.wechat.utils.UrlRequestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * 董帮辉 2017-3-11.
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private WeChatConfigProperties weChatConfigProperties;

    @Autowired
    private WeChatService weChatService;

    @Override
    public Menu getMenu(){

        //获取服务器地址
        String serverUrl = weChatConfigProperties.getServerUrl();
        
        //获取微信视图地址
        String clickToUrl = weChatConfigProperties.getClickToUrl();

        //二级视图菜单
        ViewButton but11 = new ViewButton();
        but11.setName("我的首页");
        but11.setType("view");
        but11.setUrl("http://www.baidu.com");
        ViewButton but12 = new ViewButton();
        but12.setName("简历制作");
        but12.setType("view");
        but12.setUrl("http://www.baidu.com");
        ViewButton but13 = new ViewButton();
        but13.setName("联系客服");
        but13.setType("view");
        but13.setUrl("http://www.baidu.com");
        ViewButton but21 = new ViewButton();
        but21.setName("我的测评");
        but21.setType("view");
        but21.setUrl("http://www.baidu.com");
        ViewButton but22 = new ViewButton();
        but22.setName("职业潜力测评");
        but22.setType("view");
        but22.setUrl("http://www.baidu.com");
        ViewButton but23 = new ViewButton();
        but23.setName("通用能力测评");
        but23.setType("view");
        but23.setUrl("http://www.baidu.com");
        ViewButton but24 = new ViewButton();
        but24.setName("职业倾向测评");
        but24.setType("view");
        but24.setUrl("http://www.baidu.com");
        ViewButton but31 = new ViewButton();
        but31.setName("招聘信息");
        but31.setType("view");
        but31.setUrl("http://www.baidu.com");
        ViewButton but32 = new ViewButton();
        but32.setName("劳资咨询");
        but32.setType("view");
        but32.setUrl("http://www.baidu.com");
        ViewButton but33 = new ViewButton();
        but33.setName("资格考试");
        but33.setType("view");
        but33.setUrl("http://www.baidu.com");

        //父菜单(一级菜单)
        Button button1 = new Button();
        button1.setName("我的树仁");
        button1.setSub_button(new Button[]{but11,but12,but13});
        Button button2= new Button();
        button2.setName("职业测评");
        button2.setSub_button(new Button[]{but21,but22,but23,but24});
        Button button3= new Button();
        button3.setName("求职招聘");
        button3.setSub_button(new Button[]{but31,but32,but33});

        Menu menu = new Menu();
        menu.setButton(new Button[]{button1,button2,button3});
        return menu;

    }

    @Override
    public Integer createMenu() throws IOException {
        logger.info("创建菜单");
        Integer errcode = 0;
        String createMenuUrl = weChatConfigProperties.getCreateMenuUrl();
        createMenuUrl = createMenuUrl.replace("ACCESS_TOKEN",this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtils.sendPost(createMenuUrl, MAPPER.writeValueAsString(getMenu()));
        if(!StringUtils.isEmpty(result)){
            Map map = MAPPER.readValue(result, Map.class);
            errcode = (Integer) map.get("errcode");
        }
        return errcode;
    }

    @Override
    public String queryMenu() throws IOException {
        String queryMenuUrl = weChatConfigProperties.getQueryMenuUrl();
        queryMenuUrl = queryMenuUrl.replace("ACCESS_TOKEN", this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtils.sendGet(queryMenuUrl);
        return result;
    }

    @Override
    public Integer deleteMenu() throws IOException {
        logger.info("删除菜单");
        Integer errcode = 0;
        String deleteMenuUrl = weChatConfigProperties.getDeleteMenuUrl();
        deleteMenuUrl = deleteMenuUrl.replace("ACCESS_TOKEN", this.weChatService.getAccessToken().getAccess_token());
        String result = UrlRequestUtils.sendGet(deleteMenuUrl);
        if(!StringUtils.isEmpty(result)){
            Map map = MAPPER.readValue(result, Map.class);
            errcode = (Integer) map.get("errcode");
        }
        return errcode;
    }
}
