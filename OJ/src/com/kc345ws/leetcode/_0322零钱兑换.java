package com.kc345ws.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的
* 硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coin-change
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0322零钱兑换 {
    //动态规划 自上而下
    //Map<Integer , Integer> map = new HashMap<>(); HashMap性能影响很大
    int[] map;
    public int coinChange(int[] coins, int amount) {
        if(amount <=0) return 0;
        Arrays.sort(coins);

        map = new int[amount+1];
        //for(int i = 0 ; i< coins.length ; i++) map.put(coins[i] , 1);
        //for(int i = 0 ; i< coins.length ; i++) map[coins[i]] = 1;
        int result = DP(coins , amount);
        return (result == Integer.MAX_VALUE)?-1:result;
    }
    public int DP(int[] coins , int amount){
        int minnum = Integer.MAX_VALUE;
        //if(map.containsKey(amount)) return map.get(amount);//先前已经计算过了
        if(map[amount] != 0)return map[amount];
        for(int i = 0 ; i < coins.length ; i++){
            int index = amount - coins[i];//减去一张单位货币后剩余的钱
            if(index == 0) return 1;//刚好可以由单位货币组成
            if(index < 0) break;//无法由单位货币组成，已经排序了后续也无法组成直接跳出
            //如果还没计算过组成该面值的最硬币小数量，则进行计算
            int dp = DP(coins , index);//-1证明此面值无法组成
            if(dp != -1) {
                //map.put(index, dp);
                map[index] = dp;
                if(dp + 1 < minnum) minnum = dp + 1;//由一张单位货币和更小面值最小数量组成
            }
        }
        //if(minnum != Integer.MAX_VALUE) map.put(amount , minnum);
        map[amount] = (minnum == Integer.MAX_VALUE)?-1:minnum;
        return map[amount];
        //return map.getOrDefault(amount, -1);
    }
}
