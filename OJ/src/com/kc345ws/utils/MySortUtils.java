package com.kc345ws.utils;

public class MySortUtils {
    //快速排序
    public static void quickSort(int arr[] ,int left , int right){
        if(right < left)
            return;
        int low = left;
        int high = right;
        int base=arr[left];//本轮基准数
        while(low < high){
            while(high > low && arr[high] >= base)
            high--;//从右向左找到第一个比base小的数
            while(low < high && arr[low] <= base)
                low++;//从左向右找到第一个比base大的数
            //交换找到两个数的位置
            if(low < high){
                int tmp = arr[low];
                arr[low] = arr[high];
                arr[high] = tmp;
            }
        }
        //基准数归位
        int tmp = arr[high];
        arr[high] = base;
        arr[left] = tmp;
        quickSort(arr,left,high-1);
        quickSort(arr,high+1,right);
    }
}
