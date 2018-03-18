//Time Complexity : O(nlogn)  Worst case : (n^2)
//Space Complexity : O(logn)  Worst case : (n)

/*
Given N nuts and N bolts. There is 1:1 mapping between nuts and bolts. You can't compare nut with other nuts or bolt with bolt. But you can compare nut with bolt.
*/

class NutsBolts {

	public static void swap(int[] a, int i, int j) {
		if(a != null && i >= 0 && j >= 0 && i < a.length && j < a.length) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;	
		}
	}
	
	public static int partition(int[] array1, int[] array2, int start, int end, int element) {
		
		int i = start - 1;
		int j = start;
		//Partiting array2.
		while(j < end) {
			if(array2[j] == element) {
				swap(array2, j , end);
				continue;
			}
			else if(array2[j] < element) {
				i++;
				swap(array2, i, j);
			}
			j++;
		}

		i++;
		swap(array2, i, end);

		//Partiting array1.
		element = array2[i];
		i = start - 1;
		j = start;

		while(j < end) {
			if(array1[j] == element) {
				swap(array1, j , end);
				continue;
			}
			else if(array1[j] < element) {
				i++;
				swap(array1, i, j);
			}
			j++;
		}

		i++;
		swap(array1, i, end);
		
		return i;
	}

	public static void mapNutsBolts(int[] nuts, int[] bolts, int low, int high) {

		if(nuts == null || bolts == null || low >= high)
			return;
		
		int index = partition(nuts, bolts, low, high, nuts[low]);
		mapNutsBolts(nuts, bolts, low, index - 1);
		mapNutsBolts(nuts, bolts, index + 1, high);
	}

	public static void main(String[] argv) {
		int[] array1 = new int[] {23,4,1,8,3,10,5,42};
		int[] array2 = new int[] {8,42,10,5,23,4,1,3};
		mapNutsBolts(array1, array2, 0, array1.length - 1);
		for(int num : array1)
			System.out.print(num + " ");
		System.out.println();
		for(int num : array2)
			System.out.print(num + " ");
		System.out.println();
	}
}