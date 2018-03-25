//Time Complexity : O(2^n)
//Space Complexity : O(n)

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

import java.util.ArrayList;

class GenerateParentheses {

	public static void generateParentheses(String str, int left, int right, ArrayList<String> result) {
		if(left > right)
			return;
		
		if(left == 0 && right == 0) {
			result.add(str);
			return;
		}
		
		if(left > 0)
			generateParentheses(str + "(", left - 1, right, result);
		if(right > 0)
			generateParentheses(str + ")", left, right - 1, result);
	}

	//Wrapper function to call generateParentheses.
	public static ArrayList<String> generateParentheses(int num) {
		ArrayList<String> list = new ArrayList<>();
		
		if(num == 0)
			return list;

		if(num == 1) {
			list.add("()");
			return list;
		}

		generateParentheses("", num, num, list);
		return list;
	}


	public static void main(String[] argv) {
		System.out.println(generateParentheses(3));
	}
}
