package com.kc345ws.oj;

import java.util.LinkedList;
import java.util.Queue;

/*��Ŀ���������ľ���
 * ���������������Ķ�����������任ΪԴ�������ľ���
 * �������ľ����壺Դ������ 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	���������
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
 * */
public class _018Mirror {
	
	public void Mirror(TreeNode root) {
		//2.0BFS�ǵݹ鷽��
		if(root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);//�ȰѸ��ڵ�������
		TreeNode tempNode = null;
		while(!queue.isEmpty()) {
			tempNode = queue.poll();
			//������������
			TreeNode t = tempNode.left;
			tempNode.left = tempNode.right;
			tempNode.right = t;
			if(tempNode.left!=null)
			queue.add(tempNode.left);
			if(tempNode.right!=null)
			queue.add(tempNode.right);			
		}
		
    }
	

	
}
