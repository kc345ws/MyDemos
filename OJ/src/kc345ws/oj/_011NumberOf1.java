package kc345ws.oj;

/*
 * ��Ŀ����������1�ĸ���
 * ����������һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 * */
public class _011NumberOf1 {
	public static void main(String[]args) {
		
	}
	
	public static int NumberOf1(int n) {
		int cnt = 0;

		while(n!=0) {
			 cnt++;
			 n = n&(n-1);
			 //-1����ȥ�����ұߵ�1
			 //��������λ��������ʧ
		}
		return cnt;
    }
}
