package linkedlist;

public class Solution {

    public static void solution(String[] board) {
        int n = board.length; // number of rows
        int m = board[0].length(); // number of columns

        int count = 0;

        // Loop over all possible bottom-right corners of the rectangle
        for (int rowEnd = 0; rowEnd < n; rowEnd++) {
            for (int colEnd = 0; colEnd < m; colEnd++) {
                // Check if we have a rectangle from (0, 0) to (rowEnd, colEnd)
                int countA = 0, countB = 0;

                for (int row = 0; row <= rowEnd; row++) {
                    for (int col = 0; col <= colEnd; col++) {
                        if (board[row].charAt(col) == 'A') {
                            countA++;
                        } else if (board[row].charAt(col) == 'B') {
                            countB++;
                        }
                    }
                }

                // Check if the count of A and B is the same
                if (countA == countB) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        String[] board = {
                "A..",
                ".B.",
                "..A"
        };

        solution(board);
    }
}
