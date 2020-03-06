package com.kc345ws.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class MainTest {
    public static void main(String[] args){
        try {
            //1.创建sax读取对象
            SAXReader saxReader = new SAXReader();
            //2.指定读取来源
            Document document = saxReader.read(new File("src/xml/Stus.xml"));

            //3.得到元素
            //根元素
            Element rootelement = document.getRootElement();
            //System.out.println(rootelement.getName());
            List<Element>stus = rootelement.elements();//获取所有stu
            for(var item : stus){
                String name = item.element("name").getText();
                String age = item.element("age").getText();
                String adress = item.element("adress").getText();
                System.out.println("name:"+name +" age:" + age +" adress:" + adress);
            }

            //System.out.println(rootelement.element("stu").getName());
            //rootelement.element("stu")
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
