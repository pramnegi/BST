//Time Complexity : O(n)
//Space Complexity : O(1)

class Stock2 {
    public static int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0)
            return 0;
        
        int profit = 0, currentPrice = prices[0];
        
        /* int tempProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < currentPrice) {
                currentPrice = prices[i];
                tempProfit = 0;
            }
            else {
                tempProfit = prices[i] - currentPrice;
                currentPrice = prices[i];
            }
            profit += tempProfit;
        }*/

        int i = 1;

        while(i < prices.length) {
            while(i < prices.length && prices[i] <= prices[i - 1]) {
                i++;
            }
            currentPrice = prices[i-1];
            while(i < prices.length &&  prices[i - 1] <= prices[i]) {
                i++;
            }
            profit += prices[i-1]-currentPrice;
        }
        return profit;
    }

    public static void main(String[] argv) {
        int  a = maxProfit(new int[] {2,4,1,3,4,76,12,3,45,778,0});
        System.out.println(a);
        //System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}