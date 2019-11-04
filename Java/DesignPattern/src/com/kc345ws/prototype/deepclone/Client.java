package com.kc345ws.prototype.deepclone;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*DeepProtoType deepProtoType = new DeepProtoType();

        DeepProtoType deepProtoType1 = (DeepProtoType) deepProtoType.clone();
        DeepProtoType deepProtoType2 = (DeepProtoType) deepProtoType.clone();
        DeepProtoType deepProtoType3 = (DeepProtoType) deepProtoType.clone();

        System.out.println("deppcloneTarge = "+ deepProtoType.deepCloneableTarget.hashCode());
        System.out.println("deppcloneTarge = "+ deepProtoType1.deepCloneableTarget.hashCode());
        System.out.println("deppcloneTarge = "+ deepProtoType2.deepCloneableTarget.hashCode());
        System.out.println("deppcloneTarge = "+ deepProtoType3.deepCloneableTarget.hashCode());*/

        System.out.println("-----------方法2-----------");
        DeepProtoType deepProtoType = new DeepProtoType();

        DeepProtoType deepProtoType1 = (DeepProtoType) deepProtoType.deepClone();
        DeepProtoType deepProtoType2 = (DeepProtoType) deepProtoType.deepClone();
        DeepProtoType deepProtoType3 = (DeepProtoType) deepProtoType.deepClone();

        System.out.println("deppcloneTarge = "+ deepProtoType.deepCloneableTarget.hashCode());
        System.out.println("deppcloneTarge = "+ deepProtoType1.deepCloneableTarget.hashCode());
        System.out.println("deppcloneTarge = "+ deepProtoType2.deepCloneableTarget.hashCode());
        System.out.println("deppcloneTarge = "+ deepProtoType3.deepCloneableTarget.hashCode());
    }
}
