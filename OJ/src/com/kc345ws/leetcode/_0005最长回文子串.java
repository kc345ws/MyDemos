package com.kc345ws.leetcode;
/*
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
* */
public class _0005最长回文子串 {
    public String longestPalindrome(String s) {
        int len = s.length();
        String ans = "";
        for(int i = 0 ; i < len ; i++){
            String str1 = findsubstring(s,i,i);//字符个数为奇数时
            String str2 = findsubstring(s,i,i+1);//字符个数为偶数时
            ans = (str1.length() > ans.length())?str1:ans;
            ans = (str2.length() > ans.length())?str2:ans;
        }
        return ans;
    }

    public String findsubstring(String str,int left , int right){
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
            //如果左右两索引都没有越界，且两索引字符相同
        }
        return str.substring(left+1,right);//substring不包括右边界
    }
}
/*
* 中心扩散法
* 从字符串一个索引开始向两边扩散
* */
