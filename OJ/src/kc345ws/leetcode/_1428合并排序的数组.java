package kc345ws.leetcode;

import java.awt.Point;

/*
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。
 *  编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

示例:

输入:
A = [1,2,3,0,0,0], m = 3
B = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sorted-merge-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _1428合并排序的数组 {
	public void merge(int[] A, int m, int[] B, int n) {
		//逆向双指针
		int a_point = m - 1;//A数组最后一个元素索引
		int b_point = n - 1;//B数组最后一个元素索引
		int cur = A.length - 1;//A数组最后一个索引
		
		while(cur>=0) {
			if(b_point>=0 && a_point >= 0 && B[b_point]>A[a_point]) {
				A[cur] = B[b_point]; 
				b_point--;
				//B中元素大于A，直接放在该索引处
			}else if(b_point< 0) {
				break;
				//B中元素已经全部插入，直接跳出循环
			}
			else if(a_point < 0 ) {
				A[cur] = B[b_point];
				b_point--;
				//A中元素已经全部比较完，剩余B中元素按次序放入即可
			}
			else {//B[b_point]<=A[a_point]
				A[cur] = A[a_point];
				A[a_point] = 0;		
				a_point--;			
				//A中元素大于B，把A中元素移到该索引处，并把原索引处值设为0
			}
			cur--;
		}
		
    }
}
