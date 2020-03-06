package com.kc345ws.oj;
//��Ŀ:��ά�����еĲ���

//����:
//��һ����ά�����У�ÿ��һά����ĳ�����ͬ����
//ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳������
//�����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
public class _001Find {
	public static void main(String[]args) {
		int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
		System.out.println(Find(1,array));
	}
	//array.length��array[0].length��ö������Ȼ�󱣴��ڱ������棬
	//�������Խ�ʡʱ�䣬����ÿ�αȶԵ�ʱ����һ�Ρ�
	public static boolean Find(int target, int [][] array) {
		int col =array[0].length - 1;//���targetС�ڸ��У����Ժ�������и���֮��Ķ������ٱȽ�
		for(int i = 0 ; i < array.length ; i++) {
			int low = 0;
			//int high = array[i].length - 1;
			int high = col;
			
			while(low <= high) {
				int mid = (low + high)/2;
				if(target > array[i][mid]) {
					low = mid +1;
				}else if(target < array[i][mid]) {
					col = mid - 1;
					high = col;
				}else {
					return true;
				}
			}
		}
		return false;
    }
}
