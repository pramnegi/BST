//Time Complexity : O(n)
//Space Complexity : O(1)

class Stock1 {
    public int maxProfit(int[] prices) {
        if((prices == null) || (prices.length < 2)) {
            return 0;
        }
        
        int min = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, (prices[i] - min));
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    public static void main(String[] argv) {
        int  a = maxProfit(new int[] {7,6,4,3,1,20});
        System.out.println(a);
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
