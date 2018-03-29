//Time Complexity : O(n^2)
//Space Complexity : O(n)

//Problem : donations[i] represent the amount resident[i] is willing to pay. Find maximum amount of donations that can be collected if no neighbour is willing to contribute to a fund to which his neighbor has also contribute(last resident is the neighbour of 0th resident)

class BadNeighbors {

	public static int maxDonations(int[] donations) {

		if(donations == null || donations.length == 0)
			return 0;
		if(donations.length == 1)
			return donations[0];

		int[] solution = new int[donations.length];
		
		System.arraycopy(donations, 0, solution, 0, donations.length);

		int maxDonation = solution[0];

		for(int i = 1; i < donations.length; i++) {
			for(int j = i - 2; j >= 0; j--) {
				if((i + 1) % donations.length != j)
					solution[i] = Math.max(solution[i], solution[j] + donations[i]);
			}
			maxDonation = Math.max(maxDonation, solution[i]);
		}

		return maxDonation;
	}

	public static void main(String[] argv) {
		System.out.println(maxDonations(new int[] {10, 3, 2, 5, 7, 8}));
		System.out.println(maxDonations(new int[] {11, 15}));
		System.out.println(maxDonations(new int[] {7, 7, 7, 7, 7, 7, 7}));
		System.out.println(maxDonations(new int[] {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}));
		System.out.println(maxDonations(new int[] { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72}));
	}	
}