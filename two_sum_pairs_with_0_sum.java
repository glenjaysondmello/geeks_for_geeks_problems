// Two-Pointer (Optimized, O(n log n)) (with sorted array)
class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        Arrays.sort(arr);
        
        int n = arr.length - 1;
        int left = 0, right = n;
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        while(left < right) {
            int sum = arr[left] + arr[right];
            
            if(sum == 0) {
                ArrayList<Integer> cur = new ArrayList<>();
                
                cur.add(arr[left]);
                cur.add(arr[right]);
                
                Collections.sort(cur);
                res.add(cur);
                
                int leftVal = arr[left], rightVal = arr[right];
                
                while(left < right && arr[left] == leftVal) left++;
                while(left < right && arr[right] == rightVal) right--;
                
            } else if(sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        
        res.sort(Comparator.comparing(a -> a.get(0)));
        
        return res;
    }
}

// Brute Force (O(n²)) (without sorting the array)
class Solution {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        int n = arr.length - 1;
        int left = 0, right = n;
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        while(left < right) {
            if(arr[left] == -(arr[right])) {
                ArrayList<Integer> cur = new ArrayList<>();
                
                cur.add(arr[left]);
                cur.add(arr[right]);
                
                Collections.sort(cur);
                
                if(!res.contains(cur)) {
                    res.add(cur);
                }
                
                left++;
                right = n;
            } else if(left == right - 1) {
                left++;
                right = n;
            } else {
                right--;
            }
        }
        
        res.sort(Comparator.comparing(a -> a.get(0)));
        
        return res;
    }
}

// Examples:

// Input: arr = [-1, 0, 1, 2, -1, -4]
// Output: [[-1, 1]]
// Explanation: arr[0] + arr[2] = (-1)+ 1 = 0.
// arr[2] + arr[4] = 1 + (-1) = 0.
// The distinct pair are [-1,1].

// Input: arr = [6, 1, 8, 0, 4, -9, -1, -10, -6, -5]
// Output: [[-6, 6],[-1, 1]]
// Explanation: The distinct pairs are [-1, 1] and [-6, 6].


