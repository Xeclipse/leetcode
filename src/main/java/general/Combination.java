package general;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Alex.Z
 * @DATE: 2018/8/1
 * @Description:
 */
public class Combination {
    public static List<List<Integer>> combinationIndex(int n, int x){
        List<List<Integer>> ret = new ArrayList<List<Integer>>(100);
        List<Integer> state = new ArrayList<Integer>(x*2);
        for(int i=0;i<n-x;++i) {
            state.add(i);
            recursiveCombination(n, x, 0, ret, state);
            state.remove(0);
        }
        return ret;
    }


    private static void recursiveCombination(int n, int x, int depth, List<List<Integer>> record, List<Integer> state){
        if(depth==x) {
            record.add(new ArrayList<Integer>(state));
            return;
        }
        int start = state.get(state.size()-1);
        for(int i =start+1; i<n;++i ){
            state.add(i);
            recursiveCombination(n,x,depth+1, record, state);
            state.remove(state.size()-1);
        }
    }


    private int n;
    private int x;
    private int[] now;

    public Combination(int n, int x) {
        this.n = n;
        this.x = x;
        this.now = new int[x];
        for(int i=0;i<x;++i){
            now[i]=i;
        }
        now[x-1]--;

    }

    public int[] next(){
        if(now==null) return now;
        for(int i =x-1;i>=0;--i){
            now[i]+=1;
            if(now[i]>n-x+i){
                now[i]=-1;
                if(i==0) {
                    now=null;
                }
            }
            else{
                for(int j = i+1;j<x;j++){
                    now[j]=now[j-1]+1;
                }
                break;
            }
        }
        return now;
    }

}
