package com.kc345ws.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0003无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        //滑动窗口
        if (s.length() == 0) return  0;
        int startindex = 0;//滑动窗口初始位置
        int endindex = 1;//滑动窗口初始结束位置
        int cnt = 0;//最长无重复子串长度
        while(endindex <= s.length()){//注意边界条件
            Map <Character , Integer> map = new HashMap<>();
            boolean isrepeate = false;
            //int repeateindex = -1;//重复元素索引
            for (int i = startindex ; i <endindex;i++){
                char ch = s.charAt(i);
                if(map.containsKey(ch)) map.put(ch,map.get(ch)+1);
                else map.put(ch,1);
                if (map.get(ch) > 1){
                    isrepeate = true;
                    break;
                }//有重复元素
            }
            if (isrepeate) startindex++;
            else if((endindex-startindex)>cnt) cnt = endindex-startindex;
            endindex++;
        }
        return cnt;
    }
}
