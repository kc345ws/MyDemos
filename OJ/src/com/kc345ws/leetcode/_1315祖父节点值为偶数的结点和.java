package com.kc345ws.leetcode;

import com.kc345ws.oj.TreeNode;
import com.sun.source.tree.Tree;

/*
* 给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。

 

示例：



输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。
提示：

树中节点的数目在 1 到 10^4 之间。
每个节点的值在 1 到 100 之间。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _1315祖父节点值为偶数的结点和 {
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root,root.left);
        dfs(root,root.right);
        return sum;
    }

    public void dfs(TreeNode grandroot , TreeNode parentroot){
        if(grandroot == null || parentroot == null){
            return;
        }
        if(parentroot.left != null){
            if(grandroot.val % 2 == 0)
            sum += parentroot.left.val;
            dfs(parentroot,parentroot.left);
        }
        if(parentroot.right !=null){
            if(grandroot.val % 2 == 0)
            sum += parentroot.right.val;
            dfs(parentroot,parentroot.right);
        }

    }
}
