package Recursion;

import java.util.Arrays;

// PascalTriangle
public class Task1_3 {
    public static void printPascalTriangle(int row){
        for (int i = 1; i <= row; i++) {
            for(int j : getPascalTriangle(i)){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static int[] getPascalTriangle(int n){
        if(n == 1){
            return new int[]{1};
        }
        return generatePascalTriangle(getPascalTriangle(n-1));
    }
    public static int[] generatePascalTriangle(int[] prevRow){
        int[] nextRow = new int[prevRow.length + 1];
            int n = nextRow.length;
            nextRow[0] = 1;
            nextRow[n-1] = 1;
           for(int i = 1; i < nextRow.length-1; i++){
               nextRow[i] = prevRow[i-1] + prevRow[i];
           }
        return nextRow;
    }

    static void main() {
        printPascalTriangle(5);
    }
}
