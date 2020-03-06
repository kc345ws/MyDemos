package kc345ws.oj;

import java.util.Stack;

//��Ŀ��������ջʵ�ֶ���
/*����:������ջ��ʵ��һ�����У�
 * ��ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�*/
public class _005StackToQueue {
	 	Stack<Integer> stack1 = new Stack<Integer>();
	    Stack<Integer> stack2 = new Stack<Integer>();
	    
	    
	    
	    public void push(int node) {
	        if(stack1.size()==0) {
	        	stack1.add(node);
	        	return;
	        }
	       
	        while(!stack1.isEmpty()) {
	        	stack2.add(stack1.pop());
	        }
	        stack1.add(node);
	        while(!stack2.isEmpty()) {
	        	stack1.add(stack2.pop());
	        }
	    }
	    
	    public int pop(){
	    	if(stack1.size()>0)
	    	return stack1.pop();	
	    	throw new RuntimeException("ջΪ��");
	    }
}
