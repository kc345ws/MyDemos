package com.kc345ws.util;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie FindCookie(Cookie[] cookies , String name){
        for(var item : cookies){
            if(item.getName().equals(name)){
                return item;
            }
        }
        return null;
    }
}
