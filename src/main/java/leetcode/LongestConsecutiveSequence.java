package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Alex.Z
 * @DATE: 2019/1/28
 * @Description: Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 * <
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>((int) (nums.length * 1.5));
        for(int i : nums){
            numMap.put(i,0);
        }

        int max = 0;
        for(int i: nums){
            if(numMap.get(i)==0){
                int count = 1;
                //up
                for(int j=i+1;;j++){
                    if(null!=numMap.get(j)){
                        count +=1;
                        numMap.put(j,1);
                    }
                    else break;
                }
                //down
                for(int j=i-1;;j--){
                    if(null!=numMap.get(j)){
                        count +=1;
                        numMap.put(j,1);
                    }
                    else break;
                }

                if(count>max) max =count;
            }
        }

        return max;
    }
}
