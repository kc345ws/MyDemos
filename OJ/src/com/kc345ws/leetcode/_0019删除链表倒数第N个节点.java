package com.kc345ws.leetcode;
/*
* 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
* */
public class _0019删除链表倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode newhead = new ListNode(0);
        newhead.next = head;//哨兵结点
        int index = 0;
        //双指针法
        ListNode p = head;
        ListNode q = head;
        //先让一个指针移动N个节点
        //然后两个指针一起移动，直到第一个指针到达尾部
        while(q != null){
            index++;
            if(index == n){
                ListNode tmp = newhead;
                while(q.next != null){
                    q = q.next;
                    p = p.next;
                    tmp = tmp.next;
                }
                if(p !=null) tmp.next = p.next;
                else tmp.next = null;
                break;
            }
            q = q.next;
        }
        return newhead.next;
    }
}
