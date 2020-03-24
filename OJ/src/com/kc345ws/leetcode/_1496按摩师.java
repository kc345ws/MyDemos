package com.kc345ws.leetcode;
/*
* 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
* 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，
* 替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

注意：本题相对原题稍作改动

 

示例 1：

输入： [1,2,3,1]
输出： 4
解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
示例 2：

输入： [2,7,9,3,1]
输出： 12
解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
示例 3：

输入： [2,1,4,5,3,1,1,3]
输出： 12
解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/the-masseuse-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _1496按摩师 {
    public int massage(int[] nums) {
        if(nums.length == 0) return 0;
        int len = nums.length;
        int[][]dp = new int[len][2];
        dp[0][0]=0;dp[0][1]=nums[0];
        for(int i = 1 ; i < len ; i ++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            if(i-2>=0) dp[i][1] = Math.max(dp[i-1][0]+nums[i],dp[i-2][1]+nums[i]);
            else dp[i][1] = dp[i-1][0]+nums[i];
        }
        return (dp[len-1][0]>dp[len-1][1])?dp[len-1][0]:dp[len-1][1];
    }
}

/*
//状态 按摩 休息
//选择 不接单 接单
* dp[i][0]第i天的休息总按摩时间
* dp[i][1]第i天按摩的总按摩时间
* dp[i][0] = max{dp[i-1][0],dp[i-1][1]}
* dp[1][1] = max{dp[i-1][0]+nums[i],dp[i-2][1]+nums[i]}不能连续按摩
* dp[0][0]=0
* dp[0][1]=nums[0]
* */
