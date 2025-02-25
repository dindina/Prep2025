package backtracking;

class WordSearch {
    public static void main(String[] args) {
        char [][] board = new char[][]{
                {'A','B','C','D'},
                {'S','A','A','T'},
                {'A','C','A','E'}
        };
        String word = "CAT";
        System.out.println(new WordSearch().exist(board,word));

    }
    int [] [] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    int row =0;
    int col =0;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        row = board.length;
        col = board[0].length;
        boolean [][] visited = new boolean[row][col];
        for(int i= 0 ; i < row ; i++){
            for(int j= 0 ; j < col ; j++){

                if(board[i][j] == word.charAt(0) &&  dfs(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;

    }
    public boolean dfs(char[][] board , String word , int r , int c , int pos, boolean[][] visited)
    {
        if (pos == word.length()){
            return true;
        }

        if( r < 0 || c < 0 || r >= row || c >= col || visited[r][c] || word.charAt(pos)!=board[r][c] )
            return false;

        visited[r][c]= true;

        boolean res = dfs(board,word,r+1,c,pos+1,visited)||
                dfs(board,word,r-1,c,pos+1,visited)||
                dfs(board,word,r,c+1,pos+1,visited)||
                dfs(board,word,r,c-1,pos+1,visited);
        visited[r][c]= false;
        return res;

    }
}
