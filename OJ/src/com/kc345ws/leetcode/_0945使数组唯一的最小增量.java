package com.kc345ws.leetcode;
/*
* 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。

返回使 A 中的每个值都是唯一的最少操作次数。

示例 1:

输入：[1,2,2]
输出：1
解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
示例 2:

输入：[3,2,1,2,1,7]
输出：6
解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
提示：

0 <= A.length <= 40000
0 <= A[i] < 40000
* */
public class _0945使数组唯一的最小增量 {
    //V2.0桶排序优化
    public int minIncrementForUnique(int[] A) {
        if(A.length == 0) return 0;
        int ans = 0;
        int []bucket = new int[40001];
        for(int item : A){
            bucket[item]++;
        }
        for(int i = 0 ; i < 40000 ; i++){
            if(bucket[i] > 1){
                int movenum = bucket[i] - 1;//移动元素数量
                bucket[i+1] += movenum;
                bucket[i] = 1;
                ans += movenum;
            }
        }
        //可能会堆积在最后一个元素,将最后一个元素向后移动
        for(int i = bucket[bucket.length-1] ; i > 1 ; i--){
            ans +=i-1;
        }
        return ans;
    }
}

/*
* //V1.0桶排序
    public int minIncrementForUnique(int[] A) {
        if(A.length == 0) return 0;
        int ans = 0;
        int []bucket = new int[40001];
        int len = A.length;
        for(int i = 0 ; i < len ; i++){
            bucket[A[i]]++;
        }
        for(int i = 0 ; i < 40000 ; i++){
            while(bucket[i] > 1){
                bucket[i]--;
                bucket[i+1]++;
                ans++;
            }
        }
        //可能会堆积在最后一个元素,将最后一个元素向后移动
        for(int i = bucket[bucket.length-1] ; i > 1 ; i--){
            ans += i-1;
        }
        return ans;
    }
* */
