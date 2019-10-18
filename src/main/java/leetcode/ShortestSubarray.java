package leetcode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

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


/**
 * 通过求和得到求和数列
 * 以i开头最小的j
 * 以j结尾最大的i
 *
* */

public class ShortestSubarray {


	private  class ValueIndexPair{
		public ValueIndexPair(int val, int index) {
			this.val = val;
			this.index = index;
		}

		int val;
		int index;
	}

	public int shortestSubarray(int[] A, int K) {
		for (int i = 1; i < A.length; ++i) {
			A[i] = A[i] + A[i - 1];
		}
		int minlen = -1;
		PriorityQueue<ValueIndexPair> heap = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
		heap.add(new ValueIndexPair(0,-1));
		for(int i = 0;i<A.length;++i) {
			ValueIndexPair top = heap.peek();
			while(A[i]-top.val>=K){
				if(i-top.index<minlen || minlen<0) minlen = i-top.index;
				heap.poll();
				if(heap.size()>0)
					top=heap.peek();
				else break;
			}
			heap.add(new ValueIndexPair(A[i],i));
		}
		return minlen;
	}

	@Test
	public void test() {
		int[] a = {84,-37,32,40,95};
		int K = 167;
		System.out.println(shortestSubarray(a, K));
	}
}
