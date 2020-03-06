package com.kc345ws.oj;

import com.kc345ws.leetcode.*;
import com.kc345ws.utils.MyTreeUtils;

//������
public class TestClass {
	public static void main(String[]args) {
//		_026��ӡ��1������nλ�� _026 = new _026��ӡ��1������nλ��();
//		MyArrayUtils.printArray(_026.printNumbers(10));
//		_0078�Ӽ� t = new _0078�Ӽ�();
//		t.subsets(MyArrayUtils.getArray(1,2,3));
//		_0090�Ӽ�2 t =new _0090�Ӽ�2();
//		t.subsetsWithDup(MyArrayUtils.getArray(1,2,3));
//		_029����ת�ַ��� t = new _029����ת�ַ���();
//		t.reverseLeftWords("abcdefg", 2);
//		_1428�ϲ���������� t = new _1428�ϲ����������();
//		t.merge(MyArrayUtils.getArray(0,0,0,0,0), 0, MyArrayUtils.getArray(1,2,3,4,5),5);
		//_1428合并排序的数组 t = new _1428合并排序的数组();
		//t.merge(MyArrayUtils.getArray(4,5,6,0,0,0), 3, MyArrayUtils.getArray(1,2,3),3);
		//Integer.toBinaryString(2);
		//(11<<1，1000>>1)
		//System.out.println(8>>1);
//		_0994腐烂的橘子 t = new _0994腐烂的橘子();
//		t.orangesRotting(MyArrayUtils.get2dArray("[[1,2]]"));
//		_1417幂集 t_1417幂集 = new _1417幂集();
//		t_1417幂集.subsets(MyArrayUtils.getArray(1,2,3));
//		_1422括号 t = new _1422括号();
//		t.generateParenthesis(3);
//		_1108IP地址无效化 t = new _1108IP地址无效化();
//		t.defangIPaddr("1.1.1.1");
//		_1221分割平衡字符串 t = new _1221分割平衡字符串();
////		t.balancedStringSplit("RLRRLLRLRL");
//		_1543和为s的连续正数序列 t = new _1543和为s的连续正数序列();
//		t.findContinuousSequence(9);
		_1315祖父节点值为偶数的结点和 t = new _1315祖父节点值为偶数的结点和();
		Object[] objs = {61,13,46,null,null,null,56,72};
		t.sumEvenGrandparent(MyTreeUtils.createBinary(objs));
	}
}
