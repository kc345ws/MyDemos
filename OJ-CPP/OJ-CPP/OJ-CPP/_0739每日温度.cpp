#include"_0739每日温度.h"

vector<int> _0739每日温度::dailyTemperatures(vector<int>& T) {
	//递减栈
	vector<int> a;
	if (T.size() == 0) return a;
	stack<int> mystack;
	int len = T.size();
	vector<int> ans(len);//初始化为0；
	for (int i = 0; i < len; i++) {
		if (mystack.empty() || T[i] <= T[mystack.top()]) {
			//栈为空，或栈顶元素大于T中第i个元素
			mystack.push(i);
			if (i == len - 1) {
				//没有剩余天数
				while (!mystack.empty()) {
					ans[mystack.top()] = 0;
					mystack.pop();
				}				
			}
		}
		else {
			//栈顶元素大于T中第i个元素
			ans[mystack.top()] = i - mystack.top();
			mystack.pop();
			i--;
		}
	}
	return ans;
}
/*
根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高
超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 
[1, 1, 4, 2, 1, 1, 0, 0]。

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 
范围内的整数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/daily-temperatures
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
/*for (vector<int>::iterator iter = T.begin(); iter != T.end(); iter++) {
	}

	for (auto item : T) {}

	for (auto iter = T.begin(); iter != T.end(); iter++) {
	}*/



