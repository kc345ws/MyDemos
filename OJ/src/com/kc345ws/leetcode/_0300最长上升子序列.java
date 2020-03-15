package com.kc345ws.leetcode;

import java.util.Arrays;

/*
* 给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0300最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        //动态规划
        int len = nums.length;
        if(len == 0) return 0;
        int []dp = new int[len];//以nums[i]结尾的最长子序列长度
        //dp[i] = max{dp[j]+1|j∈ [0,i)&&nums[i]大于nums[j]}
        Arrays.fill(dp,1);//所有单独的子串长度为1
        int ans = 0;
        for (int i = 0 ; i < len ; i++){
            for(int j = 0 ; j < i ; j++){
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i] , dp[j]+1);
                    //可以拼接在后面
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    /*
    *
    *
    * */
}

/*
* public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int []result = new int[len];
        for(int i = 0 ; i < len ;i ++){
            int laststored = nums[i];
            int uplen = 1;
            for(int j = i + 1 ; j < len ; j++){
                if(nums[j] > laststored){
                    uplen++;
                    laststored = nums[j];
                }
            }
            result[i] = uplen;
        }
        int ans = 0;
        for(int item : result){
            if(item > ans) ans = item;
        }
        return ans;
    }
* */
