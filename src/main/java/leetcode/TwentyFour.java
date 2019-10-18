package leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * @Author: Alex.Z
 * @DATE: 2019/8/24
 * @Description:
 */
public class TwentyFour {




	public String calculate(int[] m, int tar ){
		return null;
	}


	public List<Float> f(List<Float> m){
		if(m.size()==1) return m;
		List<Float> ret = Lists.newArrayListWithExpectedSize(100);
		for(int i =1;i<m.size();++i){
			List<Float> left= Lists.newArrayListWithCapacity(i);
			for(int s =0;s<i;++s){
				left.add(m.get(s));
			}
			List<Float> right = Lists.newArrayListWithCapacity(m.size()-i);
			for(int s = i;s<m.size();++s){
				right.add(m.get(s));
			}

			List<Float> leftAns = f(left);
			List<Float> rightAns = f(right);

			for(int l=0;l<leftAns.size();++l){
				for(int r=0;r<rightAns.size();++r){
					ret.add(leftAns.get(l)+rightAns.get(r));
					ret.add(leftAns.get(l)-rightAns.get(r));
					ret.add(leftAns.get(l)*rightAns.get(r));
					if(rightAns.get(r)!=0) {
						ret.add(leftAns.get(l)/rightAns.get(r));
					}
				}
			}
		}
		return ret;
	}

	@Test
	public void testTT(){
		List<Float> nums = Lists.newArrayListWithExpectedSize(4);
		nums.add(1.0f);
		nums.add(2.0f);
		nums.add(3.0f);
		nums.add(4.0f);
		f(nums).forEach(System.out::println);
	}

}
