//Time Complexity: O(logn)
//Time Complexity: O(1)

//Can check sum for the sum of odd number. Complexity O(n)

class IsPerfectSquare {

	public static boolean check(int num) {
		if (num <= 0) {
            return false;
        }
        
        if(num == 1) {
            return true;
        }

        int left = 1;
        int right = num / 2;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if((mid * mid) == num)
                return true;
            if( mid < (num/mid)) 
                left = mid + 1;
            else 
                right = mid - 1;
        }
        
        return false;
	}
	
	public static boolean sqrt(int num) {

		long low = 0, high = (long)num, prev = 0;

		if(num < 1)
			return false;
		if(num == 1)
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
		System.out.println(check(40));
		System.out.println(sqrt(121));
		System.out.println(check(121));
		System.out.println(sqrt(2147483647));
		System.out.println(check(2147483647));
	}
}
