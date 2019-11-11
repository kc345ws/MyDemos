package com.kc345ws.memento;

//备忘录类,保存游戏角色某个时刻的状态
public class Memento {
    private int attack;//攻击力
    private int hp;//防御力

    public Memento(int attack,int hp){
        this.attack = attack;
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
