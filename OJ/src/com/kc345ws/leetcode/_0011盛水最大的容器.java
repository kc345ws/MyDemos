package com.kc345ws.leetcode;

/*
* 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
* 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
* 使得它们与 x 轴共同构成的容器可以容纳最多的水。

说明：你不能倾斜容器，且 n 的值至少为 2。

图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）
的最大值为 49。

示例：

输入：[1,8,6,2,5,4,8,3,7]
输出：49
* */
public class _0011盛水最大的容器 {
    public int maxArea(int[] height) {
        //双指针法，两指针距离越远宽度越大，每次移动较小边的指针
        int len = height.length;
        int left = 0;int right = len - 1;
        int ans = 0;
        while(left < right) {
            int min = 0;
            int width = right - left;
            if(height[left] > height[right]){
                min  = height[right];
                right--;
            }else{
                min = height[left];
                left++;
            }
            ans = Math.max(ans, min * width);

        }
        return ans;
    }
}

/*
暴力法
* public int maxArea(int[] height) {
        int ans = 0;
        int len = height.length;
        for(int i = 0 ; i < len - 1 ; i++){
            for(int j = i+1 ; j < len ; j ++){
                if(height[i] != 0 && height[j]!=0)
                ans = Math.max(ans , Math.min(height[i],height[j]) * (j-i));
                //最短的决定盛水量
            }
        }
        return ans;
    }
* */