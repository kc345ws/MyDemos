package com.supermarket.jdbc.util;

public class StringUtil {
    public static boolean isEmpty(String s){
        if(s == null || s.equals("")){
            return true;
        }
        return false;
    }
}
