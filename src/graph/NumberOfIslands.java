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
