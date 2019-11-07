package com.kc345ws.reflectdemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//反射逻辑
public class ReflectClass {
    private final static String TAG = "com.kc345ws.reflectdemo.ReflectClass ";

    //创建对象
    public static void reflectInstance(){
        try {
            //?是通配符,泛指所有类型
            //T和？运用的地方有点不同,?是定义在引用变量上,T是类上或方法上
            Class<?> classBook = Class.forName("com.kc345ws.reflectdemo.Book");
            classBook.getDeclaredConstructor().setAccessible(true);
            Object obj = classBook.getDeclaredConstructor().newInstance();
            Book book = (Book)obj;
            book.setName("设计模式");
            book.setAuthor("GOF");
            System.out.println(TAG + "reflectInstance book = " + book.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //反射私有构造方法
    public static void reflectPrivateConsturctor(){
        try {
            Class<?> classBook = Class.forName("com.kc345ws.reflectdemo.Book");
            //带有Declared修饰的方法可以反射到私有的方法，
            // 没有Declared修饰的只能用来反射公有的方法
            Constructor<?> declaredConstructor =classBook.getDeclaredConstructor(
                    String.class,String.class
            );
            //取消Java的权限控制检查
            declaredConstructor.setAccessible(true);
            //如果源码中明确进行了权限验证，
            // 而你的应用又无法获得这个权限的话，建议就不要浪费时间反射了。
            Object obj = declaredConstructor.newInstance("程序设计技术","倪司令");
            Book book = (Book)obj;
            System.out.println(TAG + "reflectPrivateConsturctor Book = " + book.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // 反射私有属性
    public static void reflectPrivateField() {
        try {

            Object objectBook = Class.forName("com.kc345ws.reflectdemo.Book")
                    .getDeclaredConstructor().newInstance();
            Class<?> classBook = objectBook.getClass();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);

            //get(Object obj) 返回指定对象obj上此 Field 表示的字段的值
            String tag = (String) fieldTag.get(objectBook);

            System.out.println(TAG + "reflectPrivateField tag = " + tag);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有方法
    public static void reflectPrivateMethod() {
        try {

            Class<?> classBook = Class.forName("com.kc345ws.reflectdemo.Book");

            //获取declaredMethod方法

            Method methodBook = classBook.getDeclaredMethod("declaredMethod",int.class);
            methodBook.setAccessible(true);
            Object objectBook = Class.forName("com.kc345ws.reflectdemo.Book").getDeclaredConstructor().newInstance();

            //传入参数0并返回结果
            String string = (String) methodBook.invoke(objectBook,0);

            System.out.println(TAG + "reflectPrivateMethod string = " + string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
