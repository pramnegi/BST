// Time Complexity : O(n)
// Space Complexity : O(1)

class ArrayRangeN {

	public static int[] sortArrayN(int[] array) {

		int len = array.length;
		
		for(int i = 0; i < len; i++) {
				int value = array[i] % (len + 1);
				array[value - 1] += value * (len + 1);
		}

		for(int i = 0; i < len; i++) 
			array[i] /= (len + 1);
		return array;
	}
	
	public static void main(String[] argv) {
		int[] array = {13,1,8,12,6,15,4,11,9,10,2,14,3,7,5};
		sortArrayN(array);
		for(int num : array)
			System.out.print(num + " ");
		System.out.println();
	}
}