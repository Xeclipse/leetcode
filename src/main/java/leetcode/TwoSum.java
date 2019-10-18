package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Alex.Z
 * @DATE: 2019/1/18
 * @Description:
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mnums = new HashMap<Integer, Integer>(nums.length);
        for(int i=0;i<nums.length;++i){
            mnums.put(nums[i],i);
        }
        for(int i=0;i<nums.length;++i){
            Integer key = target - nums[i];
            Integer add = mnums.get(key);
            if(null!=add && i!=add){
                int[] ret = new int[2];
                ret[0]=i;
                ret[1]=add;
                return ret;
            }
        }
        return null;
    }
}
