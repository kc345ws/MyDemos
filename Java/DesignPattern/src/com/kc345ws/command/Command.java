package com.kc345ws.command;

//命令接口
public interface Command {
    public void execute();
    public void undo();//撤销
}
