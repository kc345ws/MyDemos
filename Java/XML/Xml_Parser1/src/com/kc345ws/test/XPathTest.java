package com.kc345ws.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XPathTest {
    public static void main(String[]args){
        try {
            //1.创建sax读取对象
            SAXReader saxReader = new SAXReader();
            //2.指定读取来源
            Document document = saxReader.read(new File("src/xml/Stus.xml"));

            //3.得到元素
            //根元素

            Element rootelement = document.getRootElement();

            //以//开头匹配文档中所有满足//之后规则的元素,以/开头表示绝对路径
            //使用Xpath，还得添加jaxen.jar ,获取的是第一个只返回一个
            Element element = (Element) rootelement.selectSingleNode("//name");
            System.out.println(element.getText());

            System.out.println("---------");
            List<Node> elements = rootelement.selectNodes("//name");
            for(var item : elements){
                Element element1 = (Element)item;
                System.out.println(item.getText());
            }
            //System.out.println(rootelement.element("stu").getName());
            //rootelement.element("stu")
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
