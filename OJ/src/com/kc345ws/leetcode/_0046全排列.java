package com.kc345ws.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
* */
public class _0046全排列 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int []visited = new int[nums.length];
        backtrace(nums,visited,new ArrayList<>());
        return ans;
    }

    public void backtrace(int[] nums,int[] visited, List<Integer> result){
        if(result.size() == nums.length)
        {
            ans.add(result);
            return;
        }
        int len = nums.length;
        for(int i = 0 ; i < len ; i++){
            if(visited[i] == 1)continue;
            //选择该数
            visited[i] = 1;
            result = new ArrayList<>(result);
            result.add(nums[i]);
            backtrace(nums,visited,result);
            //撤销选择
            result = new ArrayList<>(result);
            if(result.size() > 0)
                result.remove(result.size()-1);
            backtrace(nums,visited,result);
            visited[i] = 0;//必须在递归之后，否则会无限递归
        }
    }
}
