package graph;
import java.util.*;
public class NumberOfIslands {
    int rowCount;
    int colCount;
    int[][] directions = new int[][] { {0,1}, {1,0} , {0,-1}, {-1,0} };
    public int numIslands(char[][] grid) {

        rowCount = grid.length;
        colCount= grid[0].length;

        int count=0;
        for(int i=0 ;i < rowCount ; i++)
        {
            for(int j=0 ; j < colCount; j++)
            {
                if(grid[i][j]=='1')
                {
                    count ++;
                    bfs(grid,i,j);
                }
            }
        }
        return count;

    }
    public void bfs(char[][] grid, int i, int j){

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j]='0';
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
                        || newC<0 || newR<0 || grid[newR][newC] != '1')
                    continue;
                grid[newR][newC] = '0';
                q.offer(new int[] {newR,newC});

            }
        }

    }
}
