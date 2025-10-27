// Approach: Dutch National Flag algorithm (one-pass, constant space)
class Solution {
    public void sort012(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;
        
        while(mid <= high) {
            if(arr[mid] == 0) {
                arr[mid] = arr[mid] + arr[low] - (arr[low] = arr[mid]);
                low++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else {
                arr[mid] = arr[mid] + arr[high] - (arr[high] = arr[mid]);
                high--;
            }
        }
    }
}

// Approach: Insertion Sort (two nested loops, O(n²) time complexity)
class Solution {
    public void sort012(int[] arr) {
        if(arr.length == 1) return;
        
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j - 1] > arr[j]) {
                    arr[j] = arr[j] + arr[j - 1] - (arr[j - 1] = arr[j]);
                } else {
                    break;
                }
            }
        }
    }
}

// Examples:

// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]
// Explanation: 0s, 1s and 2s are segregated into ascending order.

// Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
// Explanation: 0s, 1s and 2s are segregated into ascending order.

