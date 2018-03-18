// Time Complexity : O(n)
// Space Complexity : O(1)

// Problem : Sort an array having only 0, 1 and 2

class Sorting012 {

	public static void swap(int[] a, int i, int j) {
		if(a != null && i >= 0 && j >= 0 && i < a.length && j < a.length) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;	
		}
	}

	public static void sortPartition(int[] array) {

		if(array == null)
			return;
		
		int end0 = -1;
		int start2 = array.length;

		int i = 0;
		while(i < start2) {
			if(array[i] == 0) {
				end0++;
				swap(array, end0, i);
			}
			else if(array[i] == 2) {
				start2--;
				swap(array, start2, i);
				continue;
			}
			i++;
		}
		
	}
	
	public static void main(String[] argv) {
		int[] array = {2,0,1,2,1,0,1,0,0,2,1,1,1,2,1,0,0,2,0,2,0,0,2,0,1,1,1,0,1,0,0,2};
		//int[] array = null;
		sortPartition(array);
		if(array != null) {
			for(int num : array)
				System.out.print(num + " ");
		}
		System.out.println();
	}
}