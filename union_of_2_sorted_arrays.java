// Two Pointer (Merge-Based) Approach -> O(n + m)
class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> res = new ArrayList<>();
        
        int n1 = a.length;
        int n2 = b.length;
        
        int left = 0, right = 0;
        
        while(left < n1 && right < n2) {
            if(left > 0 && a[left] == a[left - 1]) {
                left++;
                continue;
            }
            
            if(right > 0 && b[right] == b[right - 1]) {
                right++;
                continue;
            }
            
            if(a[left] > b[right]) {
                res.add(b[right++]);
            } else if(a[left] < b[right]) {
                res.add(a[left++]);
            } else {
                res.add(a[left]);
                left++;
                right++;
            }
        }
        
        while(left < n1) {
            if(left == 0 || a[left] != a[left - 1]) {
                res.add(a[left]);
            }
            
            left++;
        }
        
        while(right < n2) {
            if(right == 0 || b[right] != b[right - 1]) {
                res.add(b[right]);
            }
            
            right++;
        }

      // while(left < n1) {
      //       if(left > 0 && a[left] == a[left - 1]) {
      //           left++;
      //       } else {
      //           res.add(a[left++]);
      //       }
      //   }
        
      //   while(right < n2) {
      //       if(right > 0 && b[right] == b[right - 1]) {
      //           right++;
      //       } else {
      //           res.add(b[right++]);
      //       }
      //   }
        
        return res;
    }
}

// Examples:

// Input: a[] = [1, 2, 3, 4, 5], b[] = [1, 2, 3, 6, 7]
// Output: [1, 2, 3, 4, 5, 6, 7]
// Explanation: Distinct elements including both the arrays are: 1 2 3 4 5 6 7.

// Input: a[] = [2, 2, 3, 4, 5], b[] = [1, 1, 2, 3, 4]
// Output: [1, 2, 3, 4, 5]
// Explanation: Distinct elements including both the arrays are: 1 2 3 4 5.

// Input: a[] = [1, 1, 1, 1, 1], b[] = [2, 2, 2, 2, 2]
// Output: [1, 2]
// Explanation: Distinct elements including both the arrays are: 1 2.

