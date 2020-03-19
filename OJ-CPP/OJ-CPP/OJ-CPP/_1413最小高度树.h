#pragma once
#include"CommonHeader.h"

//����һ�������������飬Ԫ�ظ�����ͬ�Ұ��������У���дһ���㷨������һ�ø߶���С�Ķ�����������
//
//ʾ�� :
//������������: [-10, -3, 0, 5, 9],
//
//	һ�����ܵĴ��ǣ�[0, -3, 9, -10, null, 5]�������Ա�ʾ��������߶�ƽ�������������
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
		int middle = ((left + right) * 2 + 1) / 2;//��������
		//ѡȡ�����м�ֵΪ���ڵ�ֵ
		TreeNode * root = new TreeNode(nums[middle]);
		//�ֱ𴴽���������
		root->left = createTree(nums, left, middle-1);
		root->right = createTree(nums, middle+1, right);
		return root;
	}
};