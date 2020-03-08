package com.kc345ws.leetcode;
/*
爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。

最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：

选出任一 x，满足 0 < x < N 且 N % x == 0 。
用 N - x 替换黑板上的数字 N 。
如果玩家无法执行这些操作，就会输掉游戏。

只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以
最佳状态参与游戏。

 

示例 1：

输入：2
输出：true
解释：爱丽丝选择 1，鲍勃无法进行操作。
示例 2：

输入：3
输出：false
解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 

提示：

1 <= N <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/divisor-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _1025除数博弈 {
    //动态规划
    public boolean divisorGame(int N) {
        if(N == 1)return false;
        if(N == 2)return  true;
        boolean[] result = new boolean[N+1];
        result[2] = true;result[1] = false;
        //Alice先手如果N是1，则必输
        //Alice先手如果N是2，则必赢
        //若选手处于最佳状态则result[N]和result[N-x]胜负情况必定相反
        //奇数约束只能为1，若为了使result[N]和result[N-x]胜负情况相反
        //则偶数时约束也为1，让对手一直处于奇数状态即可获得胜利
        //最后自己到2之后一定会获得胜利
        for(int i = 4 ; i <= N ;i ++){
            result[i] = !result[i-1];
        }
        return result[N];
    }
}
