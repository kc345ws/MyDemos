package com.kc345ws.memento;

public class GameRole {
    private int attack;
    private int hp;

    public GameRole(int attack,int hp){
        this.attack = attack;
        this.hp = hp;
    }

    //创建Memento
    public Memento createMemento(){
        return new Memento(attack,hp);
    }

    //从备忘录对象，回复GameRole
    public void recoverGameRoleFromMemento(Memento memento){
        this.attack = memento.getAttack();
        this.hp = memento.getHp();
    }

    public void display(){
        System.out.println("当前游戏角色的状态");
        System.out.println("攻击力:"+attack);
        System.out.println("HP:"+hp);
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
