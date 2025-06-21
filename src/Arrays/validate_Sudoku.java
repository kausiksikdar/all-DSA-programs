package Arrays;

public class validate_Sudoku {
    static boolean validateRow(char[][] board, int row, char ele, int sameCol)
    {
        for(int j=0;j<9;j++)
            if(j != sameCol && board[row][j] == ele)
                return false;

        return true;
    }
    static boolean validateCol(char[][] board, int col, char ele, int sameRow)
    {
        for(int i=0;i<9;i++)
            if(i != sameRow && board[i][col] == ele)
                return false;

        return true;
    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j] == '.')
                    continue;

                if(!validateRow(board,i,board[i][j],j))
                    return false;
                if(!validateCol(board,j,board[i][j],i))
                    return false;

                for(int diagRow=i/3*3;diagRow<(i/3*3)+3;diagRow++)
                    for(int diagCol=j/3*3;diagCol<(j/3*3)+3;diagCol++)
                    {
                        if(diagRow == i && diagCol == j)
                            continue;
                        if(board[diagRow][diagCol] == board[i][j])
                            return false;
                    }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
