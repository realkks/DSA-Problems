/*
Leetcode link : https://leetcode.com/problems/first-missing-positive/

Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:

Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:

Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
 */

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        int result = firstMissingPositive(nums);
        System.out.println(result); // Output: 2
    }

    // Approach: Using cyclic sort to check the presence of positive integers in the array.

    public static int firstMissingPositive(int[] nums){
        int n=nums.length;
        int i=0;
        while(i<n){
            int correctIdx = nums[i] - 1; // Correct index for the current number
            if(nums[i]>=1 && nums[i]<=n && nums[i]!=nums[correctIdx]){
                // Swap nums[i] with nums[correctIdx] to place it in its correct position
                int temp = nums[i];
                nums[i] = nums[temp-1];
                nums[temp-1] = temp;
            }
            else{
                i++; // Move to the next index if the current number is already in its correct position or out of range
            }
        }

        for(i=0; i<n; i++){
            // Check if the number i is present at index i-1
            if(nums[i] != i+1){
                return i+1; // If not, return the first missing positive integer
            }
        }
        return n + 1; // If all numbers from 1 to n are present, return n+1

    }
}
