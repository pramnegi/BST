// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class FindTuples {

	public static boolean binarySearch(int[] a, int low, int high, int element)	{
		while(low <= high) {
			int mid = (low + high)/2;
			if(a[mid] == element)
				return true;
			else if(a[mid] > element)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
		
	}

	public static int tuples(int[] a, int sum) {
		int result = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] > sum)
				return result;
			if(binarySearch(a, i + 1, a.length - 1, sum - a[i]))
				result++;
		}
		return result;
	}
	
	public static void main(String[] argv) {
		int[] array = new int[]{-31,1,3,4,5,10,20,63,67,75,89,90,99};
		System.out.println(tuples(array, 68));
	}
}