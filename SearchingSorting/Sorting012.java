// Time Complexity : O(n)
// Space Complexity : O(1)

class Sorting012 {

	public static void sortPartition(int[] array, int start, int end, int element) {
		
		if(element == 3)
			return;

		int i = start - 1;
		//Sort 0
		for(int j = start; j <= end; j++) {
			if(array[j] < element) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}

		element++;
		//Sort 1.
		for(int j = i+1; j <= end; j++) {
			if(array[j] < element) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
	}
	
	public static void main(String[] argv) {
		int[] array = {2,0,1,2,1,0,1,0,1,1,2,1,0,0,2,0,2,0,0,2,0,1,1,1,0,1,0,0,2};
		sortPartition(array, 0, array.length-1, 1);
		for(int num : array)
			System.out.print(num + " ");
		System.out.println();
	}
}