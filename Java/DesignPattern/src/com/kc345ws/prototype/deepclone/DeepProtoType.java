package com.kc345ws.prototype.deepclone;


import java.io.*;

public class DeepProtoType implements Serializable,Cloneable{
    public String name;
    public DeepCloneableTarget deepCloneableTarget;//引用类型

    public DeepProtoType(){
        deepCloneableTarget = new DeepCloneableTarget("asdm","qwe");
    }
    //深拷贝

    //方法1 重写clone
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        deep = super.clone();//完成基本属性类型的拷贝
        //对引用类型属性进行单独处理
        DeepProtoType deepProtoType = (DeepProtoType) deep;//object向下强制转型为DeepProtoType类型
        deepProtoType.deepCloneableTarget = (DeepCloneableTarget) deepCloneableTarget.clone();
        return deepProtoType;
    }

    //方法2 通过对象序列化（推荐）
    public Object deepClone(){
        //该类在内存中创建一个字节数组缓冲区，
        // 从输入流读取的数据保存在该字节数组缓冲区中。
        ByteArrayOutputStream bos = null;

        //该类从输入流读入对象，读取对象信息。
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        DeepProtoType deepProtoType = null;
        try{
            //序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);//字节输出流换成对象输出流

            //对this整体进行处理,不用一个个处理引用对象
            oos.writeObject(this);//把当前对象以对象流方式输出

            //反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            deepProtoType = (DeepProtoType) ois.readObject();



        }
        catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭输入输出流
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return deepProtoType;
    }
}
