//Time Complexity  : O(n)
//Space Complexity  : O(n)

// Problem : To find length of longest valid parentheses subsequence.

import java.util.Stack;

class LongestValidParentheses {

	public static int findLVP(String s) {

		Stack<String> stack = new Stack<>();

		int result = 0, temp = 0;

		if(s == null || s.length() < 2)
			return 0;

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '(') {
				stack.push(Character.toString(c));
				continue;
			}
			if(!stack.isEmpty() && stack.peek().equals("(")) {
				stack.pop();
				temp = 2;
				if(!stack.isEmpty() && !stack.peek().equals("(")) {
					temp += Integer.parseInt(stack.pop());
				}
				result = Math.max(temp, result);
				stack.push(Integer.toString(temp));
			}
			else if(!stack.isEmpty()) {				//i.e number on the top of the stack.
				int top = Integer.parseInt(stack.pop());
				if(!stack.isEmpty() && !stack.peek().equals("(")) {
					temp += Integer.parseInt(stack.pop());
				}
				if(!stack.isEmpty() && stack.pop().equals("(")) {
					temp += 2;
					if(!stack.isEmpty() && !stack.peek().equals("(")) {
						temp += Integer.parseInt(stack.pop());
					}
					stack.push(Integer.toString(temp));
					result = Math.max(temp, result);
				}
			}
		}
		
		return result;
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
