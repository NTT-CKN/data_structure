package Algorithms;

public class MyArrays {
    private int[] array;
    public MyArrays(int[] array) {
        this.array = array;
    }
    public int interativeLinerSearch(int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public int recursiveLinearSearch(int target){
        return subRecursiveLinearSearch(target, 0);
    }
    private  int subRecursiveLinearSearch(int target, int n){
        if(n == array.length){
            return -1;
        }
        if(array[n] == target){
            return n;
        }
        return subRecursiveLinearSearch(target, n +  1);
    }

    public int iterativeBinarySearch(int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            }else if (array[mid] < target) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }
    public int recursiveBinarySearch(int target) {
        return subResursiveBinarySearch(target, 0, array.length - 1);
    }
    private int subResursiveBinarySearch(int target, int left, int right){
        if(left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == target) {
            return mid;
        }else if (array[mid] < target) {
            return subResursiveBinarySearch(target, mid+1, right);
        }else{
            return subResursiveBinarySearch(target, left, mid-1);
        }
    }
    static void main() {
        int[] array = {9,10,14,16,29,46,75,92};
        MyArrays myArrays = new MyArrays(array);
        System.out.print("Iterative Linear Search: ");
        System.out.println(myArrays.interativeLinerSearch(7));
        System.out.print("Recursive Linear Search: ");
        System.out.println(myArrays.recursiveLinearSearch(14));
        System.out.print("Iterative Binary Search: ");
        System.out.println(myArrays.iterativeBinarySearch(14));
        System.out.print("Recursive Binary Search: ");
        System.out.println(myArrays.recursiveBinarySearch(14));
    }

}
