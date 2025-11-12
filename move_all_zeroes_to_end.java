// Approach: Two-pointer method with in-place arithmetic swapping to shift non-zero elements forward and push all zeroes to the end in O(n) time, O(1) space.
class Solution {
    void pushZerosToEnd(int[] arr) {
        int j = 0;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0) {
                arr[i] = arr[i] + arr[j] - (arr[j] = arr[i]);
                j++;
            }
        }
    }
}

// Examples:

// Input: arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
// Output: [1, 2, 4, 3, 5, 0, 0, 0]
// Explanation: There are three 0s that are moved to the end.

// Input: arr[] = [10, 20, 30]
// Output: [10, 20, 30]
// Explanation: No change in array as there are no 0s.

// Input: arr[] = [0, 0]
// Output: [0, 0]
// Explanation: No change in array as there are all 0s.

