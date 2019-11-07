package com.kc345ws.facade;

public class Stereo {
    private static Stereo instance = new Stereo();

    private Stereo(){}

    public static Stereo getInstance(){
        return instance;
    }

    public void up(){
        System.out.println("调高音量");
    }

    public void down(){
        System.out.println("调低音量");
    }
}
