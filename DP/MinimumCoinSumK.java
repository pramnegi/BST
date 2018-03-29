//Time Complexity : O(coins.length * sum)
//Space Complexity : O(n)

/*
You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.
*/

class MinimumCoinSumK {

	public static int coinChange(int[] coins, int sum) {

		if(coins == null || sum < 0)
			return -1;
		
		int[] solution = new int[sum + 1];
		Arrays.fill(solution, sum + 1);
		solution[0] = 0;

		for(int i = 1; i <= sum; i++) {
			for(int j = 0; j < coins.length; j++) {
				if(coins[j] <= i)
					solution[i] = Math.min(solution[i - coins[j]] + 1, solution[i]);
			}
		}

		return (solution[sum] > sum) ? -1 : solution[sum];
	}

	public static void main(String[] argv) {
		System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
	}
}
