package com.kc345ws.utils;

//���鹤����
public class MyArrayUtils {
	//��ӡ����
	public static void printArray(Object[] objects) {
		for(int i = 0 ; i < objects.length ; i++) {
			System.out.println(objects[i]);
		}
	}

	public static void printArray(int[] printNumbers) {
		for(int i = 0 ; i < printNumbers.length ; i++) {
			System.out.println(printNumbers[i]);
		}
	}
	
	public static int[] getArray(int ...args) {
		return args;
	}
	
	public static int[] getArray(String str) {
		str.replace("[","");
		str.replace("]","");
		String[]strs = str.split(",");
		int[] arr = new int[strs.length];
		for(int i = 0 ; i < strs.length;i++) {

			arr[i] = Integer.valueOf(strs[i]);
		}
		return arr;
	}

	public static Object[] getObjects(String str){
		str = str.replaceAll("\\[|]","");
		Object[] objs = str.split(",");
		return objs;
	}

	public static int[][] get2dArray(String str) {
		//String为不可变类型
		str = str.replaceAll("\\[|\n", "");
		str = str.replaceAll("\\],|]", "#");
		String[]rs = str.split("\\#");
		int[][] arrs = new int[rs.length][];
		for(int i = 0 ; i < rs.length ;i++) {
			arrs[i] = getArray(rs[i]);
		}
		return arrs;
	}
}
