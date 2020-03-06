package kc345ws.leetcode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
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
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _0078子集 {
	public List<List<Integer>> subsets(int[] nums) {
		//位运算法
		/*集合            元素 
		 *  {} = 000=0		1 = 001&000 =0       2 010&000 = 0
		 *	{3}=001			001				                 010                       110
		 * (2)=010
		 * {2,3}=011
		 * {1}=100
		 * * {1,3}=101
		 * (1,2)=110
		 * {1,2,3}=111=7
		 * 
		 * 
		 * */
		List<Integer> item = new ArrayList<>();//中间结果集
		List<List<Integer>> result = new ArrayList<>();
		result.add(item);
		int rscount = (int)Math.pow(2, nums.length);//结果数量最多为2^n
		int length = nums.length;
		 int rs = 1;
		for(int i = 1 ; i < rscount ; i++) {
			//每一个i代表解所代表二进制数的十进制数
			item = new ArrayList<>();
			rs = 1;
			for(int j = 0 ; j < length ;j++) {
				if(rs > i) {
					break;
				}
				if((rs&i) == rs) {
					//如果该数字在该组解中，加入item
					item.add(nums[j]);
				}
					//左移1位继续比较其他数字
					rs = rs << 1;
			}
			result.add(item);
		}
			return result;
    }
	
	//参数列表 输入数组	访问数组的索引	 中间元素集 结果集
	public List<List<Integer>> sub(int[] nums , int index ,List<Integer> item ,List<List<Integer>> result){
		//一个元素有放入和不放入两种选择 n个元素有2^n种可能 时间复杂度O(2^n)

		if(index >= nums.length) {
			return result;
		}
		//选择当前元素加入item集
		item = new ArrayList<Integer>(item);
		item.add(nums[index]);
		result.add(item);//加入的是一个引用
		result = sub(nums, index+1, item, result);
		//不选择当前元素加入item集
//		item.remove(item.size()-1);//直接通过引用操作会对result中的结果产生影响
		item = new ArrayList<Integer>(item);
		item.remove(item.size()-1);
		result = sub(nums, index+1, item, result);
		return result;
	}
}
