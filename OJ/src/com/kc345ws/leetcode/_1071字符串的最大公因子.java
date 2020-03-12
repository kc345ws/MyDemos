package com.kc345ws.leetcode;
/*
* 对于字符串 S 和 T，只有在 S = T + ... + T（T 与自身连接 1 次或多次）时，我们才认定 
* “T 能除尽 S”。

返回最长字符串 X，要求满足 X 能除尽 str1 且 X 能除尽 str2。

 

示例 1：

输入：str1 = "ABCABC", str2 = "ABC"
输出："ABC"
示例 2：

输入：str1 = "ABABAB", str2 = "ABAB"
输出："AB"
示例 3：

输入：str1 = "LEET", str2 = "CODE"
输出：""
 

提示：

1 <= str1.length <= 1000
1 <= str2.length <= 1000
str1[i] 和 str2[i] 为大写英文字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/greatest-common-divisor-of-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _1071字符串的最大公因子 {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        //如果两个字符串交换位置后拼接结果不一样
        //说明其中一个字符串中至少有两种不同的字符
        //且其中一个字符在另一个字符串中不存在，则不论如何都不能同时除尽两个字符串

        //若两个字符可以被除尽，则最长字符串长度为两字符串最大公约数
        return str1.substring(0,gcd(str1.length(),str2.length()));
    }

    //最大公约数
    public int gcd(int a , int b){
        return (a % b == 0)?b:gcd(b , a % b);
    }
}
