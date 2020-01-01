package com.meng.daily.common.util;

import java.util.Random;

/**
 * @author 梦醉
 * @date 2019/12/31--21:17
 */
public class RandomUtils {
    private static Random random = new Random();
    public static int randInt(int max){
        return random.nextInt(max);
    }
}
