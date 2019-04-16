package com.pmdiss.common.util.ssoUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @author zhangxi
 * @created 13-5-27
 */
public class SSOUtil {

    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie cookies[] = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    public static String generateSid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }


}
