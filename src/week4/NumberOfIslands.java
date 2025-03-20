package week4;

import java.util.*;

/*

https://leetcode.com/problems/number-of-islands/description/

Given an m x n 2D binary grid  which represents a map of '1's (land) and '0's (water),
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally
or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


 */
public class NumberOfIslands {


    int rowCount;
    int colCount;
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public static void main(String[] args) {
        char [][] grid = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(new NumberOfIslands().numIslands(grid));
    }

    public int numIslands(char[][] grid) {

        rowCount = grid.length;
        colCount= grid[0].length;

        int count=0;
        boolean visited[][] = new boolean[rowCount][colCount];
        for(int i=0 ;i < rowCount ; i++)
        {
            for(int j=0 ; j < colCount; j++)
            {
                if( grid[i][j] =='1' && !visited[i][j])
                {
                    count ++;
                    bfs(grid,i,j,visited);
                }
            }
        }
        return count;

    }

    public void bfs(char[][] grid, int i, int j, boolean [][] visited){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        visited[i][j]=true;
        while(!q.isEmpty())
        {
            int [] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            for(int[] dir : directions)
            {
                int newR = dir[0]+currRow;
                int newC = dir[1]+currCol;

                if(newR >= rowCount || newC >=colCount
                        || newC<0 || newR<0 || visited[newR][newC] || grid[newR][newC] =='0' )
                    continue;
                visited[newR][newC] = true;
                q.offer(new int[] {newR,newC});

            }
        }

    }
}
