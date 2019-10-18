package leetcode;

import org.junit.Test;

/**
 * @Author: Alex.Z
 * @DATE: 2018/9/6
 * @Description:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 */
public class Trap {
    
    
    @Test
    public void test(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    
    
    public int trap(int[] height) {
        int[] leftmax = new int[height.length];
        int[] rightmax = new int[height.length];
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if(height[i]> max) max = height[i];
            leftmax[i] = max;
        }
        max = 0;
        for (int i = height.length-1; i >=0 ; i--) {
            if(height[i]> max) max = height[i];
            rightmax[i] = max;
        }
        int sum =0;
        for (int i = 0; i < height.length; i++) {
            int minMax = leftmax[i]<rightmax[i]? leftmax[i]: rightmax[i];
            sum+= minMax-height[i];
        }
        return sum;
    }
}
