import java.util.HashSet;

/*
Problem lin: https://www.geeksforgeeks.org/check-if-pair-with-given-sum-exists-in-array/

Given an array arr[] of n integers and a target value, the task is to find whether
there is a pair of elements in the array whose sum is equal to target. This problem is a variation of 2Sum problem.

Examples:
Input: arr[] = [0, -1, 2, -3, 1], target = -2
Output: true
Explanation: There is a pair (1, -3) with the sum equal to given target, 1 + (-3) = -2.

 */
public class TwoSum {
    public static void main(String[] args){
        int[] arr = {0, -1, 2, -3, 1};
        int target = -2;
        boolean result = hasPairWithSum(arr, target);
        System.out.println(result);
    }
    public static boolean hasPairWithSum(int[] arr, int target){
        // Approach: Use a HashSet to store the elements we have seen so far.
        // For each element, check if the complement (target - current element) exists in the set.
        int n = arr.length;
        HashSet<Integer> hs = new HashSet<>();

        for(int num : arr){
            int required = target - num;
            if(hs.contains(required)){
                return true; // Pair found
            }
            hs.add(num); // Add current number to the set
        }
        return false; // No pair found
    }

}
