class Solution {
    public boolean isBalanced(String s) {
        if(s.isEmpty()) return true;
        if(s.length() == 1) return false;
        
        Stack<Character> stk = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '[' || ch == '{') {
                stk.push(ch);
            } else {
                if(ch == ')') {
                    if(stk.isEmpty() || stk.pop() != '(') {
                        return false;
                    }
                }
                
                if(ch == ']') {
                    if(stk.isEmpty() || stk.pop() != '[') {
                        return false;
                    }
                }
                
                if(ch == '}') {
                    if(stk.isEmpty() || stk.pop() != '{') {
                        return false;
                    }
                }
            }
        }
        
        return stk.isEmpty();
    }
}

// Examples :

// Input: s = "[{()}]"
// Output: true
// Explanation: All the brackets are well-formed.

// Input: s = "[()()]{}"
// Output: true
// Explanation: All the brackets are well-formed.

// Input: s = "([]"
// Output: false
// Explanation: The expression is not balanced as there is a missing ')' at the end.

// Input: s = "([{]})"
// Output: false
// Explanation: The expression is not balanced as there is a closing ']' before the closing '}'.

