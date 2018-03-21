//Time Complexity : O(n)
//Space Complexity: O(1)

class IsSubsequence {
	
	public static boolean check(String a, String b) {
		
		if((b == null) || (b.isEmpty()))
			return true;

		if(a == null || a.length() < b.length())
			return false;

		int indexA = 0;
		int indexB = 0;

		while(indexA < a.length()) {
			if(a.charAt(indexA) == b.charAt(indexB)) {
				indexA++;
				indexB++;
			}
			else
				indexA++;
		}

		if(indexB == b.length())
			return true;
		return false;
	}

	public static void main(String[] argv) {
		System.out.println(check("abcdbc", "abcdbcb"));
		System.out.println(check("abchyewjdjsahbbcb", "abcdbcb"));
	}
}
