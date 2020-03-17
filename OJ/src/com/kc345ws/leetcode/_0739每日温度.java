package com.kc345ws.leetcode;

import java.util.Stack;

/*
* 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过
* 该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 
[1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 
范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class _0739每日温度 {
	public static void main(String[]args) {
		int []t= {73,74,75,71,69,72,76,73};
		dailyTemperatures(t);
	}
	public static int[] dailyTemperatures(int[] T) {
		 //v2.0递减栈
        int []days = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        int length = T.length;
        for(int i = 0 ; i < length ;i++){
            if(stack.isEmpty()||(!stack.isEmpty()&&T[i]<=T[stack.peek()])){
                stack.push(i);
                if(i == length-1) {
                	while(!stack.isEmpty()) {
                		days[stack.pop()] = 0;
                	}
                	return days;
                }
            }else{
                days[stack.peek()] = i - stack.peek();
                stack.pop();
                i--;
            }
            
        }
        return days;
    }
}
