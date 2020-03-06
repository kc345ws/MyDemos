package kc345ws.oj;

import java.util.LinkedList;
import java.util.Queue;

/*
 * ��Ŀ����������˳��ʹ������λ��ż��֮ǰ
 * ����������һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 * */
public class _013reOrderArray {
	public static void main(String[]args) {
		int[] array = {1,2,3,4,5};
		reOrderArray(array);
	}
	
	public static void reOrderArray(int [] array) {
        //�Կռ任ʱ��
		Queue<Integer>  oddQueue = new LinkedList<>();
		Queue<Integer> evenQueue = new LinkedList<>();
		
		for(int i = 0 ; i < array.length;i++) {
			if((array[i]&0x1)==1) {
				//���������
				oddQueue.add(array[i]);
			}else {
				evenQueue.add(array[i]);
			}
		}
		
		for(int i = 0 ; i < array.length;i++) {
			if(!oddQueue.isEmpty()) {
				array[i] = oddQueue.poll();
			}else {
				array[i] = evenQueue.poll();
			}
		}
    }
}
