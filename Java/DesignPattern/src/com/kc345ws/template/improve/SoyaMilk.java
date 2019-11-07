package com.kc345ws.template.improve;

//豆浆抽象类
public abstract class SoyaMilk {
    //模板方法,make ,final不允许子类覆盖
    final void make(){
        select();
        if(customerWantCondiments()){
            addCondiments();
        }
        soak();
        beat();
    }

    //选材料
    void select(){
        System.out.println("第一部:选好的黄豆");
    }

    //添加不同的配料，子类具体实现
    abstract void addCondiments();

    void soak(){
        System.out.println("第三部，黄豆和配料浸泡三小时");
    }

    void beat(){
        System.out.println("第四部，黄豆和配料放到豆浆机打碎");
    }

    //钩子方法，决定是否需要添加配料
    boolean customerWantCondiments(){
        return true;
    }
}
