// Time Complexity : O(n)
// Space Complexity : O(1)

class Sorting01 {

	public static int[] sortArray(int[] array) {

		if(array.length == 0)
			return array;
		
		int endIndex = array.length - 1;	//After index endIndex every element in the array will be 1.

		for(int i = 0; i < array.length; i++) {

			if(array[i] == 1) {

				if(endIndex < i)		
					break;

				while(endIndex > i && array[endIndex] == 1) 		//Checking for the index where a[i] = 0 so that we can swap it with 1.
					endIndex--;

				int temp = array[endIndex];
				array[endIndex] = array[i];
				array[i] = temp;
				endIndex--;
			}
		}
		return array;
	}
	
	public static void main(String[] argv) {
		int[] array = {0,1,1,0,1,0,1,1,1,0,0,0,0,0,0,1,1,1,0,1,0,0};
		sortArray(array);
		for(int num : array)
			System.out.print(num + " ");
		System.out.println();
	}
}