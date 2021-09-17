package com.boot.boot.util;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class CCtticStringUtils {

    public static String getRandomString(int length) {
        //产生随机数
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        //循环length次
        for (int i = 0; i < length; i++) {
            //产生0-2个随机数，既与a-z，A-Z，0-9三种可能
            int number = random.nextInt(3);
            long result = 0;
            switch (number) {
                //如果number产生的是数字0；
                case 0:
                    //产生A-Z的ASCII码
                    result = Math.round(Math.random() * 25 + 65);
                    //将ASCII码转换成字符
                    sb.append(String.valueOf((char) result));
                    break;
                case 1:
                    //产生a-z的ASCII码
                    result = Math.round(Math.random() * 25 + 97);
                    sb.append(String.valueOf((char) result));
                    break;
                case 2:
                    //产生0-9的数字
                    sb.append(String.valueOf
                            (new Random().nextInt(10)));
                    break;
            }
        }
        return sb.toString();
    }



    public static String encryptIdCard(String idCard) {

        return replaceBetween(idCard, 6, idCard.length() - 4, null);

    }

    /**
     * 身份证 将字符串开始位置到结束位置之间的字符用指定字符替换
     *
     * @param sourceStr   待处理字符串
     * @param begin       开始位置
     * @param end         结束位置
     * @param replacement 替换字符
     * @return
     */
    private static String replaceBetween(String sourceStr, int begin, int end, String replacement) {
        if (StringUtils.isBlank(replacement)) {
            replacement = "*";
        }
        int replaceLength = end - begin;
        StringBuilder sb = new StringBuilder(sourceStr);
        sb.replace(begin, end, StringUtils.repeat(replacement, replaceLength));

        return sb.toString();
    }



}
