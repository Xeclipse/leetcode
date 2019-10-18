package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Alex.Z
 * @DATE: 2019/4/4
 * @Description:
 */
public class SolveSudoku {


    public class PermitX {
        public int x;
        public int[] state = new int[10];

        public void update(char[][] board) {
            for (int m = 0; m < board.length; ++m) {
                char c = board[x][m];
                if (c != '.') {
                    state[c - '0'] = 1;
                }
            }
        }
    }

    public class PermitY {
        public int y;
        public int[] state = new int[10];

        public void update(char[][] board) {
            for (int m = 0; m < board.length; ++m) {
                char c = board[m][y];
                if (c != '.') {
                    state[c - '0'] = 1;
                }
            }
        }

    }


    public class PermitChunk {
        public int num;
        public int[] state = new int[10];

        public void update(char[][] board) {
            int is = num / 3;
            int js = num % 3;
            for (int m = is * 3; m < (is + 1) * 3; ++m) {
                for (int n = js * 3; n < (js + 1) * 3; ++n) {
                    char c = board[m][n];
                    if (c != '.') {
                        state[c - '0'] = 1;
                    }
                }
            }
        }
    }


    public void solveSudoku(char[][] board) {
        char[][][] state = new char[9][9][10];
        for(int i=0;i<9;++i)
            for(int j=0;j<9;++j)
                for(int n=0;n<10;++n)
                    state[i][j][n]=0;

        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.')
                    updateState(i,j,board[i][j]-'0',board,state);
            }
        }

        if(solveSudokuRecurrent(0,board,state)){
            System.out.println("success");
            copyStates2board(board, state);
        }
    }

    private void copyStates2board(char[][] board, char[][][] state) {
        for(int i=0;i<9;++i) {
            for (int j = 0; j < 9; ++j) {
                if(board[i][j]=='.') {
                   board[i][j]= (char) ('0'+getStateFirst(state,i,j));
                }
            }
        }
    }

    private char getStateFirst(char[][][] state, int i, int j) {
        char[] s = state[i][j];
        for(i=1;i<10;++i){
            if(s[i]==0) return (char)i;
        }
        return (char)0;
    }

    public void updateState(int i, int j, int num, char[][] board, char[][][] state) {
        board[i][j] = (char) ('0' + num);
        for (int m = 0; m < 9; ++m) {
            state[m][j][num] += 1;
        }
        for (int m = 0; m < 9; ++m) {
            state[i][m][num] += 1;
        }
        int is = i / 3;
        int js = j / 3;
        for (int m = is * 3; m < (is + 1) * 3; ++m) {
            for (int n = js * 3; n < (js + 1) * 3; ++n) {
               state[m][n][num] += 1;
            }
        }
    }

    public void recoverState(int i, int j, int num, char[][] board, char[][][] state) {
        board[i][j] = '.';
        for (int m = 0; m < 9; ++m) {
            state[m][j][num] -= 1;
        }
        for (int m = 0; m < 9; ++m) {
            state[i][m][num] -= 1;
        }
        int is = i / 3;
        int js = j / 3;
        for (int m = is * 3; m < (is + 1) * 3; ++m) {
            for (int n = js * 3; n < (js + 1) * 3; ++n) {
                state[m][n][num]-=1;
            }
        }

    }


    //1:表示剩下的只有唯一一种可能
    //0：表示仍有可能的方案
    //-1：表示已经没有可能的方案
    public int checkState(char[][][] state, char[][] board) {
        for(int i=0;i<9;++i) {
            for (int j = 0; j < 9; ++j) {
                if(board[i][j]=='.') {
                    int s = check(state[i][j]);
                    if (s == 9) return -1;
                    if (s > 1 && s < 9) return 0;
                }
            }
        }
        return 1;
    }

    private int check(char[] chars) {
        int sum =0;
        for(int i=1;i<10;++i){
            if(chars[i]>0) sum+=1;
        }
        return sum;
    }

    public boolean solveSudokuRecurrent(int n, char[][] board, char[][][] state) {
        int i = n / 9;
        int j = n % 9;
        if(n==9*9) return false;
        if (board[i][j] == '.') {
            for (int p = 1; p < 10; ++p) {
                if (state[i][j][p] == 0) {
                    updateState(i, j, p, board, state);
                    int predict = checkState(state,board);
                    if (predict == 0) {
                        if(solveSudokuRecurrent(n+1, board, state)) return true;
                    }
                    if (predict == 1 )
                        return true;
                    recoverState(i, j, p, board, state);
                }

            }
        }
        else return solveSudokuRecurrent(n+1,board,state);
        return false;
    }
}
