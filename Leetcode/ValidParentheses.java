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

		if(s.length() == 1)
			return false;
		
		Stack<Character> stack = new Stack<>();
		int index = 0;

		while(index != s.length() && stack.size() <= s.length() - index) {
			if(s.charAt(index) != '}' && s.charAt(index) != ')' && s.charAt(index) != ']')
				stack.push(s.charAt(index));
			else if(stack.isEmpty() || match(s.charAt(index)) != stack.pop())
				return false;
			index++;
		}

		if(stack.isEmpty() && index == s.length())
			return true;
		return false;		
	}

	public static void main(String[] argv) {
		System.out.println(isValid("{}()(){}"));
		System.out.println(isValid("{()(){}"));
		System.out.println(isValid("{}()](){}"));
		System.out.println(isValid("{}()[(){}"));
	}
}
