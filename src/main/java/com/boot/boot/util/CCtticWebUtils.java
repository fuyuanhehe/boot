package com.boot.boot.util;


import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

import static org.apache.commons.lang3.time.DateUtils.parseDate;

public class CCtticWebUtils {
    // URL 正则表达式 & 符号匹配
    private static final String URL_DECOLLATOR = "&";

    /**
     * 说明：只支持POST和GET请求
     * */
    public static Map<String, Object> getRequestParams(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("POST")) {
            return getDoPostParams(request);
        }
        return getDoGetParams(request);
    }

    /**
     * 获得请求者的IP
     * */
    public static String getRemoteHost(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
    }

    /**
     * 说明：取出GET请求的参数
     * */
    private static Map<String, Object> getDoGetParams(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        List<String> tempList = null;

        String queryString = request.getQueryString();
        if (queryString == null || queryString.length() == 0)
            return map;
        String[] split = queryString.split(URL_DECOLLATOR);
        if (split == null || split.length == 0)
            return map;
        String temp = null;
        String[] keyAndValue = null;
        for (String kv : split) {
            if (kv == null || kv.trim().length() == 0)
                continue;
            // 第一个元素是key，第二个元素是value
            keyAndValue = kv.split("=");
            if (map.get(keyAndValue[0]) == null)
                map.put(keyAndValue[0], keyAndValue[1]);
            else {
                Object o = map.get(keyAndValue[0]);
                if (o == null) {
                    map.put(keyAndValue[0], keyAndValue[1]);
                } else if (o instanceof List) {
                    List.class.cast(o).add(keyAndValue[1]);
                } else {    // 如果不是List，并且不等于空
                    tempList = new ArrayList<>();
                    tempList.add(keyAndValue[1]);
                    tempList.add(o.toString());
                    map.put(keyAndValue[0], tempList);
                }
            }
        }
        return map;
    }

    /**
     * 说明：取出POST请求的参数
     * */
    private static Map<String, Object> getDoPostParams(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        // 得到参数，如果参数为空就返回
        Map<String, String[]> parameterMap = request.<String, String[]>getParameterMap();
        if (parameterMap == null || parameterMap.size() == 0)
            return map;
        // 循环遍历元素
        String next = null;
        String[] param = null;
        List<String> templist = null;
        Iterator<String> iterator = parameterMap.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            param = parameterMap.get(next);
            // 如果没有参数
            if (param == null || param.length == 0) {
                map.put(next, null);
                continue;
            }
            // 如果只有一个参数
            if (param.length == 1) {
                map.put(next, param[0]);
            } else {    // 多个参数
                templist = new LinkedList<>();
                for (String val : param) {
                    templist.add(val);
                }
                map.put(next, templist);
            }
        }
        return map;
    }

}
