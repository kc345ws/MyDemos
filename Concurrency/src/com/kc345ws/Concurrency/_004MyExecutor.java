package com.kc345ws.Concurrency;

public class _004MyExecutor implements Runnable {
    @Override
    public void run() {
        System.out.println();
    }
}

/*
Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。

* CachedThreadPool：一个任务创建一个线程；
FixedThreadPool：所有任务只能使用固定大小的线程；
SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
* */
