package kc345ws.oj;
/*请设计一个函数，用来判断在一个矩阵中是否存在一条包含
 * 某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，
 * 每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经
 * 过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的
 * 3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
提示：

1 <= board.length <= 200
1 <= board[i].length <= 200

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _023矩阵中的路径 {
	public static void main(String[] args) {
		char [][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = 	"ABCCED";
		//exist(board,word);
	}
	
	public  boolean exist(char[][] board, String word) {
		//1.0 DFS+回溯法
		int width =board[0].length - 1;
		int height = board.length - 1;
		//从矩阵左上角开始DFS
		for(int i = 0 ; i <=  height ;i++) {
			for(int j = 0 ; j <= width ;j++) {
				if(dfs(board, word, 0, i , j)) 
					return true;		
			}
		}
		return false;
    }
	//参数：矩阵		字符串	已经匹配到的字符串索引	要访问的行列索引
	public  boolean dfs(char[][] board, String word , int index ,int row , int col) {
		char ch = word.charAt(index);
		//char tmp = ch;//储存字符串该索引下原来的字符用来递归成功或失败后恢复
		int width =board[0].length - 1;
		int height = board.length - 1;
		if(row > height || col > width || row < 0 || col < 0) {
			//如果行索引或者列索引大于矩阵高度或宽度，说明越界了直接返回true
			return false;
		}
		if(board[row][col] != ch || ch == '#') {
			//如果字符不匹配则继续向上下左右递归匹配
			//#代表已经被访问过了不能再次访问
			return false;//匹配失败不再向上下左右递归匹配
			//只要上下左右的其中一个匹配成功则返回true
		}else {
			//匹配成功
			if(index == word.length()-1) {
				//如果全部匹配完了直接返回true
				return true;
			}
			index++;//在字符串中的匹配字符索引+1
			//还没有全部匹配玩继续向向下左右递归匹配
			board[row][col] = '#';//标记访问过了
			if(dfs(board,word,index,row-1,col)
					||dfs(board, word, index, row+1, col)
					||dfs(board, word, index, row, col-1)
					||dfs(board, word, index, row, col+1)) {
				return true;
			}else {
				//匹配失败向上回溯，恢复被访问的值
				board[row][col] = ch;
				return false;
			}
		}
	}
	
}
