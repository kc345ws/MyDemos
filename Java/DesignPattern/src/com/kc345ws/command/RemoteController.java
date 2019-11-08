package com.kc345ws.command;

public class RemoteController {
    //开 按钮命令数组
    Command[] onCommands;
    //关命令数组
    Command[] offCommands;

    //撤销的命令，为上次执行的命令
    Command undoCommand;

    //构造器
    public RemoteController(){
        onCommands = new Command[5];
        offCommands = new Command[5];

        for(int i = 0 ; i < 5 ; i++){
            onCommands[i] = new NoCommand();
            offCommands[i] = new NoCommand();
        }
    }

    //给按钮设置需要的命令    开和关为一组命令
    public void setCommand(int no , Command onCommand,Command offCommand){
        onCommands[no] = onCommand;
        offCommands[no] = offCommand;
    }

    //按下开的按钮
    public void onButtonWasPushed(int no){
        onCommands[no].execute();//找到按下开的按钮，并调用对应方法
        //记住这次操作用于撤销
        undoCommand = onCommands[no];
    }

    //按下关的按钮
    public void offButtonWasPushed(int no){
        offCommands[no].execute();
        undoCommand = offCommands[no];
    }

    //撤销命令
    public void undoButtonWasPushed(){
        undoCommand.undo();
    }
}
