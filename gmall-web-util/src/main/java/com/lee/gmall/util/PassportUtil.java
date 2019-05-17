package com.lee.gmall.util;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public  class PassportUtil {

    public static String getRequestAddr(HttpServletRequest request) {
        String ip = "";
        ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(ip)) {
            //直接获取ip
            ip = request.getRemoteAddr();
        }
        if (StringUtils.isBlank(ip)) {
            //设置一个虚拟ip
            ip = "127.0.0.1";
        }
        return ip;
    }
}
