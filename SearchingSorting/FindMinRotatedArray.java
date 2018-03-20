// Time Complexity : O(logn)
// Space Complexity : O(1)

//Find the minimum element in a sorted array rotated at some pivot element.

class FindMinRotatedArray {

	public static int modifiedBinSearch(int array[]) {
		
		if(array == null || array.length == 0)
			return -1;
		
		int low = 0;
		int high = array.length - 1;
		int index = -1;
		int min = Integer.MAX_VALUE;

		while(low <= high) {

			int mid = low + (high - low)/2;

			if(array[mid] < array[high]) {
				if(array[mid] < min) {
					index = mid;
					min = array[mid];
				}
				high = mid - 1;
			}
			else {
				if(array[low] < min) {
					min = array[low];
					index = low;
				}
				low = mid + 1;
			}
		}
		return index;
	}

	
	public static void main(String[] argv) {
		int[] array = new int[]{1,2,3,4,5,6,7,8,9};
		System.out.println(modifiedBinSearch(array));		//will return -1 if we use (low < high)
	}
}