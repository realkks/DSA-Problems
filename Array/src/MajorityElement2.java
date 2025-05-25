/*
Leetcode question link : https://leetcode.com/problems/majority-element-ii/
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        List<Integer> ans = majorityElement(nums);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    // Approach: Boyer-Moore Voting Algorithm
    // there can be max 2 elements whose frequency can be more than n/3;
    public static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int curr1 = 0, curr2 = 0, cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if(cnt1==0 && nums[i] != curr2){
                curr1 = nums[i];
                cnt1++;
            }
            else if(cnt2==0 && nums[i] != curr1){
                curr2 = nums[i];
                cnt2++;
            }
            else if(nums[i] == curr1){
                cnt1++;
            }
            else if(nums[i] == curr2){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for (int i : nums) {
            if (i == curr1) {
                cnt1++;
            } else if (i == curr2) {
                cnt2++;
            }
        }
        if (cnt1 > n / 3) {
            ans.add(curr1);
        }
        if (cnt2 > n / 3) {
            ans.add(curr2);
        }
        return ans;
    }

}
