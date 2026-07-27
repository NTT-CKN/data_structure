package Recursion;

import java.util.Arrays;

// Fibonacci
public class Task1_2 {
    public static int getFibonacci(int n) {
        if(n == 1){
            return 0;
        }else if(n == 2){
            return 1;
        }
        return getFibonacci(n-1) + getFibonacci(n-2);
    }
    public static void printFibonacci(int n){
        int[] result = new int[n];
        result[0] = 0;
        result[1] = 1;
        for (int i = 2; i < n; i++) {
            result[i] = result[i-1] + result[i-2];
        }
        System.out.println(Arrays.toString(result));
    }

    static void main() {
        System.out.print("Get Fibonacci at n: ");
        System.out.println(getFibonacci(7));
        System.out.print("Print Fibonacci by n: ");
        printFibonacci(10);
    }
}
