package com.kc345ws.leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
* */
public class _0017电话号码的字母组合 {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrace(map,"",digits,0);
        return ans;
    }

    //数字字母映射    当前item  数字  数字索引    字符索引
    public void backtrace(Map<Character,String> map ,String item ,String digits , int numindex){
        if(numindex >= digits.length()) {
            if(item.length() == digits.length())
            ans.add(item);
            return;
        }
        String str = map.get(digits.charAt(numindex));
        StringBuilder stringBuilder;
        //选择该数字映射的一个字母
        stringBuilder = new StringBuilder();
        stringBuilder.append(item);
        stringBuilder.append(str.charAt(0));
        backtrace(map,stringBuilder.toString(),digits,numindex+1);
        for(int i = 0 ; i < str.length(); i++){
            //撤销选择
            stringBuilder = new StringBuilder();
            stringBuilder.append(item);
//            if(stringBuilder.length()-1 >= 0)
//                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            if(i + 1 < str.length()) {
                stringBuilder.append(str.charAt(i + 1));
                backtrace(map, stringBuilder.toString(), digits, numindex + 1);
            }
        }
    }
}
