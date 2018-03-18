// Time Complexity : O(n)
// Space Complexity : O(1)

import java.util.ArrayList;

class FindTuples {

	public static int tuples(int[] a, int sum, ArrayList<ArrayList<Integer>> list) {
		if(a == null)
			return;
		int low = 0, result = 0,  high = a.length - 1;
		while(low < high) {
			if(a[low] + a[high] == sum) {
				int countLow = 1;
				int countHigh = 1;
				//Counting freq of a[low] and a[high].
				while(low+1 < a.length && a[low] == a[low + 1]) {
					countLow++;
					low++;
				}
				while(high-1 > 0 && a[high] == a[high - 1]) {
					countHigh++;
					high--;
				}

				result += countLow * countHigh;

				for(int k = 0; k < countLow * countHigh; k++) {
					ArrayList<Integer> temp = new ArrayList<>();
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
	
	public static void main(String[] argv) {
		int[] array = new int[]{-31,-31,1,3,4,5,10,20,63,67,75,89,90,99,99};
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		System.out.println(tuples(array, 68,list));
		System.out.println(list);
		array = new int[]{-31,-31,-31,-31,99,99};
		System.out.println(tuples(array, 68,list));
	}
}