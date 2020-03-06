package kc345ws.leetcode;

import java.util.Stack;



/*
 * 在给定的网格中，每个单元格可以有以下三个值之一：

值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。

返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。

 

示例 1：



输入：[[2,1,1],[1,1,0],[0,1,1]]
输出：4
示例 2：

输入：[[2,1,1],[0,1,1],[1,0,1]]
输出：-1
解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
示例 3：

输入：[[0,2]]
输出：0
解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 

提示：

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] 仅为 0、1 或 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotting-oranges
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _0994腐烂的橘子 {
	@SuppressWarnings("unchecked")
	public int orangesRotting(int[][] grid) {
		//DFS
		//对所有腐烂橘子进行DFS
		boolean hasRott = false;//是否有腐烂橘子
		for(int i = 0 ; i < grid.length ; i++) {
			for(int j = 0 ; j < grid[0].length ;j++) {
				if(grid[i][j] == 2) {
					dfs(grid, i, j, 2);
					hasRott = true;
				}
			}
		}
	
		int maxRott = 0;//最大腐烂值
		for(int i = 0 ; i < grid.length ; i++) {
			for(int j = 0 ; j < grid[0].length ;j++) {
				if(grid[i][j] == 1) {
					return -1;//有新鲜橘子说明没有全部腐烂
				}
				maxRott = Math.max(maxRott, grid[i][j]);
			}
		}
		
		if(!hasRott) {
			//没有新鲜橘子且没有腐烂橘子
			return 0;
		}
		return maxRott - 2;//最大腐烂值减2就是最少腐烂天数
    }
	
	public void dfs(int[][] grid,int x , int y , int val) {
		//腐烂橘子的初始腐烂值为2，遇到新鲜橘子腐烂值设为2
		//若遇到腐烂橘子则将腐烂值+1，则最深处橘子腐烂值-2就是最小时间
		//若这条腐烂路径的腐烂值更小则更新腐烂值
		//引用类型的数据不能更改引用，但可以改变引用所指的值
		if(x + 1 < grid.length &&( grid[x+1][y] == 1 || val+1< grid[x+1][y])) {
			grid[x+1][y] = val + 1;
			dfs(grid, x+1, y, val+1);
		}
		if(x - 1 >= 0 && (grid[x-1][y] == 1 || val+1< grid[x-1][y])) {
			grid[x-1][y] = val + 1;
			dfs(grid, x-1, y, val+1);
		}
		if(y + 1 < grid[0].length &&( grid[x][y+1] == 1 || val+1< grid[x][y+1])) {
			grid[x][y+1] = val + 1;
			dfs(grid, x, y+1, val+1);
		}
		if(y - 1 >= 0 && (grid[x][y-1] == 1 || val+1< grid[x][y-1])) {
			grid[x][y-1] = val + 1;
			dfs(grid, x, y-1, val+1);
		}
	}
	
	class Point{
		public int x;
		public int y;
		public Point() {}
		public Point(int x , int y) {
			this.x = x;
			this.y = y;
		}
	}
}

//int time = 0;
//int height = grid.length;
//int width = grid[0].length;
//int freshcnt = 0;//新鲜橘子数量
//int rottcnt = 0;//新鲜橘子变腐烂的数量
////boolean[][] visited = new boolean[grid.length][grid[0].length];
//Stack<Point> stack = new Stack<>();
////先找出所有烂橘子
//for(int i = 0 ; i < height ; i++) {
//	for(int j = 0 ; j < width ; j++) {
//		if(grid[i][j] == 2) 
//			stack.push(new Point(i,j));		
//		else if(grid[i][j] == 1)
//			freshcnt++;
//	}
//}
//if(freshcnt == 0)
//	return 0;//没有新鲜橘子直接腐烂
//Point tmpPoint = null;
//while(!stack.isEmpty()) {
//	Stack<Point> thisstack = new Stack<>();
//	while(!stack.isEmpty()) {
//		tmpPoint = stack.pop();
//		if(tmpPoint.x - 1 >= 0 && grid[tmpPoint.x - 1][tmpPoint.y] == 1) {
//			thisstack.push(new Point(tmpPoint.x - 1 ,tmpPoint.y));
//			grid[tmpPoint.x - 1][tmpPoint.y] = 2;
//			rottcnt++;
//		}
//			
//		if(tmpPoint.x + 1 < height && grid[tmpPoint.x + 1][tmpPoint.y] == 1) {
//			thisstack.push(new Point(tmpPoint.x + 1 ,tmpPoint.y));
//			grid[tmpPoint.x + 1][tmpPoint.y] = 2;
//			rottcnt++;
//		}
//			
//		if(tmpPoint.y - 1 >= 0 && grid[tmpPoint.x][tmpPoint.y-1] == 1) {
//			thisstack.push(new Point(tmpPoint.x ,tmpPoint.y - 1));
//			grid[tmpPoint.x][tmpPoint.y-1] = 2;
//			rottcnt++;
//		}
//			
//		if(tmpPoint.y + 1 < width && grid[tmpPoint.x][tmpPoint.y+1] == 1) {
//			thisstack.push(new Point(tmpPoint.x ,tmpPoint.y + 1));
//			grid[tmpPoint.x][tmpPoint.y+1] = 2;
//			rottcnt++;
//		}
//	}
//	stack = (Stack<Point>) thisstack.clone();
//	time++;
//}	
//if(rottcnt == freshcnt) {
//	return time - 1;
//}
//return -1;//不能全部腐烂
