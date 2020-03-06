package kc345ws.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*
 * ����һ�����ܰ����ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����

˵�����⼯���ܰ����ظ����Ӽ���

ʾ��:

����: [1,2,2]
���:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/subsets-ii
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class _0090子集2 {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		//�ȶ�nums��������
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
		//ѡ��ǰԪ�ؼ���item����������ݹ�
		item = new ArrayList<Integer>(item);
		item.add(nums[index]);
		result.add(item);//�������һ������
		result = sub(nums, item, result, index+1);
		//���ϻ���
		
		//��ѡ��ǰԪ�ز��������ݹ�
//		item.remove(item.size()-1);//ֱ��ͨ�����ò������result�еĽ������Ӱ��
		item = new ArrayList<Integer>(item);
		item.remove(item.size()-1);
		while(index + 1 < nums.length && nums[index] == nums[index+1])
			index++;//��������������ȵ�����
		result = sub(nums, item, result, index+1);
		return result;
	}
}
//result.add(item);
//if(index >= nums.length) {
//	return result;
//}
////ѡ���˸ý��
//item = new ArrayList<>(item);
//item.add(nums[index]);//ѡ��һ�����������µݹ�
//result = sub(nums, item, result, index+1);
//
////�޳��˸ý��������ý��֮��Ľ��ݹ�
////����ͷ֮����ݵ���һ�����(��һ��)
////���������ظ�Ԫ�أ����ݹ���ͬһ������������ͬԪ�ؽڵ�
////�Ѿ��Ź����ˣ��������ֲ���͸�����֮ǰ�������ظ�
////���������������޳�������ͬ������
//item = new ArrayList<>(item);
//item.remove(item.size()-1);
//boolean flag = false;
//for(int i = index+1 ; i < nums.length ;i++) {
//	if(nums[i] == nums[index]) {
//		continue;
//	}
//	index = i;
//	flag = true;
//	break;
//}
//if(flag) {
//item.add(nums[index]);
//result = sub(nums, item, result, index+1);
//}
//return result;