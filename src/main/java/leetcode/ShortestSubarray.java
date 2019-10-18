package leetcode;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Alex.Z
 * @DATE: 2019/7/11
 * @Description: Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.
 * <p>
 * If there is no non-empty subarray with sum at least K, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1], K = 1
 * Output: 1
 * Example 2:
 * <p>
 * Input: A = [1,2], K = 4
 * Output: -1
 * Example 3:
 * <p>
 * Input: A = [2,-1,2], K = 3
 * Output: 3
 */
public class ShortestSubarray {



	public int shortestSubarray(int[] A, int K) {
		for(int i=1;i<A.length;++i){
			A[i]=A[i]+A[i-1];
		}
		int minLen = -1;
		int minIndex=-1;
		int min=0;
		for(int i=0;i<A.length;++i){
			if(A[i]-min>=K){
				int len = i-minIndex;
				for (; minIndex < i ; minIndex++) {
					if(A[i]-A[minIndex]>=K) len = i-minIndex;
				}
				if(len<minLen || minLen<0){
					minLen = len;
				}
			}
			if(A[i]<min) {
				min = A[i];
				minIndex = i;
			}

		}
		return -1;
	}



	@Test
	public void test() {
		int[] a = {17,85,93,-45,-21};
		int K = 150;
		System.out.println(shortestSubarray(a, K));
	}
}
