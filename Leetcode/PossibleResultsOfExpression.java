//Time Complexity  : O(n^2)
//Space Complexity  : O(n)

/*
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. 
The valid operators are +, - and *.
*/

import java.util.ArrayList;

class PossibleResultsOfExpression {

	public static boolean isOperator(char op) {
		if(op == '+' || op == '-' || op == '*')
			return true;
		return false;
	}
	
	public static ArrayList<Integer> diffWaysToCompute(String expression) {

		ArrayList<Integer> result = new ArrayList<>();

		if(expression == null || expression.length() == 0)
			return result;

		/*if(expression.length() == 1) {
			result.add(expression);
			return result
		}*/
		for(int i = 0; i < expression.length(); i++) {

			if(isOperator(expression.charAt(i))) {

				ArrayList<Integer> leftValue = diffWaysToCompute(expression.substring(0, i));
				ArrayList<Integer> rightValue = diffWaysToCompute(expression.substring(i + 1));
				System.out.print(leftValue + " ");
				System.out.println(rightValue);
				for(int num1 : leftValue) {
					for(int num2 : rightValue) {
						switch(expression.charAt(i)) {
							case '+' : result.add(num1 + num2); break;
							case '-' : result.add(num1 - num2); break;
							case '*' : result.add(num1 * num2);
						}
					}
				}
			}
		}
		if(result.isEmpty())
			result.add(Integer.parseInt(expression));
		return result;
	}

	public static void main(String[] argv) {
		System.out.println(diffWaysToCompute("3*2+1*2"));
		System.out.println(diffWaysToCompute("30*2+1*2"));
	}
}