package com.kc345ws.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 
* 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。

示例 2:

[[0,0,0,0,0,0,0,0]]
对于上面这个给定的矩阵, 返回 0。

注意: 给定的矩阵grid 的长度和宽度都不超过 50。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/max-area-of-island
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */
public class _0695岛屿的最大面积 {
    //bfs
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                int cur = 0;//一个岛屿的面积
                Queue<Integer> queue_i = new LinkedList<>();
                Queue<Integer> queue_j = new LinkedList<>();
                queue_i.add(i);
                queue_j.add(j);
                while(!queue_i.isEmpty()){
                    int cur_i = queue_i.poll();
                    int cur_j = queue_j.poll();
                    if(cur_i <0 || cur_j < 0||cur_i>=grid.length||cur_j>=grid[0].length||grid[cur_i][cur_j]==0)
                        continue;
                    cur++;
                    grid[cur_i][cur_j] = 0;//标记为访问过
                    //检查该土地上下左右是否也是土地
                    if(cur_i+1<grid.length && grid[cur_i+1][cur_j] == 1)
                    {
                        queue_i.add(cur_i+1);
                        queue_j.add(cur_j);
                    }
                    if(cur_i-1>=0&&grid[cur_i-1][cur_j] == 1){
                        queue_i.add(cur_i-1);
                        queue_j.add(cur_j);
                    }
                    //此处不是grid.length
                    if(cur_j+1<grid[0].length && grid[cur_i][cur_j+1] == 1)
                    {
                        queue_i.add(cur_i);
                        queue_j.add(cur_j+1);
                    }
                    if(cur_j-1>=0&&grid[cur_i][cur_j-1] == 1){
                        queue_i.add(cur_i);
                        queue_j.add(cur_j-1);
                    }
                }
                ans = Math.max(ans,cur);
            }
        }
        return ans;
    }

}
/*
* //DFS
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                ans = Math.max(ans,DFS(grid,i,j));
            }
        }
        return ans;
    }

    public int DFS(int[][] grid , int i , int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0){
            return 0;
        }
        int num = 1;
        grid[i][j] = 0;//将该片土地设置为访问过
        num += DFS(grid,i+1,j);
        num += DFS(grid,i-1,j);
        num += DFS(grid, i , j +1);
        num += DFS(grid,i,j-1);
        return num;
    }
* */
