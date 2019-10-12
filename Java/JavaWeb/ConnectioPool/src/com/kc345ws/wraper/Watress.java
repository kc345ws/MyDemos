package com.kc345ws.wraper;

import org.junit.Test;

public class Watress implements Waiter {
    @Override
    @Test
    public void servie() {
        System.out.println("女服务员在服务...");
    }
}
