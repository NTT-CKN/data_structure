package Dimensional_Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyArrays {
    private int[] array;
    public MyArrays(int[] array) {
        this.array = array;
    }
    public int[] mirror(){
        int[] result = new int[this.array.length * 2];
        for (int i = 0; i < this.array.length; i++) {
            result[i] = array[i];
        }
        for (int i = 0; i < this.array.length; i++) {
            result[i + this.array.length] = array[array.length - 1 - i];
        }
        return result;
    }
    public int[] removeDuplicates(){
        int[] result = new int[this.array.length];
        int size = 0;
        boolean flag;
        for (int i = 0; i < this.array.length; i++) {
            flag = false;
            for (int j = 0; j < size - 1; j++) {
                if (array[i]==result[j]) {
                    flag = true;
                }
            }
            if (!flag) {
                result[size++] = array[i];
            }
        }
        return Arrays.copyOf(result, size);
    }
    public boolean isSorted(){
        for (int i = 0; i < this.array.length-1; i++) {
            if (this.array[i] > this.array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public int[] getMissingValues(){
        // tim min cua mang
       // tim max cua mang
        int count = 0;
        for(int i = findMin(); i<=findMax(); i++){
            if(!contains(i)){
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for(int i = findMin(); i<=findMax(); i++){
            if(!contains(i)){
                result[index] =i;
                index++;
            }
        }
    return result;
    }
    public int findMin(){
        int min = array[0];
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }
    public int findMax(){
        int max = array[0];
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public boolean contains(int value){
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
    public int[] fillMissingValues(int k) {
        int[] result = array.clone();
        for (int i = 0; i < this.array.length; i++) {
           boolean MissingValue = false;
           if(array[i] == -1 || (i>0 && array[i] < array[i-1])) MissingValue = true;
           if(MissingValue){
               int sum= 0, count = 0;

               for(int j = Math.max(0, i-k); j<i; j++){
                    if(array[j] != -1){
                        sum += array[j];
                        count++;
                    }
               }
               for(int j = i+1;j<=Math.min(array.length,i+k); j++){
                   if(array[j] != -1){
                       sum += array[j];
                       count++;
                   }
               }
              if(count>0){
                  result[i] = sum/count;
              }
           }
        }
        return result;
    }
    static void main() {
        int[] array = {10, 11, 12, -1 ,14, 10, 17, 19 ,20};
        System.out.println(array.length);
        // mirror
        MyArrays myArrays = new MyArrays(array);
//        System.out.println(Arrays.toString(myArrays.mirror()));
        // removeDuplicate
//        System.out.println(Arrays.toString(myArrays.removeDuplicates()));
        // isSorted
        System.out.println(myArrays.isSorted());

        System.out.println(Arrays.toString(myArrays.getMissingValues()));
        System.out.println(Arrays.toString(myArrays.fillMissingValues(3)));
    }
}
