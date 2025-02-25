package graph;

import java.util.*;
/*
https://leetcode.com/problems/surrounded-regions/description/
You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.



Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 */
public class SurroundedRegions {

    int r;
    int c ;

    int [][] directions = new int[][] { {0,1},{1,0},{0,-1},{-1,0}};

    public void solve(char[][] board) {
        r = board.length;
        c = board[0].length;

        // traverse all the border
        for(int i=0 ; i <r ; i++)
        {
            if(board[i][0] == 'O'){
                bfss(board,i,0);
            }
            if(board[i][c-1] == 'O'){
                bfss(board,i,c-1);
            }
        }

        for(int i=0 ; i <c ; i++)
        {
            if(board[0][i] == 'O'){
                bfss(board,0,i);
            }
            if(board[r-1][i] == 'O'){
                bfss(board,r-1,i);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }

    }

    public void bfss(char[][] grid,int i,int j)
    {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j]='T';
        while(!q.isEmpty())
        {
            int [] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            for(int[] dir : directions)
            {
                int newR = dir[0]+currRow;
                int newC = dir[1]+currCol;

                if(newR >= r || newC >=c
                        || newC<0 || newR<0 || grid[newR][newC] != 'O')
                    continue;
                grid[newR][newC] = 'T';
                q.offer(new int[] {newR,newC});

            }
        }
    }
}
