package com.kc345ws.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class _0090子集2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(new ArrayList<>());
		result = sub(nums,new ArrayList<>(),result,0);
		return result;
    }
	

	public List<List<Integer>> sub(int[] nums ,List<Integer> item ,List<List<Integer>> result , int index) {	
		if(index >= nums.length) {
			return result;
		}

		item = new ArrayList<Integer>(item);
		item.add(nums[index]);
		result.add(item);
		result = sub(nums, item, result, index+1);

		

		item = new ArrayList<Integer>(item);
		item.remove(item.size()-1);
		while(index + 1 < nums.length && nums[index] == nums[index+1])
			index++;
		result = sub(nums, item, result, index+1);
		return result;
	}
}
