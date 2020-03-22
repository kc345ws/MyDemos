package com.kc345ws.leetcode;

import java.util.Arrays;

public class _0031下一个排序 {
    /*
    * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

    必须原地修改，只允许使用额外常数空间。

    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
    * */
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        boolean flag = false;
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            //找到第一个降序的数字，然后把它和之后一个最小的比它大的数交换位置
            //并把较大数之后按从小较大排序
            if(nums[i] < nums[i+1]){
                for(int j = nums.length -1 ; j > i ; j--){
                    if(nums[j] > nums[i]){
                        int tmp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = tmp;
                        flag = true;
                        Arrays.sort(nums,i+1,nums.length);
                        break;
                    }
                }
            }
            if(flag) break;
        }
        if(!flag) Arrays.sort(nums);
    }
}
