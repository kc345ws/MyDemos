package com.kc345ws.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
* 设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，
* 也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整个棋盘的那两条对角线。

注意：本题相对原题做了扩展

示例:

 输入：4
 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/eight-queens-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _1436八皇后 {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return null;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < n ; i++) stringBuilder.append('.');
        backtrack(new ArrayList<>(),0,stringBuilder.toString());
        return ans;
    }

    public void backtrack(List<String> item , int row ,String defaultstr){
        int len = defaultstr.length();
        if(row ==len){
            ans.add(item);
            return;
        }
        for(int i = 0 ; i < len ; i++){
            if(!isvaild(item,row,i))
                continue;
            item.add(defaultstr);
            StringBuilder stringBuilder = new StringBuilder(defaultstr);
            stringBuilder.setCharAt(i,'Q');
            item.set(row,stringBuilder.toString());
            backtrack(item,row+1,defaultstr);
            //撤销选择
            item = new ArrayList<>(item);
            item.remove(row);
        }
    }

    //位置是否合法
    public boolean isvaild(List<String> item , int row , int col){
        //在同一列
        int len = item.size();
        for(int i = 0 ; i < len ; i++){
            if(item.get(i).charAt(col) == 'Q') return false;
        }

        //在右上方
        for(int i = row - 1,j = col+1 ; i >= 0 && j < len;i--,j++){
            if(item.get(i).charAt(j) == 'Q') return false;
        }

        //在左上方
        for(int i = row - 1,j = col-1;i>=0&&j>=0;i--,j--){
            if(item.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }
}
