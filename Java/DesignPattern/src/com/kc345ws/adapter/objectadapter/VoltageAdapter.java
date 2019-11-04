package com.kc345ws.adapter.objectadapter;

import com.kc345ws.adapter.classadapter.IVoltage5v;

//电压适配器类
public class VoltageAdapter implements IVoltage5v{
    private Voltage220v voltage220v;//聚合关系

    public VoltageAdapter(Voltage220v voltage220v){
        this.voltage220v = voltage220v;
    }

    @Override
    public int output5v() {
        //获取到220v电压
        int dstV = 0;//转成5V
        if(null != voltage220v){
            int src = voltage220v.outout220vv();//获取220v
            System.out.println("使用对象适配器，进行适配");
            dstV = src / 44;
            System.out.println("电压适配完成，输出电压为" + dstV +"v");
        }

        return dstV;
    }
}
