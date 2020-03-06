package com.kc345ws.oj;

/*
 * ���ƣ������е�����k�����
 * ����������һ����������������е�����k����㡣
 * */
public class _014FindKthToTail {
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head==null) {
			return null;
		}else if(head.next == null) {
			return head;
		}else if(k <=0) {
			return null;
		}
		//����ָ��ָ��ͷ��㣬һ��ָ���ߵ���k����㣬Ȼ���������һֱ�ߣ�
		//ֱ����һ������ߵ�β
		/*
		 * ���ܵ����
		 * 1.������Ϊ������N������һ�����
		 * 2.������Ϊ������һ����㼴���һ�����
		 * 3.��������֮��
		 * 4.�����㲻�ڷ�Χ��k > cnt
		 * */
		ListNode first = head;
		ListNode second = head;
		int cnt = 0;
		while(first!=null) {
			cnt++;
			if(cnt>=k) {
				//cnt>=k˵���������ڷ�Χ��
				first=first.next;
				if(first!=null) {
					second=second.next;//���һ�����ı߽�����
				}
			}else {
				first = first.next;
			}	
		}
		
		if(k > cnt) {
			return null;
		}else {
			return second;
		}
	}
}

