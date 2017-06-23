package com.janita.like.util;

import java.util.UUID;

/**
 * Created by Janita on 2017/6/21 0021-下午 1:20
 * 该类是：
 */
public class CommonUtils {
    /**
     * 获取UUID
     * @return
     */
    public static String getRandomUUID(){
        return UUID.randomUUID().toString();
    }

    public static long getNowTime() {
        return System.currentTimeMillis();
    }
}
