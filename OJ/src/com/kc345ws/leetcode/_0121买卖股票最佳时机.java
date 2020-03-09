package com.kc345ws.leetcode;

/*
* 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。

注意你不能在买入股票前卖出股票。

示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0121买卖股票最佳时机 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int len = prices.length;
        int [][]profit = new int[len][2];//天数和是否持有股票的状态
        profit[0][0] = 0;//第一天不够买股票
        profit[0][1] = 0 - prices[0];//第一天就购买股票
        for(int i = 1 ; i < len ; i++){
            //profit[i][0] = Math.max(profit[i-1][0],profit[i-1][1]+prices[i]);
            //只能买入卖出一次，利润不会累计 0-prices[i]保证了会购入最低价格的股票
            profit[i][0] = Math.max(profit[i-1][0],profit[i-1][1]+prices[i]);
            profit[i][1] = Math.max(profit[i-1][1],0-prices[i]);
        }
        return profit[len-1][0];
    }
}
/*
动态规划
每天的状态:天数 还可以进行的交易次数(这题只能买一次) 是否持有股票(0不持有，1持有)
每天的选择:买入股票buy 卖出股票sell 保持原有状态rest(卖出股票必须在买入股票之后)
不持有股票可能是保持了昨天没有持有股票的状态，或卖掉了昨天的股票
持有股票可能是保持了昨天持有股票的状态，或今天买入了股票
dp[i][j][k] 表示第i天能交易j次是否持有股票
不持有股票dp[i][j][0]=max{dp[i-1][j][0] , dp[i-1][j-1][1] + prices[i]}买入卖出股票交易移除-1
持有股票dp[i][j][1]=max{dp[i-1][j][1] , dp[i-1][j][0] - prices[i]}
第一天不持有股票dp[0][1][0]=max{dp[-1][1][0] , dp[-1][1][1] + prices[0]}
dp[-1][1][0] = 0还没开始也没有股票 dp[0][1][0] = 0
dp[-1][1][1] = 负无穷，还没开始就持有股票 dp[0][1][1] = -prices[0]
第一天持有股票dp[0][1][1]=max{dp[-1][1][1] , dp[-1][1][0] + prices[0]}
最后一天卖出股票利润一定大于最后一天持有股票
//本题只能交易一次，可以去除交易次数状态来化简状态
*/
