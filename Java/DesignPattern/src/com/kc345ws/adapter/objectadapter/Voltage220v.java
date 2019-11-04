package com.kc345ws.adapter.objectadapter;

//被适配类
public class Voltage220v {

    //输出220v电压,不用变
    public int outout220vv(){
        int src = 220;
        System.out.println("电压 = " + src + "伏");
        return src;
    }
}
