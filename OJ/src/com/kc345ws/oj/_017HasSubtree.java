package com.kc345ws.oj;

/*
 * ��Ŀ�������ӽṹ
 * �������������ö�����A��B��
 * �ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
 * */
public class _017HasSubtree {
		//�ж�B�Ƿ���A���ӽṹ������ݹ��ж�A����������
	 	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	 		if(root1==null||root2==null) {
	 			return false;
	 		}
	 		
//	 		if(root1.val==root2.val) {
//	 			//������ڵ���ͬ�������жϸ��ڵ����������Ƿ���B����ͬ��ͬ
//	 			return isSubtree(root1, root2);//����ֱ�ӷ���
//	 		}
	 		
	 		//������ڵ㲻ͬ�����жϽ�����������������B��ͬ������		
	 		return((isSubtree(root1, root2))||(HasSubtree(root1.left, root2))||(HasSubtree(root1.right, root2)));
	 		//���ڵ������������ֻҪ��һ��������B��ͬ�򷵻�true
	    }
	 	
	 	//�ж�B�Ƿ���A���ӽṹ
	 	public boolean isSubtree(TreeNode root1,TreeNode root2) {
	 		if(root2==null) {
	 			return true;//B�ĸ������ж���Ϸ���true
	 		}
	 		if(root1==null) {
	 			return false;//
	 			//B������δ�ж���϶�A�Ѿ��ж����
	 			//˵��B����Aû�еĲ��֣���Bһ������A���ӽṹ
	 		}
	 		
	 		if(root1.val !=root2.val) {
	 			//������ֵ��ֱͬ�ӷ���false
	 			return false;
	 		}
	 		
	 		//�����ж�A�����������Ƿ��B��ͬ
	 		return ((isSubtree(root1.left, root2.left))&&isSubtree(root1.right, root2.right));
	 	}
}
