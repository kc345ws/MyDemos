package com.kc345ws.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
* 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 

限制：

1 <= target <= 10^5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _1543和为s的连续正数序列 {
    public int[][] findContinuousSequence(int target) {
        //滑动窗口优化
        List<int[]> list = new ArrayList<>();
        int startindex = 1;//滑动窗口起始数字
        int endindex = 2;//滑动窗口结束数字
        int sum = 0;
        while(startindex <= (target>>1)){//大于目标值1/2后不用再继续滑动
            while(endindex <= (target>>1)+1){
//                ArrayList item = new ArrayList();
                int[] item = new int[endindex-startindex+1];
                int index = 0;
                for(int i = startindex ; i <= endindex ; i++){
                    sum += i;//对窗口内数字求和
                    item[index] = i;
                    index++;
                }
                if(sum == target){
                    list.add(item);
                }else if(sum > target){
                    break;//和已经大于目标值了不用再继续往后滑动窗口
                }
                endindex++;
                sum = 0;
            }
            sum = 0;
            startindex++;
            endindex = startindex + 1;
        }

        int index = 0;
        int j = 0;
        int [][]result = new int[list.size()][];
        for(int[] arrayList : list){
            result[index] = new int[arrayList.length];
            for(int item : arrayList){
                result[index][j] = item;
                j++;
            }
            index++;
            j=0;
        }
        return result;
    }

}

/*
public int[][] findContinuousSequence(int target) {
        //滑动窗口优化
        List<int[]> list = new ArrayList<>();
        int startindex = 1;//滑动窗口起始数字
        int endindex = 2;//滑动窗口结束数字
        int sum = 0;
        while(startindex <= (target>>1)){
            while(endindex <= (target>>1)+1){
//                ArrayList item = new ArrayList();
                int[] item = new int[endindex-startindex+1];
                int index = 0;
                for(int i = startindex ; i <= endindex ; i++){
                    sum += i;
                    item[index] = i;
                    index++;
                }
                if(sum == target){
                    list.add(item);
                }else if(sum > target){
                    break;
                }
                endindex++;
                sum = 0;
            }
            sum = 0;
            startindex++;
            endindex = startindex + 1;
        }

        int index = 0;
        int j = 0;
        int [][]result = new int[list.size()][];
        for(int[] arrayList : list){
            result[index] = new int[arrayList.length];
            for(int item : arrayList){
                result[index][j] = item;
                j++;
            }
            index++;
            j=0;
        }
        return result;
    }


* public int[][] findContinuousSequence(int target) {
        //滑动窗口
        List<List<Integer>> list = new ArrayList<>();
        int startindex = 1;//滑动窗口起始数字
        int endindex = 2;//滑动窗口结束数字
        int sum = 0;
        while(startindex <= (target>>1)){
            while(endindex <= (target>>1)+1){
                ArrayList item = new ArrayList();
                for(int i = startindex ; i <= endindex ; i++){
                    sum += i;
                    item.add(i);
                }
                if(sum == target){
                    list.add(item);
                }else if(sum > target){
                    break;
                }
                endindex++;
                sum = 0;
            }
            sum = 0;
            startindex++;
            endindex = startindex + 1;
        }

        int index = 0;
        int j = 0;
        int [][]result = new int[list.size()][];
        for(List<Integer> arrayList : list){
            result[index] = new int[arrayList.size()];
            for(int item : arrayList){
                result[index][j] = item;
                j++;
            }
            index++;
            j=0;
        }
        return result;
    }
* */
