package Recursion;

import java.util.Arrays;

public class Task2_2 {
    public static void drawPyramid(int n) {
        for (int i = 1; i <= n; i++) {
            int[] re = getSubPyramid(i);
            for(int j : re) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static int[] getSubPyramid(int n) {
        if (n == 1) {
            return new int[]{1};
        }
        return subPyramid(getSubPyramid(n - 1));
    }
    public static int[] subPyramid(int[] pre) {
        int[] next = new int[pre.length+1];
       for(int i = 0; i < next.length; i++) {
           next[i] = pre[0] + 1;
       }
        return next;
    }

    static void main() {
        drawPyramid(8);
    }
}
