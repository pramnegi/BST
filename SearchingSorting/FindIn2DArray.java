//Time Complexity: O(n+m)
//Time Complexity: O(1)

class FindIn2DArray {
	
	public static int[] findElement(int[][] array, int element) {
		
		if(array == null || array.length == 0)
			return null;

		int row = array.length - 1;
		int column = 0;

		while( row >= 0 && column < array[0].length) {
			if(array[row][column] == element)
				return new int[] {row, column};
			else if(array[row][column] > element)
				row--;
			else
				column++;
		}
		return null;
	}

	public static void main(String[] agrv) {
		
		int[][] array = new int[][] {{9,18,32,40,60}, {12,19,42,45,68},{39,40,45,46,70},{50,60,80,90,92}};
		
		int[] result = findElement(array, 43);
		
		if(result != null)
			System.out.println("Element found at array[ " + result[0] + " , " + result[1] + " ]");
		else
			System.out.println("Element not found");

		result = findElement(array, 50);

		if(result != null)
			System.out.println("Element found at array[" + result[0] + ", " + result[1] + "]");
		else
			System.out.println("Element not found");

	}
}