//Time Complexity : O(n)
//Space Complexity : O(n)

import java.util.Stack;

class Stock3 {
    public static int maxProfit(int[] prices) {
        if((prices == null) || (prices.length < 2)) {
            return 0;
        }
    
        int min = prices[0];
        int maxProfit = 0;

        Stack<Integer> stack = new Stack<>();
       
        stack.push(maxProfit);

        for(int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, (prices[i] - min));
            min = Math.min(min, prices[i]);
            stack.push(maxProfit);
        }

        min = prices[prices.length - 1];
        maxProfit = 0;

        int result = 0;


        for(int i = prices.length - 1; i > -1; i--) {
            maxProfit = Math.max(maxProfit, (min - prices[i]));
            min = Math.max(min, prices[i]);
            result = Math.max(result, stack.pop() + maxProfit);
        }
        return result;
    }

    public static void main(String[] argv) {
        int  a = maxProfit(new int[] {7,6,4,3,1,20});
        System.out.println(a);
        //System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }
}
