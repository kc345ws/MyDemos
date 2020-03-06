package kc345ws.oj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
 

限制：

1 <= 数组长度 <= 50000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _028数组中出现超过一半的数字 {
	public int majorityElement(int[] nums) {
		//抵消法，遇到相同的+1,遇到不同的-1 等于0后设置当前索引的数字为目标
		int target = nums[0];
		int cnt = 1;
		for(int i = 1 ; i < nums.length ;i++) {
			if(nums[i] == target) {
				cnt++;
			}else {
				cnt--;
			}
			
			if(cnt==0) {
				target = nums[i];
				cnt = 1;
			}
		}
		
		return target;
    }
}
