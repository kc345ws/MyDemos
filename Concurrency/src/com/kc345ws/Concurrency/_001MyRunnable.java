package com.kc345ws.Concurrency;

//实现 Runnable 接口
public class _001MyRunnable implements Runnable{
    static int index = 0;
    @Override
    public void run(){
        System.out.println("实现Runnable：" + index);
        index++;
    }
}
