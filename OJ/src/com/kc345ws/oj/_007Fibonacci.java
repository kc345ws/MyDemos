package com.kc345ws.oj;
//��Ŀ��쳲���������

/*��������Ҷ�֪��쳲��������У�����Ҫ������һ������n��
 * �������쳲��������еĵ�n���0��ʼ����0��Ϊ0���� 
n<=39 */
public class _007Fibonacci {
	public static void main(String[]args) {
		System.out.println(Fibonacci(39));
	}
	
	public static int Fibonacci(int n) {
		//������һ������õ���ֵ����һ���Ż�����ռ�
		if(n ==0) {
			return 0;
		}else if(n <= 2) {
			return 1;
		}
		
		
		int temp = 0;
		int sum = 1;
		for(int i = 2 ; i <= n ;i++) {
			sum += temp;
			temp = sum - temp;
		}
		
		return sum;
    }
}
