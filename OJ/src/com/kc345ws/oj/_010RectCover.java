package com.kc345ws.oj;
/*
 * ��Ŀ�����θ���
 * ���������ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ����� 

����n=3ʱ��2*3�ľ��ο���3�ָ��Ƿ����� 

��С�����ģ

n = 1  1
n = 2  2
n = 3  3
n = 4  5

�ݹ��ǵݹ�
 * */
public class _010RectCover {
	public int RectCover(int target) {
		if(target == 1) {
			return 1;
		}else if(target == 2) {
			return 2;
		}else if(target == 0) {
			return 0;
		}
		
		int sum = 2;
		int temp = 1;
		for(int i = 3 ; i <= target ;i++) {
			sum += temp;
			temp = sum - temp;
		}
		
		return sum;
    }
}
