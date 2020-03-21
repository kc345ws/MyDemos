package com.kc345ws.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
* 有两个容量分别为 x升 和 y升 的水壶以及无限多的水。请判断能否通过使用这两个水壶，
* 从而可以得到恰好 z升 的水？

如果可以，最后请用以上水壶中的一或两个来盛放取得的 z升 水。

你允许：

装满任意一个水壶
清空任意一个水壶
从一个水壶向另外一个水壶倒水，直到装满或者倒空
示例 1: (From the famous "Die Hard" example)

输入: x = 3, y = 5, z = 4
输出: True
示例 2:

输入: x = 2, y = 6, z = 5
输出: False
* */
public class _0365水壶问题 {
    //BFS
    Queue<int[]> queue = new LinkedList<>();//可能的结果集
    //Set<int[]> visited = new HashSet<>();//中间结果集避免重复访问
    Set<Key> visited = new HashSet<>();
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;//两个水壶容量之和小于目标值
        else if(z == 0) return true;
        //visited.add(new int[]{0,0});//x y水壶都是0的情况
        visited.add(new Key(0,0));
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ; i < size ; i++) {
                int[] item = queue.poll();
                int curx = item[0];//当前结果集x和y的水的多少
                int cury = item[1];
                if(curx + cury == z || curx == z || cury == z) return true;
                //将X中的水全部倒出
                add(0,cury);
                //将Y中的水全部倒出
                add(curx,0);
                //将X全部倒满
                add(x,cury);
                //将Y全部倒满
                add(curx,y);
                //将X中的水倒入Y中，直到X为空或Y满了
                int resty = y - cury;//Y的剩余容积
                if (curx > resty) add(curx - resty, y);
                else add(0, cury + curx);
                //将Y中的水倒入X中，直到Y为空或X满了
                int restx = x - curx;
                if(cury > restx) add(x , cury - restx);
                else add(curx+cury,0);
            }
        }
        return false;
    }
    //添加结果
    public void add(int x,int y){
        int []item = new int[]{x,y};
        Key key = new Key(x,y);
        if(!visited.contains(key)) {
            visited.add(key);
            queue.add(item);
        }
    }

    static class Key{
        int x;
        int y;
        public Key(int x , int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            Key other = (Key)obj;
            return other.x == this.x && other.y == this.y;
        }

        @Override
        public int hashCode() {//重写了equals就必须重写hashcode
            return (x+1)*3 + y;
        }
    }
}
//BFS省时间 DFS省空间
