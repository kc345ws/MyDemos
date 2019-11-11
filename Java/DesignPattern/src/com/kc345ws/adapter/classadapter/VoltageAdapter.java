package com.kc345ws.adapter.classadapter;

//电压适配器类
public class VoltageAdapter extends Voltage220v implements IVoltage5v{
    @Override
    public int output5v() {//实现目标类的输出5V的方法
        //获取到220v电压
        int srcV = outout220vv();//通过继承取得220V电压
        int dstV = srcV /44;//转成5V
        return dstV;//返回一个5V电压
    }
}
