// Time Complexity : O(n)
// Space Complexity : O(1)

class Sorting012 {

	/*public static void sortPartition(int[] array, int start, int end, int element) {
		
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
	}*/

	public static void sortPartition(int[] array) {
		
		int end0 = -1;
		int start2 = array.length;

		for(int i = 0; i < start2; i++) {
			if(array[i] == 0) {
				end0++;
				int temp = array[end0];
				array[end0] = array[i];
				array[i] = temp;
			}
			else if(array[i] == 2) {
				start2--;
				int temp = array[start2];
				array[start2] = array[i];
				array[i] = temp;
				i--;
			}
		}
		
	}
	
	public static void main(String[] argv) {
		int[] array = {2,0,1,2,1,0,1,0,0,2,1,1,1,2,1,0,0,2,0,2,0,0,2,0,1,1,1,0,1,0,0,2};
		sortPartition(array);
		for(int num : array)
			System.out.print(num + " ");
		System.out.println();
	}
}