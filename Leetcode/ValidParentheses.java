//Time Complexity : O(n)
//Space Complexity : O(n)

//Problem  : Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

import java.util.Stack;

class ValidParentheses {

	public static char match(char c) {
		if(c == ')')
			return '(';
		else if( c == '}')
			return '{';
		return '[';
	}

	public static boolean isValid(String s) {

		if(s == null || s.length() == 0)
			return true;

		if(s.length() % 2 != 0)
			return false;
		
		Stack<Character> stack = new Stack<>();
		int index = 0;

		while(index < s.length()) {
			if(s.charAt(index) != '}' && s.charAt(index) != ')' && s.charAt(index) != ']')
				stack.push(s.charAt(index));
			else if(stack.isEmpty() || match(s.charAt(index)) != stack.pop())
				return false;
			index++;
		}
		
		return stack.isEmpty();	
	}

	public static void main(String[] argv) {
		System.out.println(isValid("{}()(){}"));
		System.out.println(isValid("{()(){}"));
		System.out.println(isValid("{}()](){}"));
		System.out.println(isValid("{}()[(){}"));
	}
}
