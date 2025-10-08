class Solution {
    public int findFloor(int[] arr, int x) {
        if(x < arr[0]) return -1;
        
        int len =  arr.length - 1;
        int start = 0, end = len;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(arr[mid] == x) {
                if(mid < len && arr[mid + 1] == arr[mid]) {
                    start = mid + 1;
                    continue;
                } else {
                    return mid;
                }
            }
            
            if(arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return end;
    }
}

// Examples:

// Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 5
// Output: 1
// Explanation: Largest number less than or equal to 5 is 2, whose index is 1.

// Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 11
// Output: 4
// Explanation: Largest Number less than or equal to 11 is 10, whose indices are 3 and 4. The index of last occurrence is 4.

// Input: arr[] = [1, 2, 8, 10, 10, 12, 19], x = 0
// Output: -1
// Explanation: No element less than or equal to 0 is found. So, output is -1.


