package leetcode;

import general.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Alex.Z
 * @DATE: 2018/8/7
 * @Description: Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 * @Example:
    Input:
    nums1 = [3, 4, 6, 5]
    nums2 = [9, 1, 2, 5, 8, 3]
    k = 5
    Output:
    [9, 8, 6, 5, 3]
 *@Solution: 首先考虑一个长度为N的序列，找到k个保持顺序所能形成的最大的数，根据什么来做决定呢？
 * @analysis_case: [1,2,3,4,5,6,7,8,9,0]
 */
public class CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        return null;
    }


    public int[] maxNumber(int[] nums1, int k){
        //step1. 构建一个状态集
        int [][] sta = new int[nums1.length][10];
        for (int i = 0; i < nums1.length; i++) {
            if(i>0) {
                sta[i]=sta[i-1].clone();
            }
            sta[i][nums1[i]]+=1;
        }

        //step2. 构建一个位置集
        List<List<Integer>> pos = new ArrayList<>(10);
        for(List<Integer> l : pos) {
            l = new ArrayList<>(nums1.length / 7);
        }
        for (int i = 0; i < nums1.length; i++) {
            pos.get(nums1[1]).add(i);
        }


        //step3.
//        int length = nums1.length;
//        for (int depth = 0; depth < k; depth++) {
//            //至少剩多少数字
//            int leastLeft = length-k-depth-1;
//            int maxDigit = findMax(sta[leastLeft]);
//            int index = findIndex(pos, maxDigit,nowPos,finalPos);
//            sub(sta, leastLeft+1, index);
//            sta[leastLeft+1][maxDigit]-=1;
//        }
        return null;
    }
}
