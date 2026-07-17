package Dimensional_Arrays;


import java.util.Arrays;

public class CountNumber_Of_Digits {
    public static int findNumbers(int[] nums){
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            if(countNumber(nums[i])){
                count++;
            }
        }
        return count;
    }

    public static boolean countNumber(int num) {
        String re =  String.valueOf(num);
        char[] arr = re.toCharArray();
        if(arr.length%2 == 0) return true;
        return false;
    }

    static void main() {
        int[] arr = {1234,12,5,124,1326};
        System.out.println(findNumbers(arr));
    }
}

