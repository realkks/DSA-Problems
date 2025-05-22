package Array;
/*
Leetcode question link : https://leetcode.com/problems/maximum-subarray/ (it is also called Kadens algorithm)

Given an integer array nums, find the subarray with the largest sum, and return its sum.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

 */

// Note:  using brute force, just find sum of each subarray and if greater than max, update max.
public class Maximum_SubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int ans = maxSubArray(nums);
        System.out.println(ans);
    }

    // Function to find the maximum subarray sum using Kadane's algorithm
    public static int maxSubArray(int[] nums) {
        int n= nums.length;
        int ans = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum = currentSum+nums[i];
            ans = Math.max(ans, currentSum);
            if(currentSum < 0) {
                currentSum = 0; // Reset current sum if it becomes negative
            }
        }
        return ans;
    }
}
