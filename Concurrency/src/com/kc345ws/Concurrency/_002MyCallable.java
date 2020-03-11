package com.kc345ws.Concurrency;

import java.util.concurrent.Callable;
//与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装。
public class _002MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Callable执行");
        return "Callable执行完毕";
    }
}
