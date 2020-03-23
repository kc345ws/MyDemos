package com.kc345ws.leetcode;
/*
* 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _0039组合总和 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> visited = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(),0,target,candidates,visited);
        return ans;
    }

    public void backtrack(List<Integer> item , int result ,int target ,int[] candidates ,List<Integer> visited){
        if(result == target){
            ans.add(new LinkedList<>(item));
            return;
        }else if(result > target) return;
        int len = candidates.length;
        for(int i = 0 ; i < len ; i++){
            if(visited.contains(candidates[i])) continue;
            //选择该数
            item.add(candidates[i]);
            backtrack(item,result+candidates[i],target,candidates,visited);
            //撤销选择
            if(item.size() > 0)
            item.remove(item.size()-1);
            //把比这个数的所有数都加入visti中
            for(int j = i ; j < len ; j++)
            visited.add(candidates[j]);
            backtrack(item,result,target,candidates,visited);
            for(int j = i ; j < len ; j++)
            visited.remove(visited.size()-1);
        }
    }
}
