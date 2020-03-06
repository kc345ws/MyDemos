package com.kc345ws.oj;

/*
 * ��Ŀ���ϲ��������������
 * ���������������������������������������ϳɺ������
 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
 * */
public class _016Merge {
	
	public ListNode Merge(ListNode list1,ListNode list2) {
		//�ǵݹ�
        if(list1==null&&list2==null) {
        	return null;
        }else if(list1==null) {
        	return list2;
        }else if(list2==null) {
        	return list1;
        }
        
        ListNode head = new ListNode(0);//�ڱ����
        ListNode p = head;
        ListNode temp = null;
        while(list1!=null||list2!=null) {
        	if(list1==null) {
        		p.next = list2;
        		list2 = list2.next;
        	}else if(list2==null) {
        		p.next = list1;
        		list1 = list1.next;
        	}else if(list1.val <= list2.val) {
        		p.next = list1;
        		list1 = list1.next;
        	}else {
        		p.next = list2;
        		list2 = list2.next;
        	}
        	p = p.next;
        }
        
        return head.next;
    }
}
