package com.kc345ws.oj;
/*������һ��m��n�еķ��񣬴����� [0,0] ������ [m-1,n-1] ��
 * һ�������˴����� [0, 0] �ĸ��ӿ�ʼ�ƶ�����ÿ�ο��������ҡ��ϡ����ƶ�һ��
 * �����ƶ��������⣩��Ҳ���ܽ�������������������λ֮�ʹ���k�ĸ��ӡ�
 * ���磬��kΪ18ʱ���������ܹ����뷽�� [35, 37] ����Ϊ3+5+3+7=18��
 * �������ܽ��뷽�� [35, 38]��
 * ��Ϊ3+5+3+8=19�����ʸû������ܹ�������ٸ�����
 * ��ʾ��

1 <= n,m <= 100
0 <= k <= 20
��Դ�����ۣ�LeetCode��
���ӣ�https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class _024机器人的运动范围 {
	public static void main(String[]args) {
		System.err.println(movingCount(38,15,9));
	}
	
	public static int movingCount(int m, int n, int k) {
		boolean [][] visited = new boolean[m][n];//���ʱ������
		return dfs(visited,0,0,k);
    }
	/*�������ͣ�ֵ����ھֲ��������У���������޸�ֻ���޸ĵ�ǰջ֡��ֵ��
	 * ����ִ�н����Է����ⲻ�����κθı䣻��ʱ��Ҫ�ı����ı�����
	 * ���뷵��������ֵ��

�����������ͣ�ָ�����ھֲ��������У����÷�����ʱ�򣬸�������ѹջ��
��ֵ���ı丱�������á��������ֱ�Ӹı丱�����õ�ֵ���޸������õ�ַ�Ķ���
����ʱ������������ô˵�ַ����Ȼ���޸ġ�
���������ã�ͬһ����ַ���κ��޸���Ϊ2������ͬʱ��Ч��
	 * */
	public static int dfs(boolean [][] visited , int row, int col, int k) {
		int height = visited.length-1;
		int width = visited[0].length-1;
		int cnt = 0;//��ջ���޸Ĳ��������ջ��ֵ����Ӱ��
		int sumrow = sums(row);
		int sumcol = sums(col);//��λ��
		if(row < 0 || row > height || col < 0 || col > width
				|| (sumrow+sumcol) > k) {
			return 0;
		}
		cnt++;
		visited[row][col] = true;//���Ϊ���ʹ�
		if(row+1<=height&&!visited[row+1][col]&&((sumrow+1+sumcol)<=k||((sumrow+1)%10)<=k)) {
			//��һ������û��Խ��
			//���û�г����߽���û�б����ʹ�������֮�Ͳ�����k
			//���ߺ��Աߵ���������ͨ
			cnt += dfs(visited, row+1, col, k);
		}
		if(col+1<=width&&!visited[row][col+1]&&((sumrow+1+sumcol)<=k||((sumcol+1)%10)<=k)) {
			cnt += dfs(visited, row, col+1, k);	
		}

		return cnt;
	}
	
	//�����λ��
	public static int sums(int x) {
		int sum = 0;
		while(x!=0) {
			sum += x % 10;
			x = x / 10;
		}
		return sum;
	}
}
