// Time Complexity : O(logn)
// Space Complexity : O(1)

//Find the minimum element in a sorted array rotated at some pivot element.

class FindMinRotatedArray {

	public static int modifiedBinSearch(int a[]) {
		
		if(a == null || a.length == 0)
			return -1;
		
		int low = 0;
		int high = a.length - 1;
		int index = -1;
		int min = Integer.MAX_VALUE;

		while(low <= high) {

			int mid = low + (high - low)/2;

			if(a[mid] < a[high]) {
				if(a[mid] < min) {
					index = mid;
					min = a[mid];
				}
				high = mid - 1;
			}
			else {
				if(a[low] < min) {
					min = a[low];
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