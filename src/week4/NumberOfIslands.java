package week4;

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


    int row =0;
    int col = 0;

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
        // logic iterate the grid , if the value of the cell is 1 incerement the number
        //perform dfs for the row and column
        int result =0;
        row = grid.length;
        col = grid[0].length;
        System.out.println("row " + row);
        System.out.println("col " + col
        );
        for ( int r = 0 ; r < row ; r++) {
            for (int c = 0; c < col; c++) {

                if(grid[r][c] == '1' ) {
                    result++;
                    dfsHelper1(grid,r,c);
                }

            }
        }
        return result;

    }

    private void dfsHelper1(char[][] grid, int r, int c) {

        for(int [] dir : directions)
        {
            int newR = dir[0]+r;
            int newC = dir[1]+c;

            if(newR < 0 || newR >= row || newC < 0 || newC >= col || grid[newR][newC] == '0'){
                return;
            }
            grid[newR][newC] = '0';
            dfsHelper1(grid,newR,newC);

        }


    }

    private void dfsHelper2(char[][] grid, int r, int c) {
        // check out of bound
        int row = grid.length;
        int col = grid[0].length;
        if (r < 0|| r >= row || c <0 || c >= col || grid[r][c] =='0' )
            return;
        grid[r][c]='0';

        dfsHelper2(grid,r+1,c);
        dfsHelper2(grid,r-1,c);
        dfsHelper2(grid,r,c+1);
        dfsHelper2(grid,r,c-1);


    }

}
