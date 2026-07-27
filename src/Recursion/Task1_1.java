package Recursion;

public class Task1_1 {
    public static int getSn1(int n){
        if(n==1){
            return 1;
        }
       if(n%2==0){
           return getSn1(n-1) - n;
       }else{
           return getSn1(n-1) + n;
       }
    }
    public static int getSn2(int n){
        if(n==1){
            return 1;
        }
        return  getSn2(n-1) + giaithua(n);
    }
    public  static  int giaithua(int n){
        if(n==1){
            return 1;
        }
        return giaithua(n-1) * n;
    }
    public static int getSn3(int n){
        if(n==0){
            return 1;
        }
        return getSn3(n-1) + n*n;
    }
    public static double getSn4(int n){
        if(n==0){
            return 1;
        }
        return  getSn4(n-1) + 1/subSn4(n);
    }
    public static double subSn4(int n){
        if(n==0){
            return 1;
        }
        return  subSn4(n-1) * (2*n);
    }
    static void main() {
        System.out.print("Sn1: ");
        System.out.println(getSn1(7));
        System.out.println("<==========================>");
        System.out.print("Sn2: ");
        System.out.println(getSn2(5));
        System.out.println("<==========================>");
        System.out.print("Sub Sn3: ");
        System.out.println(giaithua(6));
        System.out.print("Sn3: ");
        System.out.println(getSn3(6));
        System.out.println("<==========================>");
        System.out.print("Sub Sn4: ");
        System.out.println(subSn4(3));
        System.out.print("Sn4: ");
        System.out.println(getSn4(3));
    }
}
