package com.kc345ws.oj;

/*
 * ��Ŀ����ת����
 * ����������һ��������ת��������������ı�ͷ��
 * */
public class _015ReverseList {
	public ListNode ReverseList(ListNode head) {
		if(head==null) {
			return null;
		}else if(head.next ==null) {
			return head;
		}
			
		ListNode p = head;
		ListNode q = head.next;
		ListNode temp = q.next;
		p.next =null;//ע��˲������������ѭ��
		while(q!=null) {
			q.next = p;
			p = q;
			q = temp;
			if(temp!=null) {
			temp = temp.next;
			}
		}
		
		return p;
    }
}



