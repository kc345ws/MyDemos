package com.kc345ws.leetcode;

import com.kc345ws.oj.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Arrays;

/*
* 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，
创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-height-tree-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _1399最小高度树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        int root_val_index = nums.length /2;
        TreeNode root = new TreeNode(nums[root_val_index]);
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums,0,root_val_index));
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums,root_val_index+1 , nums.length));
        return root;
    }
}
