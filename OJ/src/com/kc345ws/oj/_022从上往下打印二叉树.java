package com.kc345ws.oj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*��Ŀ���������´�ӡ������
 * �������������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 * */
public class _022从上往下打印二叉树 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		if(root ==null) {
			return new ArrayList<Integer>();
		}
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode tempNode = null;
        while(!queue.isEmpty()) {
        	tempNode = queue.poll();
        	list.add(tempNode.val);
        	if(tempNode.left!=null) {
        		queue.add(tempNode.left);
        	}
        	if(tempNode.right!=null) {
        		queue.add(tempNode.right);
        	}
        	
        }
        
        return list;
    }
}
