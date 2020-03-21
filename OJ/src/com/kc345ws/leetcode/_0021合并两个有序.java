package com.kc345ws.leetcode;

import java.util.List;

/*
* 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
* */
public class _0021合并两个有序 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        ListNode head = new ListNode(0);
        ListNode tmp = new ListNode(0);
        head.next = tmp;
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        while(tmp1!=null||tmp2!=null){
            if(tmp1!=null && tmp2 !=null && tmp1.val < tmp2.val){
                tmp.val = tmp1.val;
                tmp1 = tmp1.next;
            }else if(tmp1 != null && tmp2!=null){
                tmp.val = tmp2.val;
                tmp2 = tmp2.next;
            }else if(tmp1 == null){
                tmp.val = tmp2.val;
                tmp2 = tmp2.next;
            }else{
                tmp.val = tmp1.val;
                tmp1 = tmp1.next;
            }
            if(tmp1 == null && tmp2 == null) break;;
            tmp.next = new ListNode(0);
            tmp = tmp.next;
        }
        return  head.next;
    }
}
