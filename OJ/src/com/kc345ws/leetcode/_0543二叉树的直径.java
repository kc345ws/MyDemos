package com.kc345ws.leetcode;

import com.kc345ws.oj.TreeNode;

/*
* 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
* 这条路径可能穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0543二叉树的直径 {
    //最长路径不一定过根结点
    int maxdp = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxdp;
    }

    //返回该根结点下的最长路径长度
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left_depth = dfs(root.left);//左子树深度
        int right_depth = dfs(root.right);//右子树狠毒
        maxdp = Math.max(maxdp,left_depth+right_depth);//局部直径长度与全局直径长度比较
        return Math.max(left_depth,right_depth) + 1;
        //根节点长度为1
        //将该局部直径长度中较长的子树部分长度返回
    }
}
