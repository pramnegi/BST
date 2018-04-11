//Time Complexity  : O(n)
//Space Complexity  : O(n)

// Problem : To find length of longest valid parentheses subsequence.

import java.util.Stack;

class LongestValidParentheses {

	public static int findLVP(String s) {
        if ((s == null) || (s.isEmpty())) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        
        stack.push(-1);

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            Character currentChar = s.charAt(i);
            if (currentChar == '(') {
                stack.push(i);
            } else {
                Integer top = stack.pop();
            
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }

	public static void main(String[] argv) {
		System.out.println(findLVP("(()()(())(("));
		System.out.println(findLVP("()(())"));
		System.out.println(findLVP(")()(((())))("));
		System.out.println(findLVP("(()((()"));
		System.out.println(findLVP("()()"));
		System.out.println(findLVP("()()((())()()())))(()()()()()()()()())))"));
		System.out.println(findLVP("()()(((((())()())"));
		System.out.println(findLVP("()(((()()()())()()()))))))())()()())()()()))))()()((()()()()((()()()())))))))))()))"));
	}
}
