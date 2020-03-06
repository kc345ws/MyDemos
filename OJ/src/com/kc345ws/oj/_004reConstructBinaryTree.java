package com.kc345ws.oj;
//��Ŀ���ؽ�������

import java.util.Arrays;


/*
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}
 * �������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 * */


public class _004reConstructBinaryTree {
	public static void main(String[]args) {
		
	}
	
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		if(pre.length == 0) {
			return null;
		}else if(pre.length == 1) {
			return new TreeNode(pre[0]);
		}
		
//		Stack<Integer> stack = new Stack<Integer>();
//		stack.add(pre[0]);//ѹ���
		
		
		int rootindex = -1;//�������������λ��
		for(int i = 0 ; i < in.length ; i++) {
			if(in[i]==pre[0]) {
				rootindex = i;
				break;
			}
		}
		
		TreeNode root = new TreeNode(pre[0]);
		root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootindex+1),Arrays.copyOfRange(in, 0, rootindex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootindex+1, pre.length), Arrays.copyOfRange(in, rootindex+1, pre.length));
		return root;
		//ע��Arrays.copyOfRange()�������±겻�������±�
    }
	
}


