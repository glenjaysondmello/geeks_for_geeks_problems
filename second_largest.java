// One pass
class Solution {
    public int getSecondLargest(int[] arr) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for(int n : arr) {
            if(n > first) {
                second = first;
                first = n;
            } else if (n != first && n > second) {
                second = n;
            }
        }
        
        if(second == Integer.MIN_VALUE) return -1;
        
        return second;
    }
}

// Two pass
class Solution {
    public int getSecondLargest(int[] arr) {
        int maxEle = getMax(arr);
        
        int sLargest = -1;
        
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != maxEle && arr[i] > sLargest) sLargest = arr[i];
        }
        
        return sLargest;
    }
    
    static int getMax(int[] arr) {
        int max = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
        }
        
        return max;
    }
}


// Examples:

// Input: arr[] = [12, 35, 1, 10, 34, 1]
// Output: 34
// Explanation: The largest element of the array is 35 and the second largest element is 34.

// Input: arr[] = [10, 5, 10]
// Output: 5
// Explanation: The largest element of the array is 10 and the second largest element is 5.

// Input: arr[] = [10, 10, 10]
// Output: -1
// Explanation: The largest element of the array is 10 and the second largest element does not exist.

