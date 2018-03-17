class Partition {
	
	public static int partition(int[] array, int low, int high) {
		int i = low - 1;
		int element = array[high];
		for(int j = i+1 ; j < high; j++) {
			if(array[j] < element) {
				i++;
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
			}
		}
		i++;
		int temp = array[i];
		array[i] = array[high];
		array[high] = temp;
		return i;
	}

	public static void main(String[] argv) {
		int[] array = {2,0,1,2,1,0,1,0,1,1,2,1,0,0,2,0,2,0,0,2,0,1,1,1,0,1,0,0,2};
		int index = partition(array, 0, array.length - 1);
		System.out.println(index);
		for(int num : array)
			System.out.print(num + " ");
		System.out.println();
	}
}