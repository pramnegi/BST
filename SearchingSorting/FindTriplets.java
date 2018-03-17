//Time Complexity : O(n^2)

import java.util.ArrayList;

class FindTriplets {
	// k is the first number amongs the triplets.

	public static int tuples(int[] a, int low, int high, int sum, ArrayList<ArrayList<Integer>> list, int k) {
		int result = 0;
		while(low < high) {
			if(a[low] + a[high] == sum) {
				int countLow = 1;
				int countHigh = 1;
				//Counting number of freq of a[low] and a[high].
				while(low+1 < a.length && a[low] == a[low + 1]) {
					countLow++;
					low++;
				}
				while(high-1 > 0 && a[high] == a[high - 1]) {
					countHigh++;
					high--;
				}

				result += countLow * countHigh;

				for(int l = 0; l < countLow * countHigh; l++) {
					ArrayList<Integer> temp = new ArrayList<>();
					temp.add(k);
					temp.add(a[low]);
					temp.add(a[high]);
					list.add(temp);
				}

				low++;
				high--;

			}
			else if(a[low] + a[high] > sum)
				high--;
			else
				low++;
		}
		return result;
	}

	public static int triplets(int[] a, int sum) {
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int result = 0;
		for(int i = 0; i < a.length; i++) {
			result += tuples(a, i+1, a.length-1, sum - a[i], list, a[i]);
		}
		System.out.println(list);
		return result;
	}
	
	public static void main(String[] argv) {
		int[] array = new int[]{-31,1,3,4,5,10,20,63,67,75,89,90,99};
		System.out.println(triplets(array, 68));
	}
}