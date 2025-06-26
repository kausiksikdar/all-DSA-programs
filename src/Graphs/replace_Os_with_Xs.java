package Graphs;

public class replace_Os_with_Xs {

    static int[] Row = {1,-1,0,0};
    static int[] Col = {0,0,1,-1};
    static boolean valid(int i, int j, char[][] board)
    {
        return i>=0 && i<board.length && j>=0 && j<board[0].length;
    }
    static void DFS(char[][] board, int row, int col, boolean[][] visited)
    {
        visited[row][col] = true;
        board[row][col] = 'T';
        for(int k=0;k<4;k++)
        {
            if(valid(row+Row[k],col+Col[k],board) && !visited[row+Row[k]][col+Col[k]] && board[row+Row[k]][col+Col[k]]=='O')
                DFS(board,row+Row[k],col+Col[k],visited);
        }
    }

    static void replace0sWithXs(char[][] board, int n, int m)
    {
        boolean[][] visited = new boolean[n][m];
        for (int j = 0; j < m; j++)
            if (board[0][j] == 'O')
                DFS(board, 0, j, visited);

        for (int j = 0; j < m; j++)
            if (board[n - 1][j] == 'O')
                DFS(board, n - 1, j, visited);

        for (int i = 0; i < n; i++)
            if (board[i][0] == 'O')
                DFS(board, i, 0, visited);

        for (int i = 0; i < n; i++)
            if (board[i][m - 1] == 'O')
                DFS(board, i, m - 1, visited);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
            {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
    }
    public static void main(String[] args) {
        char[][] board =
                {
                        {'X','X','X','O'},
                        {'X','X','X','O'},
                        {'X','O','X','X'},
                        {'X','X','O','X'}
                };
        int n = board.length;
        int m = board[0].length;

        replace0sWithXs(board,n,m);

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
