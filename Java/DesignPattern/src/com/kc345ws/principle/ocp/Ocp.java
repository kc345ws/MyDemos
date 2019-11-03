package com.kc345ws.principle.ocp;

import java.net.spi.URLStreamHandlerProvider;

//开闭原则
public class Ocp {
    public static void main(String[]args){
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circular());
        graphicEditor.drawShape(new Triangle());
    }
}

//绘制图的类（使用方 ）
class GraphicEditor{
    public void drawShape(Shape s){
        s.draw();
    }
}

abstract class Shape{
    int m_type;

    public abstract void draw();
}

class Rectangle extends Shape{
    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circular extends Shape{
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Triangle extends Shape{
    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}

