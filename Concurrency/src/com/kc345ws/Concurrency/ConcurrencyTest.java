package com.kc345ws.Concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ConcurrencyTest {
    public static void main(String[]args) throws ExecutionException, InterruptedException {
//        001Runnable
//        _001MyRunnable target = new _001MyRunnable();
//        Thread thread = new Thread(target);
//        thread.start();

        //002Callable
//        _002MyCallable callable = new _002MyCallable();
//        FutureTask<String> futureTask = new FutureTask<String>(callable);
//        Thread thread1 = new Thread(futureTask);
//        thread1.start();
//        System.out.println(futureTask.get());

        //003继承Thread
//        _003MyThread thread = new _003MyThread();
//        thread.start();

        //004Executor
//        ExecutorService executorService = Executors.newCachedThreadPool();
////        for(int i  = 0 ; i < 5 ; i++){
////            executorService.execute(new _001MyRunnable());
////        }
////        executorService.shutdown();

        //005Interrupt
//        _005MyInterrupt myInterrupt = new _005MyInterrupt();
//        myInterrupt.start();
//        myInterrupt.interrupt();
//        myInterrupt.start();
        //先interupt后start还会继续执行
//        myInterrupt.start();
//        myInterrupt.interrupt();//将线程状态设置为中断，但不会立即停止
        //进入阻塞状态调用interrupt后会抛出异常并将是否中断社会false
        //先start后interrupt会抛出interuptionExption
//


        //ReentrantLock
        // 使用工具类 Executors 创建线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for(int i = 0 ; i< 2 ; i++){
//            executorService.execute(new _006ReentrantLock());
//        }
//        executorService.shutdown();
        //Lambda的格式 标准格式: (参数类型 参数名称) ‐> { 代码语句 }`
//            ExecutorService executorService = Executors.newCachedThreadPool();
//            Thread thread = new _006ReentrantLock();
//            for(int i = 0 ; i< 2 ; i++){
//            executorService.execute(()->thread.run());
//        }

        // Join
        _007MyJoin.A ta = new _007MyJoin.A();
        _007MyJoin.B tb = new _007MyJoin.B(ta);
        tb.start();//即使先调用A的start,join方法也会保证a先执行
        ta.start();

    }
}
