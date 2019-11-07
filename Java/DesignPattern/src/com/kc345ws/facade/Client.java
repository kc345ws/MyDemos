package com.kc345ws.facade;

public class Client {
    public static void main(String[]args){
        //直接调用各个器件很麻烦

        final HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        homeTheaterFacade.ready();
        homeTheaterFacade.play();
        homeTheaterFacade.pause();
        homeTheaterFacade.end();
    }
}
