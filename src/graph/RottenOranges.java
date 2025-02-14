package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList();


        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++)

                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    {
                        fresh++;
                    }
                }

        }

        if (fresh == 0) {
            return 0;
        }
        int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int size = queue.size();
            for(int i=0 ; i<size;i++) {
                int[] pair = queue.poll();
                for (int[] dir : directions) {
                    int newR = pair[0] + dir[0];
                    int newC = pair[1] + dir[1];

                    //check boundary
                    if (newR < 0 || newC < 0 || newR >= row || newC >= col
                            || grid[newR][newC] == 0 || grid[newR][newC] == 2)
                        continue;
                    grid[newR][newC] = 2;
                    queue.offer(new int[]{newR, newC});
                    fresh--;

                }
            }

        }

        if (fresh == 0)
            return count - 1;
        else
            return -1;

    }
}
