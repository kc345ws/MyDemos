package kc345ws.oj;

/*��Ŀ��ջ��ѹ�뵯������
 * ���������������������У���һ�����б�ʾջ��ѹ��˳��
 * ���жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳�򡣼���ѹ��ջ��
 * �������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1
 * �Ǹ�ѹջ���ж�Ӧ��һ���������У���4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * ��ע�⣺���������еĳ�������ȵģ�
 * */
import java.util.ArrayList;
import java.util.Stack;
public class _021栈的压入弹出序列 {
	public boolean IsPopOrder(int [] pushA,int [] popA) {
	     if(pushA.length==0) {
	    	 return false;
	     }
	     Stack<Integer> pushstack = new Stack<>();
		Stack<Integer> popstack = new Stack<>();	
		int pushindex = 0;
		int popindex = 0;
		popstack.push(popA[popindex]);
		popindex++;
		while(true) {
			pushstack.push(pushA[pushindex]);
			pushindex++;
	    	 while(!pushstack.isEmpty()&&pushstack.peek()==popstack.peek()) {
	    		 pushstack.pop();
	    		 popstack.pop();
	    		 if(pushindex <pushA.length) {
	    			 pushstack.push(pushA[pushindex]);
	    			 pushindex++;
	    		 }
	    		 if(popindex < popA.length) {
	    			 popstack.push(popA[popindex]);
		    		 popindex++;
	    		 }
	 
	    	 }
	    	 /*if((pushindex>pushA.length-1)&&(popindex!=pushindex)) {
	    		 //��ջ�����Ѿ��������ˣ�����ջ���л�û������
	    		 //˵���޷���ɵ��գ�����һ����Ч�ĵ�������
	    		 return false;
	    	 }*/if(pushindex>pushA.length-1&&!pushstack.isEmpty()) {
	    		 //��ջ�����Ѿ�ȫ����ջ����û����ȫ����
	    		//˵���޷���ɵ��գ�����һ����Ч�ĵ�������
	    		 return false;
	    	 }
	    	 else if(pushindex > pushA.length-1) {
	    		 return true;
	    	 }
		}
		
		
		
		///����
    }
	
	
	
}
