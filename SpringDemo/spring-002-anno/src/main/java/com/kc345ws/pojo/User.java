package com.kc345ws.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//等价于<baen id="user" class="com.kc345ws.pojo.User">
@Component
public class User {
    @Value("倪司令")
    public String name;
}
