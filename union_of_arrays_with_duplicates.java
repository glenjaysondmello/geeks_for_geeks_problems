// Approach 1: Uses sorting and two-pointer technique to efficiently merge arrays while skipping duplicates — optimized and maintains sorted order.
class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> arr = new ArrayList<>();
        int left = 0, right = 0;
        int nA = a.length, nB = b.length;
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        while(left < nA && right < nB) {
            while(left < nA - 1 && a[left] == a[left + 1]) left++;
            while(right < nB - 1 && b[right] == b[right + 1]) right++;
            
            if(a[left] < b[right]) {
                arr.add(a[left++]);
            } else if(a[left] > b[right]) {
                arr.add(b[right++]);
            } else {
                arr.add(a[left++]);
                right++;
            }
        }
        
        while(left < nA) {
            while(left < nA - 1 && a[left] == a[left + 1]) left++;
            
            arr.add(a[left++]);
        }
        
        while(right < nB) {
            while(right < nB - 1 && b[right] == b[right + 1]) right++;
            
            arr.add(b[right++]);
        }
        
        return arr;
    }
}

// Approach 2: Uses linear traversal with duplicate checks using arr.contains() — simpler but less efficient (O(n²)) due to repeated containment checks.
class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        ArrayList<Integer> arr = new ArrayList<>();
        int left = 0, right = 0;
        int nA = a.length, nB = b.length;
        
        while(left < nA && right < nB) {
            while(left < nA - 1 && a[left] == a[left + 1]) left++;
            while(right < nB - 1 && b[right] == b[right + 1]) right++;
            
            if(!arr.contains(a[left])) arr.add(a[left]);
            if(!arr.contains(b[right])) arr.add(b[right]);
            
            left++;
            right++;
        }
        
        while(left < nA) {
            while(left < nA - 1 && a[left] == a[left + 1]) left++;
            
            if(!arr.contains(a[left])) arr.add(a[left]);
            
            left++;
        }
        
        while(right < nB) {
            while(right < nB - 1 && b[right] == b[right + 1]) right++;
            
            if(!arr.contains(b[right])) arr.add(b[right]);
            
            right++;
        }
        
        return arr;
    }
}

// Examples:

// Input: a[] = [1, 2, 3, 2, 1], b[] = [3, 2, 2, 3, 3, 2]
// Output: [1, 2, 3]
// Explanation: Union set of both the arrays will be 1, 2 and 3.

// Input: a[] = [1, 2, 3], b[] = [4, 5, 6] 
// Output: [1, 2, 3, 4, 5, 6]
// Explanation: Union set of both the arrays will be 1, 2, 3, 4, 5 and 6.

// Input: a[] = [1, 2, 1, 1, 2], b[] = [2, 2, 1, 2, 1] 
// Output: [1, 2]
// Explanation: Union set of both the arrays will be 1 and 2.

