package kc345ws.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）
 * 组合。

说明：解集不能包含重复的子集。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bracket-lcci
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _1422括号 {
	List<String> result = new ArrayList<String>();
	public List<String> generateParenthesis(int n) {
		
		dfs(n, 0, 0, "");
		return result;
    }
	
	//括号对数量 左括号数量	右括号数量
	public void dfs(int n , int leftnum ,int rightnum,String str){
		if(str.length() == 2*n) {
			result.add(str);
		}
		
		if(leftnum <  n) {
			dfs(n, leftnum + 1 ,rightnum, str+"(");
		}
		if(rightnum < n && rightnum < leftnum) {
			//左括号数量大于右括号数量时才能继续添加
			dfs(n, leftnum, rightnum+1, str+")");
		}
		
	}
}
