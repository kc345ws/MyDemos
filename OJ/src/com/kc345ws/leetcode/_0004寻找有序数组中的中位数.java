package com.kc345ws.leetcode;
/*
* 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0004寻找有序数组中的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int total = len1 + len2;
        int []nums = new int[total];
        int index1 = 0;
        int index2 = 0;
        for(int i = 0 ; i < total ; i++){
            if(index1 < len1){
                if(index2 < len2 && nums2[index2] < nums1[index1]) {
                    nums[i] = nums2[index2];
                    index2++;
                }else{
                    nums[i] = nums1[index1];
                    index1++;
                }
            }else if(index2 < len2){
                nums[i] = nums2[index2];
                index2++;
            }
        }

        if((total&1) == 1) return nums[total/2];
        return (double) (nums[total/2] + nums[total/2 - 1])/2;
    }

}


/*
超时
* public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(nums1.length == 0) return nums2[len2/2];
        else if(nums2.length == 0) return nums1[len1/2];
        int target = nums1[len1/2];
        int left = 0 ;
        int right = nums2.length - 1;
        int middle = 0;
        if(len2 > 1) {
            while (left != right) {
                middle = (left + right) / 2;
                if (nums2[middle] > target) right = middle;
                else if (nums1[middle] < target) left = middle;
            }
        }
        if(((len1+len2) & 1) == 0){
            //如果两数组长度之和是偶数
            return (double) (target + nums2[middle])/2;
        }

        if(target <= nums2[middle]) return target;
        return nums2[middle];
    }
* */