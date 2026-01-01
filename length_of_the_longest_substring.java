// Uses a sliding window with a HashMap to maintain character frequencies and dynamically adjust the window to ensure all characters remain unique while tracking the maximum window length.
class Solution {
    int longestUniqueSubstring(String s) {
        int winStart = 0;
        int maxLen = Integer.MIN_VALUE;
        int n = s.length();
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            
            while(map.get(ch) > 1) {
                char curr = s.charAt(winStart);
                map.put(curr, map.get(curr) - 1);
                
                if(map.get(curr) == 0) map.remove(curr);
                
                winStart++;
            }
            
            maxLen = Math.max(maxLen, i - winStart + 1);
        }
        
        return maxLen;
    }
}

// Examples:

// Input: s = "geeksforgeeks"
// Output: 7
// Explanation: Longest substring is "eksforg".

// Input: s = "abdefgabef"
// Output: 6
// Explanation: Longest substring are "abdefg" , "bdefga" and "defgab".

// Input: s = "aaaaa"
// Output: 1
// Explanation: Longest substring is "a".

