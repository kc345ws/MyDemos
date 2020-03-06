package com.kc345ws.leetcode;
/*
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。

说明：解集不能包含重复的子集。

示例:

 输入： nums = [1,2,3]
 输出：
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/power-set-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1417幂集 {
	public List<List<Integer>> subsets(int[] nums) {
		//回溯法
		Arrays.sort(nums);
		 List<List<Integer>> result = new ArrayList<>();
		 result.add(new ArrayList<>());
		 result  = dfs(nums, result, new ArrayList<>(), 0);
		 return result;
    }
	
	public List<List<Integer>> dfs(int[]nums ,List<List<Integer>> result ,List<Integer> item, int index){
		if(index >= nums.length) {
			return result;
		}
		//选择当前索引的数字加入
		item = new ArrayList<Integer>(item);
		item.add(nums[index]);
		result.add(item);
		result = dfs(nums, result, item, index+1);
		//不选择当前索引数字，跳过该数字以及相同数字
		item = new ArrayList<Integer>(item);
		item.remove(item.size()-1);
		for(int i = index + 1 ; i < nums.length ; i++) {
			if(nums[i] == nums[i-1]) {
				continue;
			}
			result = dfs(nums, result, item, i);
			break;
		}
		return result;
	}
}
