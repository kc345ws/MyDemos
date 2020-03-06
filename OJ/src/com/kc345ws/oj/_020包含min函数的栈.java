package com.kc345ws.oj;
/*
 * ��Ŀ������min������ջ 

 * ����������ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�
 * min������ʱ�临�Ӷ�ӦΪO��1������ 
ע�⣺��֤�����в��ᵱջΪ�յ�ʱ�򣬶�ջ����pop()����min()����top()������
 * */
import java.util.Stack;
public class _020包含min函数的栈{
	//1.0˫ջ��
	static Stack<Integer> stack = new Stack<>();
	static Stack<Integer>minstack = new Stack<>();
	int min = Integer.MAX_VALUE;
	public void push(int node) {
        stack.push(node);
        
        if(!minstack.isEmpty()) {
        	min = minstack.peek();
        	if(node <= min) {
        		//���ѹ��ջ��Ԫ��С����Сջ��ջ��Ԫ�أ���Ҳѹ����Сջ
            	minstack.push(node);
            	min = node;
            }
        }else {
        	minstack.push(node);
        }
        
    }
    
    public void pop() {
    	if(stack.size()>0) {
    		 int top = stack.pop();
    		 if(top==min) {
    			 minstack.pop();
    			 min = minstack.peek();
    		 }
    	}
    }
    
    public int top() {
    	if(stack.size()>0)
        return stack.peek();
    	return Integer.MIN_VALUE;
    }
    
    public int min() {
        return minstack.peek();
    }
}
