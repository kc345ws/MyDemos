package com.kc345ws.leetcode;


/*
* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */




public class _0002两数相加 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tmp = head;
        while(l1!=null || l2!=null){
            int l1val = (l1==null)?0:l1.val;
            int l2val = (l2==null)?0:l2.val;
            int sum = l1val+l2val+tmp.val;//进位需要参与计算
            boolean hasnew = false;
            if(sum >= 10){//需要进位
                sum %= 10;
                tmp.next = new ListNode(0);
                tmp.next.val = 1;
                hasnew = true;
            }
            tmp.val = sum;
            l1 = (l1==null)?null:l1.next;
            l2 = (l2==null)?null:l2.next;
            if(!hasnew && (l1!=null||l2!=null))//如果还没进位
            tmp.next = new ListNode(0);
            tmp =tmp.next;
        }
        return head;
    }
}
