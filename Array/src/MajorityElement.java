/*
Leetcode question link : https://leetcode.com/problems/majority-element/

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
public class MajorityElement {
    public static void main(String[] args){
        int[] nums = {2,2,1,1,1,2,2};
        int ans = majorityElement(nums);
        System.out.println(ans);
    }
    // Approach: Boyer-Moore Voting Algorithm
    // intially we will take first element as current and count as 1 and then check if same element the cnt++ else cnt--
    public static int majorityElement(int [] nums){
        int n = nums.length;
        int curr = nums[0];
        int cnt=1;
        for(int i=1;i<n;i++){
            if(cnt==0){
                curr = nums[i];
            }
            if(nums[i]==curr){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        return curr;
    }
}
