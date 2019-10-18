package leetcode;

import java.util.*;

/**
 * @Author: Alex.Z
 * @DATE: 2018/8/2
 * @Description:
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ret = new HashSet<>(100);
        List<List<Integer>> retList = new ArrayList<>(100);
        Map<Integer, Integer> numsMap = new HashMap<>(nums.length*2);
        for (int i = 0; i < nums.length; i++) {
            Integer v = numsMap.get(nums[i]);
            if(null==v){
                numsMap.put(nums[i],1);
            }
            else{
                numsMap.put(nums[i],v+1);
            }
        }
        for(int i=0;i< nums.length-2;++i){
            for(int j=i+1;j<nums.length-1;++j){
                int k1 =nums[i];
                int k2 = nums[j];
                int k3 = 0-k1-k2;
                Integer v = numsMap.get(k3);
                if(k3 == k1){
                    v-=1;
                }
                if(k3==k2){
                    v-=1;
                }
                if(null!=v && v>0){
                    List<Integer> tmp = new ArrayList<Integer>(3);
                    tmp.add(k1);
                    tmp.add(k2);
                    tmp.add(k3);
                    tmp.sort(Integer::compareTo);
                    ret.add(tmp);
                }

            }
        }
        ret.forEach(k->retList.add(k));
        return retList;
    }
}
