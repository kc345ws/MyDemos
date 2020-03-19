package com.kc345ws.leetcode;

import java.util.*;

/*
* 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
* 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。



示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
* */
public class _0015三数之和 {
    //双指针
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3 || nums == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);//从小到大排序
        for(int i = 0 ; i < len ; i++){
            if(nums[i] > 0) break;//数组已经排序，若此索引出数字已经大于0则以后数字也都大于0，和不能为0
            if(i > 0 && nums[i] == nums[i-1]) continue;//跳过重复
            int left = i + 1;
            int right = len - 1;
            while(left < right){
                int tmp = nums[i] + nums[left] + nums[right];
                if(tmp == 0){
                    List<Integer> item = new ArrayList<>();
                    item.add(nums[i]);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    ans.add(item);

                    //跳过重复元素
                    while(left < right && nums[left+1] == nums[left])
                        left++;
                    while(right > left && nums[right-1] == nums[right])
                        right--;
                    //如果left索引数字改变了，则right必须变动才可能使和等于0
                    //跳出循环后所在索引是最后相等数字的索引，还需要移动一下
                    left++;
                    right--;
                }
                //没找到合适元素
                else if(tmp > 0) {
                    right--;//和大于0了，右边指针移动
                }
                else {
                    left++;//和小于0了，左边指针移动
                }
            }
        }
        return ans;
    }
}

