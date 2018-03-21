//Time Complexity: O(logn)
//Time Complexity: O(1)

class SquareRoot {
	
	public static int sqrt(int num) {

		long low = 0, high = (long)num, prev = 0;

		if(num < 2)
			return num;
		long mid = low + (high - low)/2;

		while(mid * mid != num && prev != mid) {
			if(mid * mid > num) {
				prev = mid;
				high = mid;
			}
			else {
				low = mid;
				prev = mid;
			}
			mid = low + (high - low)/2;
		}
		return (int)mid;
	}

	public static void main(String[] argv) {
		System.out.println(sqrt(40));
		System.out.println(sqrt(0));
		System.out.println(sqrt(1));
		System.out.println(sqrt(2));
		System.out.println(sqrt(2147483647));
	}
}
