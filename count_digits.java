class Solution {
    static int evenlyDivides(int n) {
        int count = 0;
        int num = n;
        
        while(num > 0) {
            int dig = num % 10;
            
            if(dig == 0) {
                num /= 10;
                continue;
            }
            
            int rem = n % dig;
            
            if(rem == 0) count++;
            
            num /= 10;
        }
        
        return count;
    }
}

// Examples :

// Input: n = 12
// Output: 2
// Explanation: 1, 2 when both divide 12 leaves remainder 0.

// Input: n = 2446
// Output: 1
// Explanation: Here among 2, 4, 6 only 2 divides 2446 evenly while 4 and 6 do not.

// Input: n = 23
// Output: 0
// Explanation: 2 and 3, none of them divide 23 evenly.

  
