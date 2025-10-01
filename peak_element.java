class Solution {
    public int peakElement(int[] arr) {
        int n = arr.length - 1;
        int start = 0, end = n;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            int curr = arr[mid];
            
            boolean leftOk = (mid == 0) || (curr > arr[mid - 1]);
            boolean rightOk = (mid == n) || (curr > arr[mid + 1]);
            
            if(leftOk && rightOk) {
                return mid;
            } else if(mid < n && arr[mid + 1] > curr) {
                start = mid + 1;
            } else if(mid > 0 && arr[mid - 1] > curr) {
                end = mid - 1;
            }
        }
        
        return -1;
    }
}

// Examples :

// Input: arr = [1, 2, 4, 5, 7, 8, 3]
// Output: 5
// Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].

// Input: arr = [10, 20, 15, 2, 23, 90, 80]
// Output: 1
// Explanation: Element 20 at index 1 is a peak since 10 < 20 > 15. Index 5 (value 90) is also a peak, but returning any one peak index is valid.

