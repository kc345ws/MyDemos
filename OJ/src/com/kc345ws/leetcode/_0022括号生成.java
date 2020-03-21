package com.kc345ws.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
* */
public class _0022括号生成 {

    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrace("",n,0,0);
        return ans;
    }

    //DFS时不要new
    public void backtrace(String item,int n , int leftnum , int rightnum){
        if(rightnum == n && leftnum == n){
            ans.add(item);
            return;
        }else if(rightnum > leftnum) return;
        ///左括号大于对数，或右括号数量大于左括号数量直接返回
        //加入左括号
        if(leftnum < n) backtrace(item+"(",n,leftnum+1,rightnum);
        //不加入左括号并加入右括号
        if(rightnum < n) backtrace(item+")",n,leftnum,rightnum+1);
    }

}

