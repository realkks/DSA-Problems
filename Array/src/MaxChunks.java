/*
Leetcode link: https://leetcode.com/problems/max-chunks-to-make-sorted/

You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them,
the result should equal the sorted array.
Return the largest number of chunks we can make to sort the array.

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.

Constraints:

n == arr.length
1 <= n <= 10
0 <= arr[i] < n
All the elements of arr are unique.
 */
public class MaxChunks {
    public static void main(String[] args) {
        int[] arr = {1,0,2,3,4};
        int result = maxChunksToSorted(arr);
        System.out.println(result); // Output: 1
    }
    //Approach: find max element and compare it to index+1, if less than or equal, it means we can make a chunk
    public static int maxChunksToSorted(int[] arr){
        int n = arr.length;
        int chunks=0;
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,arr[i]);
            if(max<i+1){
                chunks++;
            }
        }
        return chunks;
    }
}
