package leetcode;

import general.Utils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Alex.Z
 * @DATE: 2018/9/6
 * @Description: Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {

    @Test
    public void test() {
        assert (isMatch("aa", "*") == true);
        assert (isMatch("ab", "*a*b*") == true);
        assert (isMatch("a", "a*") == true);
        assert (isMatch("mississippi", "m??*ss*?i*pi") == false);
        assert (isMatch("c", "*?*") == true);
        assert (isMatch("b", "?*?") == false);
    }


    public boolean isMatch(String s, String p) {
        if (s.length() == 0 && p.length() == 0) return true;
        if (s.length() == 0 && p.equals("*")) return true;
        if (s.length() == 0 && p.length() > 0) return false;
        if (s.length() > 0 && p.length() == 0) return false;

        boolean[][] state = new boolean[s.length()][p.length()];//假设初始化是false
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            for (int j = 0; j < p.length(); ++j) {
                if(pChar[j]=='*'){
                    if(j>0 && state[i][j-1]){
                        state[i][j] = true;
                        continue;
                    }
                    else if(j==0){
                        state[i][j] = true;
                        continue;
                    }
                }
                if(equal(sChar[i],pChar[j])){
                    if(i>0 && j>0 && state[i-1][j-1]){
                        state[i][j] = true;
                    }
                    if(i>0 && pChar[j]=='*' && state[i-1][j]){
                        state[i][j] = true;
                    }
                    if(i==0){
                        if(firstEntity(pChar,j))
                            state[i][j] = true;
                    }


                }
            }
        }
        if (state[s.length() - 1][p.length() - 1]) return true;
        return false;
    }

    private boolean firstEntity(char[] pChar, int j) {
        for(int i=0;i<j;++i){
            if(pChar[i]!='*'){
                return false;
            }
        }
        return true;
    }

    private boolean equal(char c, char c1) {
        return c==c1 || c1=='?' || c1=='*';
    }


}
