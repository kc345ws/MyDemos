package kc345ws.oj;

/*
 * ��Ŀ����ֵ�������η�
 * ����������һ��double���͵ĸ�����base��int���͵�����exponent��
 * ��base��exponent�η��� ��֤base��exponent��ͬʱΪ0 
 * */
public class _012Power {
	public static void main(String[]args) {
		long startTime = System.currentTimeMillis();
		System.out.println(Power(2,1000000000));
		
		long endTime = System.currentTimeMillis();
		System.out.println("��������ʱ�䣺" + (endTime - startTime) + "ms");
	}
	
	public static double Power(double base, int exponent) {
		
		if(base == 0) {
			return 0;
		}else if(exponent ==0) {
			return 1;
		}
		
		double result = 1.0;
		//������1.0
		while(exponent > 0){
			if((exponent&1)==0) {
				//���ָ����ż��
				exponent = exponent >> 1;//ָ������
				base *= base;//�������η�
			}else {
				//���ָ��������
				//exponent--;//ָ���ȼ�1��Ϊż��
				//������������������������ȥ���˲�
				result *= base;//�����һ��ָ��Ϊ1���м���
				exponent = exponent >> 1;//ָ������
				base *=base;
			}
		}
		while(exponent < 0){
			if((exponent&1)==0) {
				//���ָ����ż��
				exponent = exponent / 2;//ָ������
				base *= base;//�������η�
			}else {
				//���ָ��������
				//exponent++;//ָ���ȼ�1��Ϊż��
				result /= base;//�����һ��ָ��Ϊ1���м���
				exponent = exponent / 2;//ָ������
				base *=base;
			}
		}
		
		
			return result;
	 }
}
