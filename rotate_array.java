// Reversal Algorithm: Reverse first d, reverse rest, then reverse whole array (O(n) time, O(1) space)
class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int n = arr.length - 1;
        int rotations = d % (n + 1);
        
        if(rotations == 0) return;
        
        reverse(arr, 0, rotations - 1);
        reverse(arr, rotations, n);
        reverse(arr, 0, n);
    }
    
    static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            arr[start] = arr[start] + arr[end] - (arr[end] = arr[start]);
            start++;
            end--;
        }
    }
}

// Temporary Array: Store first d elements, shift rest left, copy temp to end (O(n) time, O(d) space)
class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int n = arr.length;
        int rotations = d % n;
        
        if(rotations == 0) return;
        
        int[] temp = new int[rotations];
        
        for(int i = 0; i < rotations; i++) {
            temp[i] = arr[i];
        }
        
        for(int i = rotations; i < n; i++) {
            arr[i - rotations] = arr[i];
        }
        
        for(int i = 0; i < rotations; i++) {
            arr[n - rotations + i] = temp[i];
        }
    }
}

// Naive Shift: Shift array left by 1, d times (O(d*n) time, O(1) space)
class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        if(d == 0) return;
        
        int n = arr.length - 1;
        int rotations = d % (n + 1);
        
        while(rotations > 0) {
            int temp = arr[0];
            
            for(int i = 0; i < n; i++) {
                arr[i] = arr[i + 1];
            }
            
            arr[n] = temp;
            rotations--;
        }
    }
}

// Examples :

// Input: arr[] = [1, 2, 3, 4, 5], d = 2
// Output: [3, 4, 5, 1, 2]
// Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.

// Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
// Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
// Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.

// Input: arr[] = [7, 3, 9, 1], d = 9
// Output: [3, 9, 1, 7]
// Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.

