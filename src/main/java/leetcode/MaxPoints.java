package leetcode;

import general.Point;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Alex.Z
 * @DATE: 2018/9/20
 * @Description: Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * Example 2:
 * <p>
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 */


public class MaxPoints {

    class Line {
        long a;
        long b;
        long c;

        public Line(Point x, Point y) {
            b = y.x - x.x;
            a = x.y - y.y;
            if (b != 0) {
                long gcd = this.gcd(a,b);
                a = a/gcd;
                b = b/gcd;
            } else if (a != 0) {
                a = 1;
            }
            c = -1 * (a * x.x + b * x.y);
        }

        public boolean match(Point x) {
            if (Double.compare(a * x.x + b * x.y + c, 0) == 0) return true;
            return false;
        }

        private long gcd(long a, long b) {
            long mod = a % b;
            if (mod == 0) {
                return b;
            } else {
                return gcd(b, mod);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Line)) return false;

            Line line = (Line) o;

            if (a != line.a) return false;
            if (b != line.b) return false;
            return c == line.c;
        }

        @Override
        public int hashCode() {
            int result = (int) (a ^ (a >>> 32));
            result = 31 * result + (int) (b ^ (b >>> 32));
            result = 31 * result + (int) (c ^ (c >>> 32));
            return result;
        }
    }


    private class PointComparator implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            if (o1.x > o2.x) return 1;
            else if (o1.x < o2.x) return -1;
            else {
                return Integer.compare(o1.y, o2.y);
            }
        }
    }

    public int maxPoints(Point[] points) {
        TreeMap<Point, Integer> pointsMap = new TreeMap<>(new PointComparator());
        for (Point point : points) {
            pointsMap.merge(point, 1, (a, b) -> a + b);
        }
        if(pointsMap.size() ==0 || pointsMap.size() ==1)
            return points.length;

        Point[] singlePoints = new Point[pointsMap.size()];
        pointsMap.keySet().toArray(singlePoints);

        Map<Line, Integer> lps = linePoints(singlePoints);
        int max = 0;
        for(Map.Entry<Line, Integer> entry : lps.entrySet()){
            int value = entry.getValue();
            Line line = entry.getKey();
            for(Map.Entry<Point, Integer> pnum: pointsMap.entrySet()){
                if(pnum.getValue()>1 && line.match(pnum.getKey())){
                    value+=pnum.getValue()-1;
                }
            }
            if(value>max) max = value;
        }
        return max;
    }

    private Map<Line, Integer> linePoints(Point[] points) {
        if (points == null) return null;
        Map<Line, Integer> lines = new HashMap();
        for (int i = 0; i < points.length; ++i) {
            for (int j = i + 1; j < points.length; ++j) {
                Line tmp = new Line(points[i], points[j]);
                lines.merge(tmp, 1, (a, b) -> a + b);
            }
        }
        return lines.entrySet().stream().map(e -> {
            e.setValue((int) ((Math.sqrt(e.getValue() * 8 + 1) + 1) / 2));
            return e;
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

}
