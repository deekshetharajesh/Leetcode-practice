import java.util.*;
class GfG {
   	static boolean isSubsetSumRec(int[] arr, int n, int sum) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (arr[n - 1] > sum) {
            return isSubsetSumRec(arr, n - 1, sum);
        }
        return isSubsetSumRec(arr, n - 1, sum) || 
               isSubsetSumRec(arr, n - 1, sum - arr[n - 1]);
    }
    static boolean isSubsetSum(int[] arr, int sum) {
        return isSubsetSumRec(arr, arr.length, sum);
    }
    public static void main(String[] args) {      
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        if (isSubsetSum(arr, sum)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
