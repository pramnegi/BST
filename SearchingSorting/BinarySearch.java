// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class BinarySearch {

	public static int binarySearch(int[] a, int element)	{
		int low = 0;
		int high = a.length - 1;
		while(low <= high) {
			int mid = (low + high)/2;
			if(a[mid] == element)
				return mid;
			else if(a[mid] > element)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return -1;
		
	}

	
	public static void main(String[] argv) {
		int[] array = new int[]{-31,1,3,4,5,10,20,63,67,75,89,90,99};
		System.out.println(binarySearch(array, 20));
	}
}