//Time Complexity : O(n)
//Space Complexity : O(n)

//Problem : Find length of longest zigzag subsequence (A sequence of numbers is called a zig-zag sequence if the differences between successive numbers strictly alternate between positive and negative.)

import java.util.Arrays;

class ZigZag {
	
	public static int longestZigZag(int[] sequence) {

		if(sequence == null)
			return 0;

		if(sequence.length < 2)
			return sequence.length;

		Boolean[] check = new Boolean[sequence.length];				//True if last tuple of the sequnece is increasing else false.
		int[] solution = new int[sequence.length];

		Arrays.fill(solution, 1);
		int result = 1;

		for(int i = 1; i < sequence.length; i++) {

			if(sequence[i] > sequence [0]) {
				solution[i] = 2;
				check[i] = true;
				result = 2;
			}
			else if(sequence[i] < sequence [0]) {
				solution[i] = 2;
				check[i] = false;
				result = 2;
			}

			for(int j = i-1; j > 0; j--) {
				if(sequence[j] > sequence[i] && check[j]) {
					if(solution[j] + 1 > solution[i]) {
						solution[i] = 1 + solution[j];
						check[i] = false;
					}
				}
				else if(sequence[j] < sequence[i] && !check[j]) {
					if(solution[j] + 1 > solution[i]) {
						solution[i] = 1 + solution[j];
						check[i] = true;
					}
				}
			}
			result = Math.max(result, solution[i]);
		}
		return result;
	}

	public static void main(String[] argv) {
		System.out.println(longestZigZag(new int[] {1,7,4,9,2,5}));
		System.out.println(longestZigZag(new int[] {1,17,5,10,13,15, 10, 5, 16,8}));
		System.out.println(longestZigZag(new int[] {1,2,3,4,5,6,7,8,9}));
		System.out.println(longestZigZag(new int[] {70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 100, 19, 7, 5, 5, 5, 1000, 32, 32}));
		System.out.println(longestZigZag(new int[] {374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 249, 22, 176, 279, 23, 22, 617, 462, 459, 244}));
	}
}