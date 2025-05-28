/*
Leetcode link: https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

You are given an integer array arr.
We split arr into some number of chunks (i.e., partitions), and individually sort each chunk.
After concatenating them, the result should equal the sorted array.Return the largest number of chunks we can make to sort the array.

Example 1:
Input: arr = [2,1,3,4,4]
Output: 4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
 */

public class MaxChunks2 {
    public static void main(String[] args) {
        int[] arr = {2,1,3,4,4,4,3};
        int result = maxChunksToSorted(arr);
        System.out.println(result);
    }
    //Approach: the approach will be same as MaxChunk problem only difference is that we will compare max with rightMin[i]+1
    // find max element and compare it to rightMin[i]+1, if less than or equal, it means we can make a chunk.


    public static int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunks = 0;
        int max = Integer.MIN_VALUE;
        int[] rightMin = new int[n+1];
        rightMin[n] = Integer.MAX_VALUE; // Initialize the last element to max value for comparison

        for(int i=n-1;i>=0;i--){       // Created rightMin array
            rightMin[i]=Math.min(rightMin[i+1],arr[i]);
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            if (max <=rightMin[i+1]) {
                chunks++;
            }
        }
        return chunks;
    }
}
