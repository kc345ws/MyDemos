package com.kc345ws.adapter.classadapter;

//电压被转换成目标类5V后手机可以充电
public class Phone {
    //充电
    public void charging(IVoltage5v iVoltage5v){
        if(iVoltage5v.output5v() == 5){
            System.out.println("电压为5v,可以充电");
        }else if(iVoltage5v.output5v() > 5){
            System.out.println("电压大于5v,不可以充电");
        }
    }
}
