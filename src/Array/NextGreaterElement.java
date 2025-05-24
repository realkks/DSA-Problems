package Array;
/*
Problem: Given an array arr[] of integers, the task is to find the Next Greater Element in the right side of each
element of the array.
Input: arr[] = [1, 3, 2, 4]
Output: [3, 4, 4, -1]
Explanation: The next larger element to 1 is 3, 3 is 4, 2 is 4 and for 4, since it doesn't exist, it is -1.
 */

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args){
        int[] arr = {6, 8, 0, 1, 3};
        int[] ans = nextGreaterElement(arr);
        System.out.println(Arrays.toString(ans));
    }
    // Approach : use stack to keep track of next greater elemnt
    public static int[] nextGreaterElement(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<arr[i]){
                stk.pop();
            }
            if(!stk.isEmpty()){
                ans[i]=stk.peek();
            }
            stk.push(arr[i]);
        }
        return ans;
    }
}
