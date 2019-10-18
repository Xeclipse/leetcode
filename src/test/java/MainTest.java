/* Copyright 2016 The TensorFlow Authors. All Rights Reserved.
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================*/



import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

//import com.ximalaya.search.smartSearch.models.neuralNetworkLoaders.SpamNeuralLoader;
import general.Combination;
import general.NumPalindrome;
import general.Point;
import general.Utils;
import leetcode.*;
import org.junit.Test;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class MainTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
//        testAutoLoader();
//        testClassLoader();
//        testCombination();
//        test3Sum();
//        testCreateMaximumNumber();
    }




    public static void test3Sum(){
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret=threeSum.threeSum(nums);
        for (List<Integer> integers : ret) {
            integers.forEach(i->System.out.print(String.valueOf(i)+' '));
            System.out.println();
        }
    }

    @Test
    public void testCombination(){
//        List<List<Integer>> ret = Combination.combinationIndex(5,3);
//        for (List<Integer> integers : ret) {
//            integers.forEach(i->System.out.print(String.valueOf(i)+' '));
//            System.out.println();
//        }
        Combination combination = new Combination(10,4);
        for (int i = 0; i <211; i++) {
            Utils.print1d(combination.next());
        }
    }

//    public void testNeural() throws IOException {
//        SpamNeuralLoader spm = new SpamNeuralLoader();
//        spm.init();
//        FileInputStream inputStream = new FileInputStream("/Users/nali/Eclipse_Workspace/SmartSearch/smartSearch/target/classes/SpamFilterResource/graph.pb");
//        byte[] graphDef = spm.getModelBytes(inputStream);
//        spm.getGraph().importGraphDef(graphDef);
//        inputStream.close();
//        System.out.println(spm.predict("小姐姐你好啊" )[0]);
//    }

    public static void testAutoLoader(){
        JavaCompiler javac;
        javac = ToolProvider.getSystemJavaCompiler();
        int compilationResult = javac.run(null,null,null, "-g","-verbose","/Users/nali/Eclipse_Workspace/alexTest/src/main/java/Test.java");
    }

    public  static void testClassLoader() throws NoSuchMethodException, MalformedURLException, InvocationTargetException, IllegalAccessException, ClassNotFoundException, InstantiationException {
        File file = new File("/Users/nali/Eclipse_Workspace/alexTest/src/main/java/Test.class"); URLClassLoader classloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        Method add = URLClassLoader.class.getDeclaredMethod("addURL", new Class[]{URL.class});
        add.setAccessible(true);
        add.invoke(classloader, new Object[]{file.toURI().toURL()});
        Class c = classloader.loadClass("Test");
        Object o = c.newInstance();
        Method m = c.getDeclaredMethod("helloWorld");
        m.invoke(o, null);
    }

    public static void testCreateMaximumNumber(){
        CreateMaximumNumber cmn = new CreateMaximumNumber();
        int[] nums1 = {1,2,3,4,5,6};
        cmn.maxNumber(nums1,10);
    }


    @Test
    public void testLRU(){
        LRUCache lruCache= new LRUCache(2);
        lruCache.put(2,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
    }


    @Test
    public void testMaxPoints(){
        MaxPoints maxPoints = new MaxPoints();
//        [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
        Point[] points = new Point[4];
        points[0] = new Point(3,1);
        points[1] = new Point(3,1);
        points[2] = new Point(12,3);
        points[3] = new Point(-6,-1);
        System.out.println(maxPoints.maxPoints(points));
    }

    @Test
    public void testLongest(){
        LongestConsecutiveSequence longest= new LongestConsecutiveSequence();
        int[] test = {100,4,200,1,3,2};
        System.out.println(longest.longestConsecutive(test));
    }

    @Test
    public void testSumPath(){
    }


    @Test
    public void testEditDistance(){
        EditDistance ed = new EditDistance();
        System.out.println(ed.minDistance("intention","execution"));
    }

    @Test
    public void testMinCut(){
        PalindromePartitioning ts = new PalindromePartitioning();

        System.out.println(ts.minCut("abcdd"));
    }

    @Test
    public void testSoduku(){
        char[][] board=new char[9][9];
        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = '.';
            }
        }

        board[0][0]='5';
        board[0][1]='3';
        board[0][4]='7';
        board[1][0]='6';
        board[1][3]='1';
        board[1][4]='9';
        board[1][5]='5';
        board[2][1]='9';
        board[2][2]='8';
        board[2][7]='6';
        board[3][0]='8';
        board[3][4]='6';
        board[3][8]='3';
        board[4][0]='4';
        board[4][3]='8';
        board[4][5]='3';
        board[4][8]='1';
        board[5][0]='7';
        board[5][4]='2';
        board[5][8]='6';
        board[6][1]='6';
        board[6][6]='2';
        board[6][7]='8';
        board[7][3]='4';
        board[7][4]='1';
        board[7][5]='9';
        board[7][8]='5';
        board[8][4]='8';
        board[8][7]='7';
        board[8][8]='9';

        SolveSudoku solveSudoku = new SolveSudoku();
        solveSudoku.solveSudoku(board);
        for (int i = 0; i <9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    @Test
    public void testClosestPalindrome(){
        ClosestPalindrome cp = new ClosestPalindrome();
        System.out.println(cp.nearestPalindromic("10"));
    }

    @Test
    public void testGenPalindrome(){
        NumPalindrome cp = new NumPalindrome();
//        System.out.println(cp.nearestPalindromic("101"));
        String next = "0";
        for(int i =0;i<500;++i){
            System.out.println(next);
            next = cp.next(next);
        }
    }

    @Test
    public void testKthSmallestPrimeFraction(){
        KSmallestPrimeFraction kpf = new KSmallestPrimeFraction();
        int[] A = {1,7,23,29,47};
        int[] ret= kpf.kthSmallestPrimeFraction(A,8);
        System.out.println(ret[0]);
        System.out.println(ret[1]);

    }

    @Test
    public void testRouteBus(){
        BusRoutes busRoutes= new BusRoutes();
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int S = 1;
        int T = 6;
        System.out.println(busRoutes.numBusesToDestination(routes, S, T));
    }

    @Test
    public void testSuperEggDrop(){
        SuperEggDrop sed = new SuperEggDrop();
        System.out.println(sed.superEggDrop(2,2));
    }

}