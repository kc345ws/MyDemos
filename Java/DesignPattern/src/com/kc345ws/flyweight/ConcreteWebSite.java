package com.kc345ws.flyweight;

import java.sql.Connection;

//具体网站类
public class ConcreteWebSite extends WebSite {
    //共享的部分，属于内部状态
    private String type = "";//网站发布形式
    //共有模式写到这

    public ConcreteWebSite(String type){
        this.type = type;
    }

    //用户为外部状态
    @Override
    public void use(User user) {
        System.out.println("网站发布形式:" + type + "，使用者:" + user.getName());
    }

    //实现了内部状态和外部状态分离
}
