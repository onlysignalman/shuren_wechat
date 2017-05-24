package com.shuren.utils.wechat;

import org.springframework.context.ApplicationContext;

import com.shuren.constants.wechat.WeChatConfigProperties;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 董帮辉 2017-3-8.
 * 微信的工具类
 */
public class WeChatUtils {

    /**
     * 得到一个32位随机字符
     *
     * @return
     */
    public static String getNoncestr() {
        Date now = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(new String(
                "yyyyMMddHHmmss"));
        return formatter.format(now) + buildRandom(2);
    }

    /**
     * 取出一个指定长度大小的随机正整数.
     *
     * @param length
     *            int 设定所取出随机数的长度。length小于11
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    public static String getSign(Map<String, Object> map){

        ApplicationContext applicationContext = SpringUtils.getApplicationContext();

        WeChatConfigProperties weChatConfigProperties = applicationContext.getBean(WeChatConfigProperties.class);

        List<String> list = new ArrayList<String>();
        for(Map.Entry<String,Object> entry:map.entrySet()){
            if(entry.getValue()!=""){
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String [] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i ++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" + weChatConfigProperties.getMchId();
        //Util.log("Sign Before MD5:" + result);
        result = SecurityUtils.MD5(result).toUpperCase();
        //Util.log("Sign Result:" + result);
        return result;
    }

    public static String getMoney(String amount) {
        if (amount == null) {
            return "";
        }
        // 金额转化为分为单位
        String currency = amount.replaceAll("\\$|\\￥|\\,", ""); // 处理包含, ￥
        // 或者$的金额
        int index = currency.indexOf(".");
        int length = currency.length();
        Long amLong = 0l;
        if (index == -1) {
            amLong = Long.valueOf(currency + "00");
        } else if (length - index >= 3) {
            amLong = Long.valueOf((currency.substring(0, index + 3)).replace(".", ""));
        } else if (length - index == 2) {
            amLong = Long.valueOf((currency.substring(0, index + 2)).replace(".", "") + 0);
        } else {
            amLong = Long.valueOf((currency.substring(0, index + 1)).replace(".", "") + "00");
        }
        return amLong.toString();
    }


}
