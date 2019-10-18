package leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

/**
 * @Author: Alex.Z
 * @DATE: 2019/4/24
 * @Description:
 *
 * A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.
 *
 * What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.
 *
 * Examples:
 * Input: A = [1, 2, 3, 5], K = 3
 * Output: [2, 5]
 * Explanation:
 * The fractions to be considered in sorted order are:
 * 1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
 * The third fraction is 2/5.
 *
 * Input: A = [1, 7], K = 1
 * Output: [1, 7]
 * Note:
 *
 * A will have length between 2 and 2000.
 * Each A[i] will be between 1 and 30000.
 * K will be between 1 and A.length * (A.length - 1) / 2.
 *
 *
 */
public class KSmallestPrimeFraction {


    public class Fraction implements Comparable {
        int p;
        int q;
        int i;
        int j;

        public Fraction(int p, int q, int i, int j) {
            this.p = p;
            this.q = q;
            this.i = i;
            this.j = j;
        }

        public Fraction() {
        }

        @Override
        public int compareTo(Object o) {
            Fraction t = (Fraction) o;
            return p * t.q - q * t.p;
        }
    }
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<Fraction> queue = new PriorityQueue<>(A.length);
        int[] jmax = new int[A.length];
        int[] imin = new int[A.length];
        for(int i=0;i<A.length;++i){
            jmax[i]=A.length-2;
            imin[i]=0;
        }
        queue.add(new Fraction(A[0],A[A.length-1],iproj(A.length-1),jproj(0)));
        for(int cnt = 1;cnt<K;cnt++){
            Fraction frac = queue.poll();
            imin[frac.i]++;
            jmax[frac.j]--;
            int newI = frac.i-1;
            int newJ = frac.j+1;
            if(newJ<=frac.i && jmax[newJ]==frac.i){
                queue.add(new Fraction(A[rJproj(newJ)],A[rIproj(frac.i)],frac.i,newJ));
            }
            if(frac.j<=newI && imin[newI]==frac.j){
                queue.add(new Fraction(A[rJproj(frac.j)],A[rIproj(newI)],newI,frac.j));
            }
        }
        Fraction frac = queue.poll();

        int[] ret=new int[2];
        ret[0]=frac.p;
        ret[1]=frac.q;
        return ret;
    }

    private void removeNode(int i, int j, int[] imin, int[] jmax) {
    }


    private int rIproj(int i) {
        return i+1;
    }

    private int rJproj(int j) {
        return j;
    }

    private int jproj(int i) {
        return i;
    }

    private int iproj(int i) {
        return i-1;
    }
}
