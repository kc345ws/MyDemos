package com.kc345ws.leetcode;

import com.kc345ws.utils.QueueReflectBase;

import java.util.LinkedList;
import java.util.Stack;

/*
* 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入:
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入:
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]
 

限制：

1 <= push_back,pop_front,max_value的总操作数 <= 10000
1 <= value <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _1548队列的最大值 implements QueueReflectBase {
    public void MaxQueue() {

    }
    LinkedList<Integer> linkedList = new LinkedList<>();
    LinkedList<Integer> tmplist = new LinkedList<>();
    public int max_value() {
        if(linkedList.isEmpty()){
            return -1;
        }
        return tmplist.peek();
    }

    public void push_back(int value) {
        linkedList.offer(value);
        while(!tmplist.isEmpty() && tmplist.peekLast() < value){
            tmplist.pollLast();//需要弹出尾部元素
        }
        tmplist.offer(value);
        //如果要加入的元素大于临时队列队尾元素
        //将临时队列所有元素弹出
        //因为队列FIFO的，所以弹出前面所有元素对最大值不会有影响
        //后加入元素可能在队首元素被弹出后成为最大元素
    }

    public int pop_front() {
        if(linkedList.isEmpty()){
            return -1;
        }
        if(linkedList.peek().equals(tmplist.peek()) ){
            //不能使用== ,大于127不再从缓冲区获取从而不相等
            //弹出元素等于临时队列队首元素
            tmplist.poll();
        }
        return linkedList.poll();
    }
}
