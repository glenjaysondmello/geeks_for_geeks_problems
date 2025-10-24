// Efficient O(n) approach — traverse from right to left, track the maximum element (maxRight), and collect leaders.
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();   
        int n = arr.length;
        
        int maxRight = arr[n - 1];
        list.add(maxRight);
        
        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] >= maxRight) {
                list.add(arr[i]);
                maxRight = arr[i];
            }
        }
        
        Collections.reverse(list);
        
        return list;
    }
}

// Brute-force O(n²) approach — for each element, check all elements to its right to determine if it’s a leader.
class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        
        if(arr.length == 1) {
            list.add(arr[0]);
            return list;
        }
        
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] < arr[j]) break;
                
                if(arr[i] >= arr[j]) {
                    if(j != arr.length - 1) {
                        list.add(arr[i]);
                    } else {
                        continue;
                    }
                }
            }
        }
        
        list.add(arr[arr.length - 1]);
        
        return list;
    }
}

// Examples:

// Input: arr = [16, 17, 4, 3, 5, 2]
// Output: [17, 5, 2]
// Explanation: Note that there is nothing greater on the right side of 17, 5 and, 2.

// Input: arr = [10, 4, 2, 4, 1]
// Output: [10, 4, 4, 1]
// Explanation: Note that both of the 4s are in output, as to be a leader an equal element is also allowed on the right. side

// Input: arr = [5, 10, 20, 40]
// Output: [40]
// Explanation: When an array is sorted in increasing order, only the rightmost element is leader.

// Input: arr = [30, 10, 10, 5]
// Output: [30, 10, 10, 5]
// Explanation: When an array is sorted in non-increasing order, all elements are leaders.


