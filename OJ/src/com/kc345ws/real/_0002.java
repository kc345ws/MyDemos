package com.kc345ws.real;

import java.util.Arrays;
import java.util.Scanner;

/*
* 内存限制：C/C++语言 131072KB；其他语言 655360KB
题目描述：
给出一个序列包含n个正整数的序列A，然后给出一个正整数x，你可以对序列进行任意次操作的，每次操作你可以选择序列中的一个数字，让其与x做按位或运算。你的目的是让这个序列中的众数出现的次数最多。

请问众数最多出现多少次。

输入
输入第一行仅包含两个正整数n和x，表示给出的序列的长度和给定的正整数。(1<=n<=100000,1<=x<=1000)

接下来一行有n个正整数，即这个序列，中间用空格隔开。(1<=a_i<=1000)

输出
输出仅包含一个正整数，表示众数最多出现的次数。


样例输入
5 2
3 1 3 2 5
样例输出
3

提示
样例解释
例如如果序列中所有数字都不修改时，众数为3，3出现的次数为2，如果我们把两个3都做如题操作，序列会变为1，1，1，2，5，此时众数为1，出现次数为3，所以我们选择后者方案，输出众数出现的次数，即3。*/
public class _0002 {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//序列长度
        int x = scanner.nextInt();//给定正整数
        int []num = new int[n];
        int []cnt = new int[1000];
        for(int i = 0 ; i < n ;i++){
            num[i] = scanner.nextInt();
            cnt[num[i]]++;//统计数字出现次数
        }
        Arrays.sort(num);//排序
        int mostnum = countmost(cnt);
        int ans = fun(num , x);
        if(ans>mostnum)
            System.out.println(ans);
        else
            System.out.println(mostnum);
    }

    //选择一个数进行或运算
    public static int fun(int[] num , int target){
        int []origin = Arrays.copyOf(num , num.length);
        int mostnum = 0;
        int index = 0;
        while(index < num.length){
            int nownum = num[index];
            while(index < num.length && num[index]== nownum){
                num[index] = num[index] | target;
                index++;
            }
            int cnt[] = getcnt(num);
            int rs = countmost(cnt);
            if(rs > mostnum) mostnum = rs;
            //num = Arrays.copyOf(origin , origin.length);
        }
        return mostnum;
    }

    //计算众数数量
    public static int countmost(int[] cnt){
        int mostnum = cnt[0];//众数数量
        for(int i = 1 ; i < cnt.length ; i++){
            if(cnt[i] > mostnum)
                mostnum = cnt[i];
        }
        return mostnum;
    }

    //统计数字出现次数
    public static int[] getcnt(int[]num){
        int cnt[] = new int[1000];
        for(int i = 0 ; i < num.length ;i++){
            cnt[num[i]]++;
        }
        return cnt;
    }
}

/*
* 1 1
*
* */
