#pragma once
#include"CommonHeader.h"

//给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
//
//示例 :
//给定有序数组: [-10, -3, 0, 5, 9],
//
//	一个可能的答案是：[0, -3, 9, -10, null, 5]，它可以表示下面这个高度平衡二叉搜索树：
//
//	0
//	/ \
//	- 3   9
//	/   /
//	-10  5
class Solution {
public:
	TreeNode* sortedArrayToBST(vector<int>& nums) {
		TreeNode* root = createTree(nums, 0, nums.size() - 1);
		return root;
	}

	TreeNode *createTree(vector<int>& nums, int left, int right) {
		if (nums.size() == 0 || left > right) return nullptr;
		int middle = ((left + right) * 2 + 1) / 2;//四舍五入
		//选取数组中间值为根节点值
		TreeNode * root = new TreeNode(nums[middle]);
		//分别创建左右子树
		root->left = createTree(nums, left, middle-1);
		root->right = createTree(nums, middle+1, right);
		return root;
	}
};