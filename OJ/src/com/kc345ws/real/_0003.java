package com.kc345ws.real;

import java.util.Scanner;

/*
* 整除的数组
时间限制：C/C++语言 3000MS；其他语言 5000MS
内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
小美曾经有一个特殊的数组，这个数组的长度为n。但是她在打恐怖游戏的时候被吓得忘记了这个数组长什么样了。不过她还记得这个数组满足一些条件。

首先这个数组的每个数的范围都在L和R之间。包括端点。

除此之外，这个数组满足数组中的所有元素的和是k的倍数。

但是这样的数组太多了，小美想知道有多少个这样的数组。你只需要告诉她在模1e9+7意义下的答案就行了。

输入
一行四个整数n,k,L,R

（1≤n≤1e5    1≤k≤10    1≤L≤R≤1e9）

输出
输出一个数表示满足条件的数组的个数。


样例输入
9 1 1 3
样例输出
19683
* */
public class _0003 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//数组长度
        int k = scanner.nextInt();//数组每个数的范围，包括端点
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        //数组满足数组中的所有元素的和是k的倍数。
        int cnt = 1;
        int range =  R - L + 1;
        for(int i = 0 ; i < n ; i++)
            cnt *= range;

        System.out.println(cnt);
    }

//    public static int DFS(int n , int k , int L , int R){
//        for(int i = 0 ; i < n ; i ++){
//
//        }
//    }
}
