// Time Complexity : O(n);
// Space Complexity : O(1);

//Find duplicate element in an array of size N+1 having number from 1-N only one element repeated.

class DuplicateNumber {
	
	public static int findDuplicate(int[] array) {
		if(array == null || array.length <= 1)
			return -1;
		int temp = 1;
		for(int i = 2; i < array.length; i++)
			temp = temp^i;
		for(int num : array)
			temp = temp^num;
		return temp;
	}

	public static void main(String[] argv) {
		System.out.println(findDuplicate(new int[] {3,2,4,6,5,1,4}));
		System.out.println(findDuplicate(null));
	}
}