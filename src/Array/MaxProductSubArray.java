package Array;

/*
Leetcode question link : https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

 */
public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,0,-1};
        int ans = maxProduct(nums);
        System.out.println(ans);
    }
    public static int maxProduct(int[] nums){
        int n = nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        //Approach: if 0 is vailable in the given array then either left of 0 will be max or right of 0 will be max
        // We are using two pointers, one from left and one from right
        for(int i=0;i<n;i++){
            leftProduct = nums[i]*leftProduct;
            rightProduct = nums[n-i-1]*rightProduct;
            maxProduct = Math.max(maxProduct,Math.max(leftProduct,rightProduct));
            if(leftProduct == 0){
                leftProduct = 1;
            }
            if (rightProduct == 0){
                rightProduct = 1;
            }
        }
        return maxProduct;
    }

}
