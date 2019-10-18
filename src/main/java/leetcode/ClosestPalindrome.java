package leetcode;

import java.math.BigInteger;

/**
 * @Author: Alex.Z
 * @DATE: 2019/4/12
 * @Description:
 * Given an integer n, find the closest integer (not including itself), which is a palindrome.

 * The 'closest' is defined as absolute difference minimized between two integers.

 *Example 1:
 *Input: "123"
 *Output: "121"
 *Note:
 *The input n is a positive integer represented by string, whose length will not exceed 18.
 *If there is a tie, return the smaller one as answer.
 */
public class ClosestPalindrome {


    class NumPalindrome {
        public String prev(String num) {
            StringBuilder sb = new StringBuilder(num.length());
            int mid = num.length() / 2;
            int even = num.length() % 2;
            BigInteger forePart = new BigInteger(num.substring(0, mid + even));
            String foreStr = forePart.subtract(new BigInteger("1")).toString();
            if (foreStr.length() == (mid + even)) {
                sb.append(foreStr);
                StringBuilder rsb = new StringBuilder(sb).reverse();
                if (even == 1) {
                    sb.append(rsb.deleteCharAt(0));
                } else {
                    if (sb.length() == 1 && sb.charAt(0) == '0') return "9";
                    sb.append(rsb);
                }
            } else {
                sb.append(foreStr);
                StringBuilder rsb = new StringBuilder(sb).reverse();
                if (even == 1) {
                    sb.append(rsb);
                } else {
                    sb.append('9').append(rsb);
                }
            }
            return sb.toString();
        }

        public String next(String num) {
            StringBuilder sb = new StringBuilder(num.length());
            int mid = num.length() / 2;
            int even = num.length() % 2;
            BigInteger forePart = new BigInteger(num.substring(0, mid + even));
            String foreStr = forePart.add(new BigInteger("1")).toString();
            if (foreStr.length() == (mid + even)) {
                sb.append(foreStr);
                StringBuilder rsb = new StringBuilder(sb).reverse();
                if (even == 1) {
                    sb.append(rsb.deleteCharAt(0));
                } else {
                    sb.append(rsb);
                }
            } else {
                sb.append(foreStr);
                StringBuilder rsb = new StringBuilder(sb).reverse();
                if (even == 1) {
                    if (rsb.length() <= 2) return "11";
                    sb.append(rsb.deleteCharAt(0).deleteCharAt(0));
                } else {
                    sb.append(rsb.deleteCharAt(0));
                }
            }
            return sb.toString();
        }

        public String format2PalindromeByForePart(String num){
            StringBuilder sb =new StringBuilder(num.length());
            int mid = num.length()/2;
            int even=num.length()%2;
            String forePart = num.substring(0,mid+even);
            sb.append(forePart);
            StringBuilder rsb = new StringBuilder(sb).reverse();
            if(even==1){
                sb.append(rsb.deleteCharAt(0));
            }
            else{
                sb.append(rsb);
            }
            return sb.toString();
        }
    }
    public String nearestPalindromic(String n) {
        if(n.equals("0")) return "1";
        NumPalindrome numPalindrome = new NumPalindrome();
        String tmp = numPalindrome.format2PalindromeByForePart(n);
        BigInteger tmpPa = new BigInteger(tmp);
        BigInteger num = new BigInteger(n);




        BigInteger next = new BigInteger(numPalindrome.next(tmp));
        BigInteger prev = new BigInteger(numPalindrome.prev(tmp));

        if(tmpPa.compareTo(num)<0) prev =  tmpPa;
        else if (tmpPa.compareTo(num)>0) next =tmpPa;

        BigInteger deltaA = next.subtract(num);
        BigInteger deltaB = num.subtract(prev);
        if(deltaA.compareTo(deltaB)<0) {
            return next.toString();
        }
        else return prev.toString();

    }
}
