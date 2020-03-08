package com.kc345ws.leetcode;
/*
* 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，
* 计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
进阶:

给出时间复杂度为O(n*sizeof(integer))的解答非常容易。
但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数
（如 C++ 中的 __builtin_popcount）来执行此操作。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/counting-bits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0338比特位计数 {
    //动态规划2.0
    public int[] countBits(int num) {
        if(num == 0) return new int[1];
        int[]ans=new int[num+1];
        ans[0]=0;
        for(int i = 1 ; i <= num ;i++){
            if((i&1)==0){
                //如果是偶数
                ans[i] = ans[i/2];
            }else{
                ans[i] = ans[i-1]+1;
            }
        }
        return  ans;
    }
}
//    //动态规划1.0
//    int []ans;
//    public int[] countBits(int num) {
//        if(num == 0) return new int[1];
//        ans = new int[num + 1];
//        DP(num);
//        return ans;
//    }
//
//    public int DP(int num){
//        if(num == 0) return 0;
//        if((num & 1) == 1)ans[num] = DP(num - 1) + 1;
//        //如果是奇数，1的个数等于前一个偶数1的个数+1
//        if((num & 1) == 0){
//            DP(num - 1);
//            ans[num] = ans[num/2];
//        }
//        //如果是偶数，1的个数等于1/2倍数的1的个数，(1/2)num左移一位得到num不影响1的个数
//        return ans[num];
//    }
