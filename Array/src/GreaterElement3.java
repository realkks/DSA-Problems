/*
LeetCode Problem: https://leetcode.com/problems/next-greater-element-iii
Given a positive integer n, find the smallest integer which has exactly the same digits
existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer
but it does not fit in 32-bit integer, return -1.

Example 1:

Input: n = 12443322
Output: 13222344
 */

/*
Approach:  (1) Find the digit that is not following the increasing order pattern starting from the end.
            (2) Replace that digit with the just next greater digit from the number.
            (3) The left side number from that digit will be fixed and Sort the right side of that digit to get next greater number
            than the given input
 */

public class GreaterElement3 {
    public static void main(String[] args) {
        int n = 12443322;
        int ans= nextGreaterElement(n);
        System.out.println(ans);
    }
    public static int nextGreaterElement(int n){
        int[] count = new int[10];   // To track count of digit in the given number
        long temp = n;
        int prevRem = -1;
        int currRem = -1;
        while (temp>0){
            currRem = (int)(temp%10);;
            temp = temp/10;
            count[currRem]++;
            if(currRem<prevRem){   //step 1: found the digit that is not following the increasing order pattern
                int num = currRem+1;
                while(count[num]==0){ // Step 2: Finding the next greater digit
                    num++;
                }
                temp = temp*10+num; // Step:3 Add the next greater digit to the left side of num (it will become the fixed num part)
                count[num]--;
                for(int i=0;i<10;i++){
                    while(count[i]>0){
                        temp = temp*10+i; // Add the remaining digits in sorted order
                        count[i]--;
                    }
                }
                return (temp>Integer.MAX_VALUE) ? -1 : (int)temp; // Check if the result fits in 32-bit integer and return
            }
            prevRem = currRem; // Update the previous remainder for next iteration
        }
        return -1; // If no such digit found, return -1
    }
}
