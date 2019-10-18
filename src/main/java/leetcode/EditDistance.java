package leetcode;

import java.util.Arrays;

/**
 * @Author: Alex.Z
 * @DATE: 2019/1/30
 * @Description:编辑距离
 */
public class EditDistance  {
    public int minDistance(String word1, String word2) {
        int[][] state = new int[word1.length()+1][word2.length()+1];
        state[0][0]=0;
        for (int i = 0; i < word1.length() + 1; i++) {
            state[i][0]=i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            state[0][i]=i;
        }
        for (int i = 1; i < word1.length()+1; i++) {
            for (int j = 1; j < word2.length()+1; j++) {
                int a = 0;
                int b = 0;
                int c = 0;
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    a = state[i-1][j-1];
                else a = state[i-1][j-1]+1;

                b = state[i-1][j]+1;
                c = state[i][j-1]+1;
                state[i][j] = minint(a,b,c);
            }
        }
        return state[word1.length()][word2.length()];
    }

    private int minint(int a, int b, int c) {
        int m;
        if(a>b) m =b;
        else m=a;
        if(c<m) m=c;
        return m;
    }
}
