package com.kc345ws.oj;

import java.util.ArrayList;
import java.util.Stack;

//���ƣ���β��ͷ��ӡ����
/*����������һ�������������β��ͷ��˳�򷵻�һ��ArrayList��*/
public class _003printListFromTailToHead {
	public static void main(String[]args) {
		
	}
	
	public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		
		while(listNode!=null) {
			stack.add(listNode.val);
			listNode = listNode.next;
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		while(!stack.isEmpty()) {
			list.add(stack.pop());
		}
		return list;
    }
	
	class ListNode {
	      int val;
	      ListNode next = null;
	      ListNode(int val) {           
	    	  this.val = val;
	       }      
	}
}

