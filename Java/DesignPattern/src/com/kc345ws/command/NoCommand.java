package com.kc345ws.command;

//空命令   没有任何命令，用于初始化每个按钮，当调用空命令时对象什么都不做
//其实，这是一个设计模式，可以省掉空的判断
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
