package kc345ws.oj;

import java.util.ArrayList;

/*
 * ��Ŀ��˳ʱ���ӡ����
 * ����������һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * */
public class _019顺时针打印矩阵{
	public static void main(String[]args) {
		//int [][]arr = {{1,2},{3,4}};
		//int [][]arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int [][]arr = {{1,2,3,4,5}};
		printMatrix(arr);
	}
	
	public static ArrayList<Integer> printMatrix(int [][] matrix) {
			ArrayList<Integer> arrayList = new ArrayList<Integer>();
			if(matrix.length == 0) {
				return null; 
			}
			
			int up = 0 , bottom = matrix.length-1 , left = 0 , right = matrix[0].length-1;
			while((up<=bottom)&&(left<=right)) {
				//ֱ�����±߽��غ� ���ұ߽��غ�
				//����ϲ�
	
					for(int i = left ;i <= right ;i++) {
						//System.out.println(matrix[up][i]);
						arrayList.add(matrix[up][i]);
					}			

				//����Ҳ�

					for(int i = up+1 ; i <= bottom ;i++) {
						//System.out.println(matrix[i][right]);
						arrayList.add(matrix[i][right]);
					}		
						
				//����²�
				if(up<bottom) {
					for(int i =right-1 ;i >= left ;i--) {
						//System.out.println(matrix[bottom][i]);
						arrayList.add(matrix[bottom][i]);
					}		
				}
						
				//�����
				if(left<right) {
					for(int i = bottom-1; i >= up+1 ;i--) {
						//System.out.println(matrix[i][left]);
						arrayList.add(matrix[i][left]);
					}				
				}
				up++;
				right--;
				left++;
				bottom--;		

			}
			
	       return arrayList;
    }
}
