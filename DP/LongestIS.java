//Time Complexity : O(n^2)
//Space Complexity : O(n)

//Given an unsorted array of integers, find the length of longest increasing subsequence. 

class LongestIS {

	public static int lengthOfLIS(int[] nums) {

		if(nums == null || nums.length == 0)
			return 0;
		
		int[] solution = new int[nums.length];
		
		for(int i = 0; i < solution.length; i++)
			solution[i] = 1;

		int max = 1;
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i]) {
					solution[i] = Math.max(solution[j] + 1, solution[i]);
					max = Math.max(max, solution[i]);
				}
			}
		}
		return max;
	}

    public static void main(String[] agrv) {
    	System.out.println(lengthOfLIS(new int[] {10,9,2,5,3,7,101,18}));
    }
}
