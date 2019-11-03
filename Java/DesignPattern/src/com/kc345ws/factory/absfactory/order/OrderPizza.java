package com.kc345ws.factory.absfactory.order;

public class OrderPizza {
    AbsFactory factory = null;

    public void setFactory(String factorytype){
        if(factorytype.equals("北京")){
            factory = new BJFactory();
        }else if(factorytype.equals("伦敦")){
            factory = new LDFactory();
        }
    }
    public AbsFactory getFactory(){
        return factory;
    }
}
