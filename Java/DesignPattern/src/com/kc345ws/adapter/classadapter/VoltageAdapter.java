package com.kc345ws.adapter.classadapter;

//电压适配器类
public class VoltageAdapter extends Voltage220v implements IVoltage5v{

    @Override
    public int output5v() {
        //获取到220v电压
        int srcV = outout220vv();
        int dstV = srcV /44;//转成5V
        return dstV;
    }
}
