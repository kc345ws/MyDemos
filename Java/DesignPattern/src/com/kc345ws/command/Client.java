package com.kc345ws.command;

public class Client {
    public static void main(String[]args){

        //创建电灯对象(接收者)
        final LightReceiver lightReceiver = new LightReceiver();

        //创建电灯开关命令
        Command onCommand = new LightOnCommand(lightReceiver);
        Command offCommand = new LightOffCommand(lightReceiver);

        //需要一个遥控器
        RemoteController remoteController = new RemoteController();

        //遥控器设置命令   0为电灯开关
        remoteController.setCommand(0,onCommand,offCommand);

        System.out.println("------按下电灯开按钮-----");
        remoteController.onButtonWasPushed(0);
        System.out.println("------按下电灯关按钮-----");
        remoteController.offButtonWasPushed(0);

        System.out.println("------按下撤销按钮-----");
        remoteController.undoButtonWasPushed();
        System.out.println("------按下撤销按钮-----");
        remoteController.undoButtonWasPushed();
    }
}
