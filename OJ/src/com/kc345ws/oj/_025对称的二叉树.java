package com.kc345ws.oj;

import com.kc345ws.utils.*;
/*
 * 描述：请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

 

示例 1：

输入：root = [1,2,2,3,4,4,3]
输出：true
示例 2：

输入：root = [1,2,2,null,3,null,3]
输出：false
 

限制：

0 <= 节点个数 <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _025对称的二叉树 {
	public static void main(String[]args) {
		Object[] objects = {1,2,2,null,3,null,3};
		TreeNode root = MyTreeUtils.createBinary(objects);
		System.out.println(isSymmetric(root));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null) {
			return true;
		}
		//DFS
		String str1 = dfs(root.left, true);
		String str2 = dfs(root.right, false);
		if(str1.equals(str2)) {
			return true;
		}
		return false;
    }
	
	public static String dfs(TreeNode root,boolean type) {
		if (root==null) {
			return "#";//主义此处要返回一个非控制用来标记空子树
		}
		if(type) {
			return root.val + dfs(root.left,type) + dfs(root.right, type);
		}else {
			return root.val + dfs(root.right, type) + dfs(root.left,type);
		}
	}
}
