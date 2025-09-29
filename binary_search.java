// For duplicates, finding smallest index by storing found index to result then searching by end = mid - 1
class Solution {
    public int binarysearch(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        int result = -1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(arr[mid] < k) {
                start = mid + 1;
            } else if(arr[mid] > k) {
                end = mid - 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }
        
        return result;
    }
}

// For duplicates, finding smallest index by iterating to previous element if its equal to target element
class Solution {
    public int binarysearch(int[] arr, int k) {
        int start = 0, end = arr.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(arr[mid] < k) {
                start = mid + 1;
            } else if(arr[mid] > k) {
                end = mid - 1;
            } else {
                if(mid != 0 && arr[mid - 1] == k) {
                    while(mid > 0 && arr[mid - 1] == k) {
                        mid = mid - 1;
                    }
                } else {
                    return mid;
                }
                
                return mid;
            }
        }
        
        return -1;
    }
}

// Examples:

// Input: arr[] = [1, 2, 3, 4, 5], k = 4
// Output: 3
// Explanation: 4 appears at index 3.
  
// Input: arr[] = [11, 22, 33, 44, 55], k = 445
// Output: -1
// Explanation: 445 is not present.
  
// Input: arr[] = [1, 1, 1, 1, 2], k = 1
// Output: 0
// Explanation: 1 appears at index 0.

