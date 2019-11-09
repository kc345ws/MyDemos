package com.kc345ws.memento;

import java.util.List;
import java.util.Map;

//守护者对象，保存多个备忘录
public class Caretaker {
    //如果只保存一次状态
    private Memento memento;
    //保存一个角色的多个状态
    //private List<Memento> mementos;
    //保存多个角色的不同状态
    //private Map<String,List<Memento>> rolesMementos;


    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
