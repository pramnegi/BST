//Time Complexity: O(logn)
//Time Complexity: O(1)

class IsPerfectSquare {
	
	public static boolean sqrt(int num) {

		long low = 0, high = (long)num, prev = 0;

		if(num < 2)
			return true;
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

		if(mid * mid == num)
			return true;
		return false;
	}

	public static void main(String[] argv) {
		System.out.println(sqrt(40));
		System.out.println(sqrt(0));
		System.out.println(sqrt(1));
		System.out.println(sqrt(121));
		System.out.println(sqrt(2147483647));
	}
}
