package leetcode;

import org.junit.Test;

/**
 * @Author: Alex.Z
 * @DATE: 2019/2/3
 * @Description:回文切分字符串
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 *Return the minimum cuts needed for a palindrome partitioning of s.

 *Example:

 *Input: "aab"
 *Output: 1
 *Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */
public class PalindromePartitioning {


    //a b c d d c f f
    //如果一个点切分，那么他左边的部分和右边的部分各需要多少步才能变成都是回文串
    //f(0,end)=min_i(f(0,i)+f(i+1,end))
    //f(i,i)=1


    public int minCut(String s){
        int[][] state = new int[s.length()+1][s.length()+1];
        for (int i=0;i<s.length()+1;++i){
            for(int j=i+1;j<s.length()+1;++j)
                state[i][j]=-1;
        }
        for(int i=0;i<s.length()+1;++i) {
            state[i][i] = 0;
            if(i<s.length()) state[i][i+1]=0;
        }

        for(int j=2;j<s.length()+1;++j){
            for(int i = j-2;i>=0;--i){
                if(isPa(s,i,j-1,state)) {
                    state[i][j]=0;
                    continue;
                }
                int tmp = Integer.MAX_VALUE;
                for(int k = i+1;k<j;++k){
                    int t = state[i][k]+state[k][j]+1;
                    if(t<tmp) tmp = t;
                }
                state[i][j]=tmp;
            }
        }
        return state[0][s.length()];
    }

    private int recu(String s, int i, int j, int[][] state) {
        if(state[i][j]!=-1) return state[i][j];
        if(isPa(s,i,j-1, state)) {state[i][j]=0;return 0;}
        if(j-i<=1) return 0;
        int ret = Integer.MAX_VALUE;
        for(int k = i+1;k<j; ++k){
            int left = recu(s,i,k,state);
            int right = recu(s,k,j,state);
            int tmp = left+right+1;
            if(tmp<ret) ret = tmp;
        }
        state[i][j]=ret;
        return ret;
    }

    private boolean isPa(String s, int i, int j, int[][] state) {
        for(;i<j;++i,--j){
            if(state[i][j+1]==0) return true;
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }
    @Test
    public void test(){
        System.out.println(minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}
