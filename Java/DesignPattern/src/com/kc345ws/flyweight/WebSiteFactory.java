package com.kc345ws.flyweight;


import java.util.HashMap;

//享元工厂，根据需求返回一个网站
public class WebSiteFactory {

    //HashMap充当池的作用
    private HashMap<String,ConcreteWebSite> pool = new HashMap<>();

    //根据网站类型返回一个网站，如果没有就创建一个网站，并放入池中

    public WebSite getWebsiteCatrgory(String type){
        if(!pool.containsKey(type)){
            pool.put(type,new ConcreteWebSite(type));
        }
        return (WebSite) pool.get(type);
    }

    //获取池中有多少个网站类型
    public int getWebSiteCount(){
        return pool.size();
    }
}
