package com.kc345ws.facade;


//外观类
public class HomeTheaterFacade {
    //定义各个子系统对象
    private TheaterLight theaterLight;
    private Popcorn popcorn;
    private Stereo stereo;
    private Projector projector;
    private Screen screen;
    private DVDPlayer dvdPlayer;

    public HomeTheaterFacade(){
        this.theaterLight = TheaterLight.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.stereo = Stereo.getInstance();
        this.projector = Projector.getInstance();
        this.screen = Screen.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    //操作分成四部
    public void ready(){
        //准备阶段
        popcorn.on();
        popcorn.pop();
        screen.on();
        projector.on();
        stereo.up();
        dvdPlayer.on();
        theaterLight.dim();
    }

    public void play(){
        //播放阶段
        dvdPlayer.play();
    }

    public void pause(){
        //暂停阶段
        dvdPlayer.pause();
    }

    public void end(){
        //结束阶段
        popcorn.off();
        screen.off();
        projector.off();
        stereo.down();
        dvdPlayer.off();
        theaterLight.bright();
    }
}
