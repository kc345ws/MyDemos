package com.kc345ws.memento;

public class Client {
    public static void main(String[]args){
        final GameRole gameRole = new GameRole(10, 100);
        final Memento memento = gameRole.createMemento();//初始状态的备忘录
        System.out.println("初始状态");
        gameRole.display();
        System.out.println("减少后的状态");
        gameRole.setAttack(5);
        gameRole.setHp(50);
        gameRole.display();
        System.out.println("回复后");
        gameRole.recoverGameRoleFromMemento(memento);
        gameRole.display();
    }
}
