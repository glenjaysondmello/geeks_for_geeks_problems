class Solution {
    public static int kthSmallest(int[] arr, int k) {
        int[] sortedArr = insertionSort(arr);
        
        return sortedArr[k - 1];
    } 
    
    static int[] insertionSort(int[] arr) {
        if(arr.length == 1) return arr;
        
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j - 1]) {
                    arr[j] = arr[j] + arr[j - 1] - (arr[j - 1] = arr[j]);
                } else {
                    break;
                }
            }
        }
        
        return arr;
    }
}

// Examples :

// Input: arr[] = [7, 10, 4, 3, 20, 15], k = 3
// Output: 7
// Explanation: 3rd smallest element in the given array is 7.

// Input: arr[] = [2, 3, 1, 20, 15], k = 4 
// Output: 15
// Explanation: 4th smallest element in the given array is 15.

  
