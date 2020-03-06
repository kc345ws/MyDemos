package kc345ws.oj;
//��Ŀ���滻�ո�
/*��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.
 * �򾭹��滻֮����ַ���ΪWe%20Are%20Happy*/

public class _002replaceSpace {
	public static void main(String[]args) {
		System.out.println(replaceSpace(new StringBuffer("We Are Happy")));
	}
	
	public static String replaceSpace(StringBuffer str) {
		if(str == null) {
			return null;
		}
		
		StringBuilder stringBuilder= new StringBuilder();
		for(int i = 0 ; i < str.length();i++) {
			if(str.charAt(i)==' ') {
				stringBuilder.append("%20");
			}else {
				stringBuilder.append(str.charAt(i));
			}
		}
		
		return stringBuilder.toString();
    }
}
