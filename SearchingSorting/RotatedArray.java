// Time Complexity : O(nlogn)
// Space Complexity : O(1)

//Search an element in sorted rotated array.

class RotatedArray {

	public static int modifiedBinSearch(int a[], int element) {
		
		if(a == null)
			return -1;
		
		int low = 0;
		int high = a.length - 1;

		while(low <= high) {

			int mid = low + (high - low)/2;

			if(a[mid] == element)
				return mid;
			else if(a[mid] < a[high]) {
				if(element > a[mid] && element <= a[high]) 
					low = mid + 1;
				else
					high = mid - 1;
			}
			else {
				if(element < a[mid] && element >= a[low]) 
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] argv) {
		int[] array = new int[]{9,10,11,2,3,4,5,6,7,8};
		System.out.println(modifiedBinSearch(array, 9));
		System.out.println(modifiedBinSearch(array, 10));
		System.out.println(modifiedBinSearch(array, 14));
	}
}