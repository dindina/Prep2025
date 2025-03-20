package array;


/*
https://leetcode.com/problems/game-of-life/description/
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.

Given the current state of the board, update the board to reflect its next state.

Note that you do not need to return anything.
 */
public class GameOfLife {

    public static void main(String[] args) {

        int[][] board1 = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        System.out.println("Test Case 1 (Before):");

        printBoard(board1);
        gameOfLife(board1);
        System.out.println("output");
        printBoard(board1);

    }
    public static void printBoard(int[][] board) {
        if (board == null || board.length == 0) {
            System.out.println("[]");
            return;
        }

        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


    public static void gameOfLife(int[][] board) {


        int rows = board.length;
        int cols = board[0].length;


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int count = findNeighbourCount(board, i, j);

                int val = board[i][j];

                //to die case
                if (val == 1) {
                    if (count > 3 || count < 2)
                        board[i][j] = 2; // mark it as die
                }
                // live case
                if (val == 0) {
                    if (count ==3)
                        board[i][j] = 3; // mark it as live
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }


    }



    public static int findNeighbourCount(int[][] board , int r , int c) {

        int count = 0;
        int[][] directions = {
                {1, 0},
                {0, 1},
                {1, 1},
                {-1, -1},
                {1, -1},
                {-1, 1},
                {-1, 0},
                {0, -1}

        };


        for (int[] dir : directions) {
            int newr = dir[0] + r;
            int newc = dir[1] + c;

            if (newr < 0 || newr >= board.length || newc < 0 || newc >= board[0].length)
                continue;

            if (board[newr][newc] == 1 || board[newr][newc] == 2) {
                count++;
            }


        }
        return count;
    }




}

