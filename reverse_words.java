// Approach 1: Efficient backward traversal using StringBuilder.append(start, end) — avoids extra substring creation (O(n)).
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        boolean firstWord = true;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == '.') i--;
            if (i < 0) break;

            int j = i;
            while (i >= 0 && s.charAt(i) != '.') i--;

            if (!firstWord) sb.append('.');
            sb.append(s, i + 1, j + 1);

            firstWord = false;
        }

        return sb.toString();
    }
}

// Approach 2: Similar backward traversal but uses substring() — less efficient due to repeated new String creation (can cause TLE for large inputs).
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        boolean firstWord = true;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == '.') i--;
            if (i < 0) break;

            int j = i;
            while (i >= 0 && s.charAt(i) != '.') i--;

            if (!firstWord) sb.append('.');
            sb.append(s.substring(i + 1, j + 1));

            firstWord = false;
        }

        return sb.toString();
    }
}

// Approach 3: Split by '.' then filter, reverse, and join — simple and readable, but split() on single '.' doesn’t merge multiple dots correctly.
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\.");
        
        ArrayList<String> arr = new ArrayList<>();
        
        for(String word : words) {
            if(!word.isEmpty()) arr.add(word);
        }
        
        Collections.reverse(arr);
        
        return String.join(".", arr);
    }
}

// Approach 4: Split by one or more dots ("\\.+") to automatically ignore extra dots — cleanest and most concise split-based approach (O(n)).
class Solution {
    public String reverseWords(String s) {
        String[] words = s.split("\\.+");
        
        ArrayList<String> arr = new ArrayList<>();
        
        for(String word : words) {
            if(!word.isEmpty()) arr.add(word);
        }
        
        Collections.reverse(arr);
        
        return String.join(".", arr);
    }
}

// Examples :

// Input: s = "i.like.this.program.very.much"
// Output: "much.very.program.this.like.i"
// Explanation: The words in the input string are reversed while maintaining the dots as separators, resulting in "much.very.program.this.like.i".

// Input: s = "..geeks..for.geeks."
// Output: "geeks.for.geeks"
// Explanation: After removing extra dots and reversing the whole string, the input string becomes "geeks.for.geeks".

// Input: s = "..home....."
// Output: "home"
// Explanation: The input string contains only one word with extra dots around it. After removing the extra dots, the output is "home".

