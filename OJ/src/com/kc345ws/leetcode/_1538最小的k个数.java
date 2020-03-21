package com.kc345ws.leetcode;
/*
* 输入整数数组 arr ，找出其中最小的 k 个数。例如，
* 输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]


限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
* */
public class _1538最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr.length == 0 || k == 0) return new int[0];
        int num =0;
        int []ans = new int[k];
        int []cnt = new int[10001];
        for(int i = 0 ; i < arr.length ; i++) cnt[arr[i]]++;
        for(int i = 0 ; i < cnt.length && num < k ; i++){
            for(int j = 0 ; j < cnt[i] && num < k;j++){
                ans[num] = i;
                num++;
            }
        }
        return ans;
    }
}
