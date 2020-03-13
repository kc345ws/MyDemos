package com.kc345ws.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
* 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 
* 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:

输入: [3,2,3]
输出: 3
示例 2:

输入: [2,2,1,1,1,2,2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0169多数元素 {

}

/*
* //随即法
    public int majorityElement(int[] nums) {
        Random random = new Random();
        int len = nums.length;
        int majoyCount = nums.length / 2;
        while(true){
            int target = random.nextInt(len);
            if(countnum(target,nums) > majoyCount) return target;
        }
    }

    public int countnum(int target,int[] nums){
        int count = 0;
        for(int item : nums){
            if(item == target) count++;
        }
        return count;
    }
* */
/*
* //HashMap
    public int majorityElement(int[] nums) {
        int target = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int item : nums){
            if ((map.containsKey(item))) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
            if(map.get(item)>target)return item;
        }
        throw new RuntimeException("没有多数");
    }
* */
