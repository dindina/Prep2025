package week4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/rotting-oranges/
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottenOranges {

    public static void main(String[] args) {

        int[][] edges = new int[][]{

                {2,1,1},{0,1,1},{1,0,1}
        };
        System.out.println(new RottenOranges().orangesRotting(edges));


    }
    public int orangesRotting(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        System.out.println("row " + row);
        System.out.println("col " + col);
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        for(int i =0 ; i < row ; i++) {
            for(int j =0 ; j < col ; j++) {

                if(grid[i][j]==2) // put all rotten in the queue
                    queue.offer(new int[]{i,j});
                else if (grid[i][j]==1) // else count the fresh
                    freshCount++;
            }
        }

        if (freshCount == 0)
            return 0;

        int count =0;
        // start bfs
        int [][] dirs = new int[][] {  {1,0},{0,1},{0,-1},{-1,0}};
        while(!queue.isEmpty())
        {
            ++count;
            int size = queue.size();
            for( int i=0; i < size ; i++)
            {
                int [] point = queue.poll();
                for(int dir[] : dirs)
                {
                    int newx = point[0] + dir[0];
                    int newy = point[1] + dir[1];

                    if(newx < 0 || newy < 0 || newx >= row || newy >= col
                            || grid[newx][newy] == 2 || grid[newx][newy] == 0 )
                        continue;
                    grid[newx][newy] =2;
                    queue.offer(new int[]{newx,newy});
                    freshCount --;
                }

            }



        }


        return freshCount == 0 ? count-1:-1;

    }

}
