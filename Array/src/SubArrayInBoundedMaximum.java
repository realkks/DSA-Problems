/*
LeetCode link: https://leetcode.com/problems/subarray-with-bounded-maximum

Given an integer array nums and two integers left and right, return the number of contiguous non-empty
subarrays such that the value of the maximum array element in that subarray is in the range [left, right].
The test cases are generated so that the answer will fit in a 32-bit integer.

Example 1:

Input: nums = [2,1,4,3], left = 2, right = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].

 */
public class SubArrayInBoundedMaximum {
    public static void main(String[] args) {
        int[] nums = {16,69,88,85,79,87,37,33,39,34};
        int left = 55;
        int right = 57;
        int result = numSubarrayBoundedMax(nums, left, right);
        System.out.println(result);
    }
    public static int numSubarrayBoundedMax(int[] nums,int left,int right){
        int n = nums.length;
        long count = 0,ans=0;
        int max=Integer.MIN_VALUE;
        //First loop is to find nos. of subarrays in which maximum is less than or equal to right
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
            if(max<=right) {
                count++;
            }
            else{
                ans += (count*(count+1))/2; // Add the count of valid subarrays found so far
                count=0;
                max = Integer.MIN_VALUE; // Reset max for the next segment
            }
        }
        ans += (count*(count+1))/2; // Add the count of valid subarrays found in the last iteration
        max = Integer.MIN_VALUE; // Reset max for the second loop
        count = 0;
        //Second loop is to find nos. of subarrays in which maximum is less than left
        for(int i=0;i<n;i++){
            max = Math.max(max, nums[i]);
            if(max< left) {
                count++;
            }
            else{
                ans -= (count*(count+1))/2; // Add the count of valid subarrays found so far
                count=0;
                max = Integer.MIN_VALUE; // Reset max for the next segment
            }
        }
        ans -= (count*(count+1))/2; // Add the count of valid subarrays found in the last iteration
        return (int)ans;
    }
}
