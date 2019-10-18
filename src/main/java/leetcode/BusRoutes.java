package leetcode;

import java.util.*;

/**
 * @Author: Alex.Z
 * @DATE: 2019/4/25
 * @Description:
 *
 * We have a list of bus routes. Each routes[i] is a bus route that the i-th bus repeats forever. For example if routes[0] = [1, 5, 7], this means that the first bus (0-th indexed) travels in the sequence 1->5->7->1->5->7->1->... forever.
 *
 * We start at bus stop S (initially not on a bus), and we want to go to bus stop T. Travelling by buses only, what is the least number of buses we must take to reach our destination? Return -1 if it is not possible.
 *
 * Example:
 * Input:
 * routes = [[1, 2, 7], [3, 6, 7]]
 * S = 1
 * T = 6
 * Output: 2
 * Explanation:
 * The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
 */
public class BusRoutes {

    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer,List<Integer>> location2bus = buildLocation2Bus(routes);
        Set<Integer> chekedPoints = new HashSet<>(2500);
        Set<Integer> checkedBuses = new HashSet<>(500);
        Stack<Integer> potentialPoints= new Stack<>();
        potentialPoints.add(S);
        int cnt = 0;
        while(!chekedPoints.contains(T) && potentialPoints.size()>0){
            Stack<Integer> nextPoints=new Stack<>();
            cnt+=1;
            while(potentialPoints.size()>0){
                Integer i  = potentialPoints.pop();
                if(!chekedPoints.contains(i)) {
                    List<Integer> buses = location2bus.get(i);
                    for(Integer bus:buses){
                        if(!checkedBuses.contains(bus)) {
                            checkedBuses.add(bus);
                            for (Integer point : routes[bus]) {
                                if (!chekedPoints.contains(point)) {
                                    if(point == T){
                                        return cnt;
                                    }
                                    nextPoints.add(point);
                                }
                            }
                        }
                    }
                }
                chekedPoints.add(i);
            }
            potentialPoints = nextPoints;
        }
        return -1;
    }

    private Map<Integer, List<Integer>> buildLocation2Bus(int[][] routes) {
        Map<Integer, List<Integer>> ret = new HashMap<>(500);
        for(int i = 0;i<routes.length;++i){
            for(int j = 0;j<routes[i].length;++j){
                List<Integer> buses = ret.computeIfAbsent(routes[i][j], k -> new LinkedList<>());
                buses.add(i);
            }
        }
        return ret;
    }
}
