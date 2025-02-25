package graph;

import java.util.*;

/*
https://leetcode.com/problems/max-area-of-island/description/
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.


 */
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));


    }
    int rowCount;
    int colCount;

    int[][] directions = new int[][]{
            {0,1},{1,0},{-1,0},{0,-1}
    };

    public int maxAreaOfIsland(int[][] grid) {

        rowCount = grid.length;
        colCount = grid[0].length;
        System.out.println("row "+ rowCount);
        System.out.println("col "+ colCount);
        int count = 0;
        for(int i=0 ; i < rowCount ; i++) {
            for (int j = 0; j < colCount; j++) {
                if(grid[i][j] == 1) {
                    count = Math.max(count, bfsGrid(grid, i, j));
                }
            }
        }
        return count;
    }

    private int bfsGrid(int[][] grid, int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row,col});
        int counter=0;
        grid[row][col] = 5;
        while(!queue.isEmpty())
        {
            int[] pair = queue.poll();


            int currRow = pair[0];
            int currCol = pair[1];

            counter++;


            for(int [] dir : directions)
            {

                int newR = currRow + dir[0];
                int newC = currCol + dir[1];

                if(newR >= rowCount || newC >= colCount || newR <0 || newC < 0  || grid[newR][newC]!=1)
                    continue;
                if(grid[newR][newC] == 1) {
                    System.out.println("newR " + newR);
                    System.out.println("newC " + newC);
                    grid[newR][newC] = 5;
                    queue.offer(new int[]{newR, newC});
                }
            }


            System.out.println("end of  ") ;

        }
        System.out.println("counter " + counter);
        return counter;
    }

}
