package com.example.demo.common;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class YZToken {

    /**
     *  验证Cookie
     * @param request
     * @param token
     * @return
     */
    public static boolean yanZToken(HttpServletResponse response, HttpServletRequest request, String token){
        Map<String, Cookie> cookieMap = ReadCookieMap(request);
        Cookie cookie = null;
        Cookie cookie2 = null;
        if (cookieMap.containsKey(token)) {
            cookie = (Cookie) cookieMap.get(token);

            //重新设置token-cookie的生存时间
            cookie2 = new Cookie(token, cookie.getValue());
            cookie2.setPath("/");
            cookie2.setMaxAge(60*2);
            response.addCookie(cookie2);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 读取Cookie
     * @param request
     * @return
     */
    private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request) {
        Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
    }

    /**
     * 设置Cookie
     * @param response
     * @param name
     * @param value
     * @param time
     * @return
     */
    public static HttpServletResponse setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int time) {
        if(!yanZToken(response, request, name)){
            // new一个Cookie对象,键值对为参数
            Cookie cookie = new Cookie(name, UUID.randomUUID().toString().replaceAll("-",""));
            // tomcat下多应用共享
            cookie.setPath("/");
            // 如果cookie的值中含有中文时，需要对cookie进行编码，不然会产生乱码
            try {
                URLEncoder.encode(value, "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            cookie.setMaxAge(time);
            // 将Cookie添加到Response中,使之生效
            response.addCookie(cookie); // addCookie后，如果已经存在相同名字的cookie，则最新的覆盖旧的cookie
        }else{

        }
        return response;
    }
}
