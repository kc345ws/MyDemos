package com.kc345ws.real;

import java.util.Scanner;

public class Main {
    static int result = 0;
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//网格长度
        char[][] map = new char[2][n];
        for(int i = 0 ; i < 2 ;i ++){
            String str = scanner.next();
            for(int j = 0; j < str.length() ; j ++){
                map[i][j] = str.charAt(j);
            }
        }
        DFS(map,0,0);
        if(result != 0)
            System.out.println(result);
        else
            System.out.println(-1);;
    }

    public static boolean DFS(char[][]map , int x , int y){
        if(x < 0 || y < 0) return false;
        if(x >= map.length || y >= map[0].length) return false;
        if(map[x][y] == 'X') return false;
        //向右走
        if(DFS(map,x,y+1) == true)
            result++;
        //向右下走
        if(DFS(map,x + 1,y+1) == true)
            result++;
        //向右上走
        if(DFS(map,x - 1,y+1) == true)
            result++;
        if(x == 1 && y == map[0].length - 1)
            return true;
        return  false;
    }
}
