package com.kc345ws.leetcode;

import java.util.LinkedList;

public class _0225用队列实现栈 {
	LinkedList<Integer> list1 = new LinkedList<>();
	LinkedList<Integer> list2 = new LinkedList<>();
    /** Initialize your data structure here. */
    
    /** Push element x onto stack. */
    public void push(int x) {
         if(list1.size()==0) {
        	 list1.add(x);
	        	return;
	        }
	       
	        while(!list1.isEmpty()) {
	        	list2.add(list1.pop());
	        }
	        list1.add(x);
	        while(!list2.isEmpty()) {
	        	list1.add(list2.pop());
	        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(list1.size()>0)
	    	return list1.pop();	
	    	throw new RuntimeException("ջΪ��");
    }
    
    /** Get the top element. */
    public int top() {
    	if(list1.size()>0)
	    	return list1.peek();	
	    	throw new RuntimeException("ջΪ��");
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
    	if(list1.size()>0)
	    	return false;
    	return true;
    }
}
