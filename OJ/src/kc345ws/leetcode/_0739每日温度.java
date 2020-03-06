package kc345ws.leetcode;

import java.util.Stack;

/*
 * ����ÿ�� ���� �б�����������һ���б���Ӧλ�õ�����������Ҫ�ٵȴ����
 * �¶ȲŻ����߳������յ����������֮�󶼲������ߣ����ڸ�λ���� 0 �����档

���磬����һ���б� temperatures = [73, 74, 75, 71, 69, 72, 76, 73]��������Ӧ
���� [1, 1, 4, 2, 1, 1, 0, 0]��

��ʾ������ �б��ȵķ�Χ�� [1, 30000]��ÿ�����µ�ֵ�ľ�Ϊ���϶ȣ�
������ [30, 100] ��Χ�ڵ�������

��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/daily-temperatures
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */

public class _0739每日温度 {
	public static void main(String[]args) {
		int []t= {73,74,75,71,69,72,76,73};
		dailyTemperatures(t);
	}
	public static int[] dailyTemperatures(int[] T) {
		 //v2.0�ݼ�ջ
        int []days = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        int length = T.length;
        for(int i = 0 ; i < length ;i++){
            if(stack.isEmpty()||(!stack.isEmpty()&&T[i]<=T[stack.peek()])){
                //���������������С�ڵ���ջ��Ԫ����ѹ��ջ
                stack.push(i);//������ѹ��ջ
                if(i == length-1) {
                	//����Ѿ��Ƚ������һ�죬ʣ���첻���ٽ��бȽ϶���0��
                	while(!stack.isEmpty()) {
                		days[stack.pop()] = 0;
                	}
                	return days;
                }
            }else{
            	//������������¶ȱ�ջ���¶ȸ�
                days[stack.peek()] = i - stack.peek();
                //�����������ȥջ�����������������֮�������
                stack.pop();//��Ϊջ��Ԫ��Ԫ���Ѿ��ҵ�����Ӧ����������ɾ��ջ��Ԫ��
                i--;
            }
            
        }
        return days;
    }
}
