package com.kc345ws.prototype.deepclone;

import java.io.Serializable;

public class DeepCloneableTarget implements Serializable,Cloneable {
    public String name;//string属性
    public String cloneclass;

    public DeepCloneableTarget(String name, String cloneclass){
        this.name = name;
        this.cloneclass = cloneclass;
    }


    //因为属性都是基本数据类型，所以可以使用默认clone方法进行深拷贝
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
