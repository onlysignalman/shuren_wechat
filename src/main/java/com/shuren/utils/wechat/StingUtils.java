package com.shuren.utils.wechat;

import java.util.Random;

/**
 * Created by 董帮辉 on 2017-5-3.
 */
public class StingUtils {

	public static String getCode() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if(randLength<4){
          for(int i=1; i<=4-randLength; i++)
              fourRandom = "0" + fourRandom  ;
        }
        return fourRandom;
	}

}
