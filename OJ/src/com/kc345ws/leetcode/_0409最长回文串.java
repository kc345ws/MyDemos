package com.kc345ws.leetcode;
/*
* 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
* */
public class _0409最长回文串 {
    public int longestPalindrome(String s) {
        //统计s中奇数个字符的数量，只能有一个最多的
        int ans = 0;
        int oddnum =0;//防止第一步加-1
        int []cnt = new int['z'-'A'+1];//注意边界
        for(char ch : s.toCharArray()){
            cnt[ch-'A']++;
            //'A' 65 'a' 97
            //中间还有8个字符
            //
        }
        //除最长奇数字符外，其他奇数字符个数-1
        for(int i = 0 ; i < cnt.length ; i++){
            if((cnt[i]&1)==1)
            {
                if(cnt[i] > oddnum && oddnum !=0) {
                    ans += oddnum -1;
                    oddnum = cnt[i];
                }else if(cnt[i] > oddnum){
                    oddnum = cnt[i];
                } else{
                    ans += cnt[i] - 1;
                }
            }
            else ans+=cnt[i];
        }
        ans += oddnum;
        return ans;
    }
}
