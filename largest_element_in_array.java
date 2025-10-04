class Solution {
    public static int largest(int[] arr) {
        int max = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        
        return max;
    }
}

// Examples:

// Input: arr[] = [1, 8, 7, 56, 90]
// Output: 90
// Explanation: The largest element of the given array is 90.
  
// Input: arr[] = [5, 5, 5, 5]
// Output: 5
// Explanation: The largest element of the given array is 5.

// Input: arr[] = [10]
// Output: 10
// Explanation: There is only one element which is the largest.

