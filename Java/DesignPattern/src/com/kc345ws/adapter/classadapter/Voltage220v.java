package com.kc345ws.adapter.classadapter;

//被适配类
public class Voltage220v {

    //输出220v电压
    public int outout220vv(){
        int src = 220;
        System.out.println("电压 = " + src + "伏");
        return src;
    }
}
