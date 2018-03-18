// Time Complexity : O(logn)
// Space Complexity : O(1)

class BinarySearch {

	public static int binarySearch(int[] a, int element)	{
		
		if(a == null)
			return -1;
		
		int low = 0;
		int high = a.length - 1;
		while(low < high) {
			int mid = low + (high - low)/2;
			if(a[mid] == element)
				return mid;
			else if(a[mid] > element)
				high = mid - 1;
			else
				low = mid + 1;
		}
		if(a[high] == element)
			return high;
		return -1;
		
	}

	
	public static void main(String[] argv) {
		int[] array = new int[]{-31,-1,3,4,5,10,20,63,67,75,89,90,99,9};
		System.out.println(binarySearch(array, -1));
	}
}