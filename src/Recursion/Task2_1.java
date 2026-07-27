package Recursion;

import java.util.Arrays;

public class Task2_1 {
    public static void drawPyramid(int n) {
      if(n==0){
          return;
      }
      drawPyramid(n-1);
      subPyramid(2*n-1);
      System.out.println();
    }
    public static void subPyramid(int n) {
        if(n==0){
           return;
        }
       System.out.print("X");
        subPyramid(n-1);
    }
     static void main(String[] args) {
        drawPyramid(4);
    }
}
