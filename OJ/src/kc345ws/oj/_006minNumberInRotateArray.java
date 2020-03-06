package kc345ws.oj;
//��Ŀ����ת�������С����
/*��������һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��*/
public class _006minNumberInRotateArray {
	public static void main(String[]args) {
		int[]array = {3,4,5,1,2};
		System.out.println(minNumberInRotateArray(array));
	}
	
    public static int minNumberInRotateArray(int [] array) {
    	if(array.length == 0) {
    		return 0 ;
    	}else if(array.length == 1) {
    		return array[0];
    	}else if(array.length ==2) {
    		return array[1];
    	}
    		
    	//���������Ķ��ַ�
    	int low = 0;
    	int high = array.length - 1;
    	int mid = (low+high)/2;
    	int index = -1;
    	
    	if(array[low] == array[high] && array[high]==array[mid]) {
    		//�����ת����ĵ�һ���������һ�����Լ��м�����ͬ
    		//�޷�ͨ���м����ж���С�����м�����߻����ұ�
    		for(int i = 0 ; i < array.length-1 ;i ++) {
    			if(array[i]>array[i+1] ){
    				return array[i+1];
    			}
    		}
    	}else {
    		while(low < high) {
    			
    			if(array[mid] > array[high]) {
    				low = mid;
    			}else if(array[mid] < array[low]) {
    				high = mid;
    			}
    			
    			if(high - low == 1) {
    				index = high;
    				break;
    			}
    			mid = (low+high)/2;
    		}
    	}
    	
    	
    	
        return array[index];
    }
}
