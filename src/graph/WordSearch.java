package graph;
/*
Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.

        For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.
        */


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
        row = board.length;
        col = board[0].length;
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        boolean [][] visited = new boolean[row][col];
        for(int i= 0 ; i < row ; i++){
            for(int j= 0 ; j < col ; j++){
                if(board[i][j] == word.charAt(0) && dfs(board,word,i,j,0,visited)){
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
        if(r < 0 || c < 0 || r >= row || c >= col
                || visited[r][c] || board[r][c] != word.charAt(pos))
            return false;

        visited[r][c]= true;
        for(int [] dir : directions){
            int newr = r + dir[0];
            int newc = c + dir[1];
            if(dfs(board,word,newr,newc,pos+1,visited)) {
                visited[r][c] = false;
                return true;

            }
        }
        //visited[r][c] = false;
        return false;

    }
}

