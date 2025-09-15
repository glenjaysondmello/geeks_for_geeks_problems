class Solution {
    int majorityElement(int arr[]) {
        // code here
        int times = (int) arr.length / 2;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() > times) {
                return entry.getKey();
            }
        }
        
        return -1;
    }
}

// Examples:

// Input: arr[] = [1, 1, 2, 1, 3, 5, 1]
// Output: 1
// Explanation: Since, 1 is present more than 7/2 times, so it is the majority element.
  
// Input: arr[] = [7]
// Output: 7
// Explanation: Since, 7 is single element and present more than 1/2 times, so it is the majority element.
  
// Input: arr[] = [2, 13]
// Output: -1
// Explanation: Since, no element is present more than 2/2 times, so there is no majority element.


  
