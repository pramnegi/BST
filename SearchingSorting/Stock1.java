//Time Complexity : O(n)
//Space Complexity : O(1)

class Stock1 {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        
        int tempProfit = 0, profit = 0;
        int index = 0;
               
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < prices[index]) {
                index = i;
                profit = tempProfit > profit ? tempProfit : profit;
                tempProfit = 0;
            }
            else {
                tempProfit = prices[i] - prices[index] > tempProfit ? prices[i] - prices[index] : tempProfit;
            }
        }
        return tempProfit > profit ? tempProfit : profit;
    }

    public static void main(String[] argv) {
        int  a = maxProfit(new int[] {7,6,4,3,1,20});
        System.out.println(a);
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}